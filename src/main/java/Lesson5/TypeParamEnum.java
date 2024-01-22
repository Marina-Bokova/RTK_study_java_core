package Lesson5;

import lombok.Getter;

@Getter
public enum TypeParamEnum {
    LENGTH("length"),
    DIGIT("digit"),
    LETTER("letter"),
    SPACE("space"),
    VOWEL("lower");

    private final String value;

    TypeParamEnum(String value) {
        this.value = value;
    }
}