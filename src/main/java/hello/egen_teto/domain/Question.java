package hello.egen_teto.domain;

import java.util.List;
import java.util.Map;

public class Question {
    private String id;
    private String text;
    private Map<String, Map<String, Integer>> answerScores;

    public Question(String id, String text, Map<String, Map<String, Integer>> answerScores) {
        this.id = id;
        this.text = text;
        this.answerScores = answerScores;
    }

    public String getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public Map<String, Map<String, Integer>> getAnswerScores() {
        return answerScores;
    }
}

