package hello.egen_teto.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import hello.egen_teto.domain.Category;
import hello.egen_teto.domain.Question;
import hello.egen_teto.domain.Tester;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

@Service
public class EgenTetoService {
    private List<Question> questionList;
    private Tester tester;
    private int egen = 0;
    private int teto = 0;

    public Integer getEgen() {
        return egen;
    }

    public Integer getTeto() {
        return teto;
    }

    public void calculateScore(Map<String, String> idAnswers) {
        for (Map.Entry<String, String> e : idAnswers.entrySet()) {
            Question question = questionList.stream().filter(m -> m.getId().equals(e.getKey())).findAny()
                    .orElseThrow(() -> new RuntimeException("폼으로 받은 id와 일치하는 question 없음"));
            Map<Category, Integer> categoryScores = question.getAnswerList().stream().filter(m -> m.getAnswerText().equals(e.getValue())).findAny()
                    .orElseThrow(() -> new RuntimeException("폼으로 받은 answerText 와 일치하는 Answer 없음")).getScores();
            this.egen += categoryScores.getOrDefault(Category.EGEN, 0);
            this.teto += categoryScores.getOrDefault(Category.TETO, 0);
        }
    }

    public String getConsequenceText() {
        if (egen > teto) {
            if (tester.getGender() == Tester.Gender.MALE) {
                return tester.getName() + "님은 에겐남 이시네요";
            } else {
                return tester.getName() + "님은 에겐녀 이시네요";
            }
        } else if (egen < teto) {
            if (tester.getGender() == Tester.Gender.MALE) {
                return tester.getName() + "님은 테토남 이시네요";
            } else {
                return tester.getName() + "님은 테토녀 이시네요";
            }
        } else {
            return tester.getName() + "님은 반반 이시네요";
        }
    }

    private void jsonToList() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream is = getClass().getResourceAsStream("/questions.json");
            this.questionList = mapper.readValue(is, new TypeReference<List<Question>>() {});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clearScore() {
        this.egen = 0;
        this.teto = 0;
    }

    public List<Question> getQuestionList() {
        jsonToList();
        return this.questionList;
    }

    public void setTester(Tester tester) {
        this.tester = tester;
    }

}