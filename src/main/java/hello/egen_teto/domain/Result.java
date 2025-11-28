package hello.egen_teto.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String testerName;
    @Enumerated(EnumType.STRING)
    private Tester.Gender testerGender;
    private int egen;
    private int teto;
    private LocalDateTime time;

    public Result(String testerName, Tester.Gender testerGender, int egen, int teto, LocalDateTime time) {
        this.testerName = testerName;
        this.testerGender = testerGender;
        this.egen = egen;
        this.teto = teto;
        this.time = time;
    }

    public Long getId() {
        return id;
    }

    public String getTesterName() {
        return testerName;
    }

    public Tester.Gender getTesterGender() {
        return testerGender;
    }

    public int getEgen() {
        return egen;
    }

    public int getTeto() {
        return teto;
    }

    public LocalDateTime getTime() {
        return time;
    }
}
