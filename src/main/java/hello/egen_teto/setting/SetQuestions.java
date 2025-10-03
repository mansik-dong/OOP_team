package hello.egen_teto.setting;

import hello.egen_teto.domain.Answer;
import hello.egen_teto.domain.Question;
import hello.egen_teto.domain.Tester;

import java.util.List;
import java.util.Map;

public class SetQuestions {
    private List<Question> questionList;

    Tester tester;

    //public void setFemaleQuestion() {
    //    questionList = List.of(new Question("q1", "질문 1", Map.of(Answer.AGREE ,1, Answer.NOT_KNOW, 0, Answer.DIS_AGREE, 3)),
    //            new Question("q2" , "질문 2" , Map.of(Answer.AGREE ,3, Answer.NOT_KNOW, 0, Answer.DIS_AGREE, -2)),
    //            new Question("q3", "질문3", Map.of(Answer.AGREE ,-2, Answer.NOT_KNOW, 0, Answer.DIS_AGREE, 3)));
    //}

    public void createQuestion() {
        questionList = List.of(new Question("q1", "egen", "질문 1", Map.of(Answer.AGREE ,1, Answer.NOT_KNOW, 2, Answer.DIS_AGREE, 3)),
                new Question("q2" , "teto", "질문 2" , Map.of(Answer.AGREE ,1, Answer.NOT_KNOW, 2, Answer.DIS_AGREE, 3)),
                new Question("q3", "egen", "질문3", Map.of(Answer.AGREE ,1, Answer.NOT_KNOW, 2, Answer.DIS_AGREE, 3)));
    }

    public void setTester(Tester tester) {
        this.tester = tester;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

}
