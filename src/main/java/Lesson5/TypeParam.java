package Lesson5;

import lombok.Getter;

@Getter
public enum TypeParam {
    LENGTH("length"),
    DIGIT("digit"),
    LETTER("letter"),
    SPACE("space"),
    VOWEL("lower");

    private final String value;

    TypeParam(String value) {
        this.value = value;
    }
}