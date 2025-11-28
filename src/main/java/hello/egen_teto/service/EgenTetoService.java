package hello.egen_teto.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import hello.egen_teto.domain.*;
import hello.egen_teto.dto.ResultDtO;
import hello.egen_teto.repository.AnswerRepository;
import hello.egen_teto.repository.QuestionRepository;
import hello.egen_teto.repository.TestResultRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Service
public class EgenTetoService {

    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;
    private final TestResultRepository testResultRepository;

    @Autowired
    public EgenTetoService(QuestionRepository questionRepository, AnswerRepository answerRepository, TestResultRepository testResultRepository) {
        this.questionRepository = questionRepository;
        this.answerRepository = answerRepository;
        this.testResultRepository = testResultRepository;
    }

    @Transactional
    @PostConstruct
    public void listToDatabase() {
        if (questionRepository.count() > 0 ) {
            return;
        }

        List<Question> questionList = jsonToList();
        for (Question q : questionList) {
            for (Answer a : q.getAnswerList()) {
                a.setQuestion(q);
            }
        }
        questionRepository.saveAll(questionList);
    }

    @Transactional
    public ResultDtO saveAndCalculateScore(Map<Long, Long> myAnswers, Tester tester) {
        List<Answer> answerList = answerRepository.findAllById(myAnswers.values());

        int egen = 0;
        int teto = 0;

        for (Answer answer : answerList) {
            Map<Category, Integer> score = answer.getScore();
            egen += score.getOrDefault(Category.EGEN, 0);
            teto += score.getOrDefault(Category.TETO, 0);
        }

        LocalDateTime time = LocalDateTime.now();

        Result result = new Result(tester.getName(), tester.getGender(), egen, teto, time);
        testResultRepository.save(result);

        String resultText = getResultText(tester, egen, teto);

        return new ResultDtO(egen, teto, resultText);
    }

    public String getResultText(Tester tester, int egen, int teto) {
        if (egen > teto) {
            return tester.getName() + "님은 " + (tester.getGender() == Tester.Gender.MALE ? "에겐남" : "에겐녀") + " 이시네요";
        } else if (egen < teto) {
            return tester.getName() + "님은 " + (tester.getGender() == Tester.Gender.MALE ? "테토남" : "테토녀") + " 이시네요";
        } else {
            return tester.getName() + "님은 반반 이시네요";
        }
    }

    private List<Question> jsonToList() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream is = getClass().getResourceAsStream("/questions.json");
            return mapper.readValue(is, new TypeReference<List<Question>>() {});
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    @Transactional(readOnly = true)
    public List<Question> getQuestionList() {
        return questionRepository.findAll();
    }
}