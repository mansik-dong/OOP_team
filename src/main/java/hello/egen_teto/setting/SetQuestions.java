package hello.egen_teto.setting;

import hello.egen_teto.domain.Question;
import hello.egen_teto.domain.Tester;

import java.util.List;
import java.util.Map;

public class SetQuestions {
    private List<Question> questionList;

    Tester tester;
// 해야되는거 : calculate null 처리, ENUM으로 리팩토링(타입 안전성), 결과에서 ~~님은 테토에겐 남 or 녀 이시네요! 나오게
    //public void setFemaleQuestion() {
    //    questionList = List.of(new Question("q1", "질문 1", Map.of(Answer.AGREE ,1, Answer.NOT_KNOW, 0, Answer.DIS_AGREE, 3)),
    //            new Question("q2" , "질문 2" , Map.of(Answer.AGREE ,3, Answer.NOT_KNOW, 0, Answer.DIS_AGREE, -2)),
    //            new Question("q3", "질문3", Map.of(Answer.AGREE ,-2, Answer.NOT_KNOW, 0, Answer.DIS_AGREE, 3)));
    //}

    public void createQuestion() {
        questionList = List.of(
                new Question("q1",  "게임에서 졌을 때", Map.of("재밌었으니 됐다", Map.of("egen", 15), "이길 때까지 한다", Map.of("teto", 15))),
                new Question("q2", "평소 대화할 때", Map.of("분위기 맞추며 리액션하는 편", Map.of("egen", 5), "분위기를 이끌어내며 말하는 편", Map.of("teto", 5))),
                new Question("q3",  "소개팅 할 때", Map.of("리드 당하는 걸 좋아함", Map.of("egen", 10), "리드 하는 걸 좋아함", Map.of("teto", 10))),
                new Question("q4", "쉬는 날", Map.of("실내 위주(집, 카페 등)", Map.of("egen", 5), "실외 위주(술자리, 운동 등)", Map.of("teto", 5))),
                new Question("q5",  "혼자 집에서 밥먹을 때", Map.of(" 10번 중 4번 이상 요리해서 먹음", Map.of("egen", 7), "웬만하면 배달시킴", Map.of("teto", 7))),
                new Question("q6", "친구 만날 때", Map.of("눈썹, 립밤은 필수", Map.of("egen", 13), "상관 없음", Map.of("teto", 13))),
                new Question("q7",  "데이트 할 때", Map.of("맛집 검색해서 가보고 맛있으면 저장", Map.of("egen", 15), "가자는 곳 감", Map.of("teto", 15))),
                new Question("q8",  "가려던 맛집 웨이팅 있을 때(30분 이상) ", Map.of("10번 중 6번은 기다린 적 있음", Map.of("egen", 15), "10번 중 1~2번 기다릴까 말까임", Map.of("teto", 15))),
                new Question("q9",  "싸움 났을 때", Map.of("웬만하면 화해 시도함", Map.of("egen", 10), "내 잘못 아니면 절대 안 물러남", Map.of("teto", 10))),
                new Question("q10", "연락 빈도", Map.of("연락 자주 하고 소통 유지형", Map.of("egen", 5), "필요할 때만 연락형", Map.of("teto", 5)))
        );
    }

    public void setTester(Tester tester) {
        this.tester = tester;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

}
