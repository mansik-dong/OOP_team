package hello.egen_teto.domain;

import java.util.Map;

public class Answer {
    private String answerText;
    private Map<Category, Integer> scores;

    Answer() {}

    public Map<Category, Integer> getScores() {
        return scores;
    }

    public void setScores(Map<Category, Integer> scores) {
        this.scores = scores;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }
}
