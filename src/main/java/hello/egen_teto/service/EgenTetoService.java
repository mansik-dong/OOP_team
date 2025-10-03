package hello.egen_teto.service;

import hello.egen_teto.domain.Question;
import hello.egen_teto.setting.SetQuestions;
import hello.egen_teto.domain.Tester;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class EgenTetoService {
    private Integer egen = 0;
    private Integer teto = 0;
    private SetQuestions setQuestions;

    public EgenTetoService(SetQuestions setQuestions) {
        this.setQuestions = setQuestions;
    }

    public void setTest(Tester tester) {
        setQuestions.setTester(tester);
        setQuestions.createQuestion();
    }

    public void calculateScore(Map<String, String> idAnswers) {
        List<Question> questionList = setQuestions.getQuestionList();
        for (Map.Entry<String, String> e : idAnswers.entrySet()) {
            Question question = questionList.stream().filter(m -> m.getId().equals(e.getKey())).findAny().get();
            Map<String, Integer> categoryScores = question.getAnswerScores().get(e.getValue());
            egen += categoryScores.getOrDefault("egen", 0);
            teto += categoryScores.getOrDefault("teto", 0);

        }
    }

    public List<Question> getQuestions() {
        return setQuestions.getQuestionList();
    }

    public int getEgen() {
        return egen;
    }

    public int getTeto() {
        return teto;
    }


}