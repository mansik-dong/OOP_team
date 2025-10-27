package hello.egen_teto.domain;

public class Tester {
    private String name;
    private Gender gender;

    public Tester(String name ,Gender gender) {
        this.name = name;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public enum Gender {
        MALE, FEMALE
    }
}
