package hello.egen_teto.domain;

import java.util.Map;

public class Question {
    private String id;
    private String category;
    private String text;
    private Map<Answer, Integer> answerScores;

    public Question(String id, String category, String text, Map<Answer, Integer> answerScores) {
        this.id = id;
        this.category = category;
        this.text = text;
        this.answerScores = answerScores;
    }

    public String getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public String getText() {
        return text;
    }

    public Map<Answer, Integer> getAnswerScores() {
        return answerScores;
    }
}

