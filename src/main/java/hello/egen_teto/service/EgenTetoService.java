package hello.egen_teto.service;

import hello.egen_teto.domain.Answer;
import hello.egen_teto.domain.Question;
import hello.egen_teto.setting.SetQuestions;
import hello.egen_teto.domain.Tester;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class EgenTetoService {
    private int egen = 0;
    private int teto = 0;
    private SetQuestions setQuestions;

    public EgenTetoService(SetQuestions setQuestions) {
        this.setQuestions = setQuestions;
    }

    public void setTest(Tester tester) {
        setQuestions.setTester(tester);
        setQuestions.createQuestion();
    }

    public void calculateScore(Map<String, String> idAnswers) {
        for (Map.Entry<String, String> e : idAnswers.entrySet()) {
            List<Question> questionList = setQuestions.getQuestionList();
            Question question = questionList.stream().filter(m -> m.getId().equals(e.getKey())).findAny().get();
            int score = question.getAnswerScores().get(Answer.valueOf(e.getValue()));

            switch (question.getCategory()) {
                case "egen" :
                    egen += score;
                    break;
                case "teto" :
                    teto += score;
                    break;
            }

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