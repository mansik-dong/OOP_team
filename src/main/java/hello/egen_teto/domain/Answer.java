package hello.egen_teto.domain;

public enum Answer {
    AGREE("그렇습니다."), NOT_KNOW("모르겠습니다."), DIS_AGREE("아닙니다.");

    private final String description;

    Answer(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}