package hello.egen_teto.domain;

import jakarta.persistence.*;
import java.util.Map;

@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    @ElementCollection
    @CollectionTable(name = "answer_score" , joinColumns = @JoinColumn(name = "answer_id"))
    @MapKeyEnumerated(EnumType.STRING)
    @MapKeyColumn(name = "category")
    @Column(name = "score")
    private Map<Category, Integer> score;

    private String answerText;

    public Long getId() {
        return id;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Map<Category, Integer> getScore() {
        return score;
    }

    public void setScores(Map<Category, Integer> score) {
        this.score = score;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    Answer() {}

}
