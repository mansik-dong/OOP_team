package hello.egen_teto.domain;

public enum Category {
    EGEN("에겐력"),
    TETO("테토력");

    private final String description;

    Category(String description) {
        this.description = description;
    }
}
