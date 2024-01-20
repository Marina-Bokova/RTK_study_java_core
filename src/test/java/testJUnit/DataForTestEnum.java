package testJUnit;

import Lesson5.TypeParamEnum;
import lombok.Getter;

@Getter
public enum DataForTestEnum {
    LENGTH("Длина строки", TypeParamEnum.LENGTH, 12, "Неверная длина строки"),
    DIGITS_COUNT("Строка в числом 12", TypeParamEnum.DIGIT, 2, "Неверное количество цифр"),
    LETTERS_COUNT("Стр0ка", TypeParamEnum.LETTER, 5, "Неверное количество букв"),
    SPACES_COUNT("Строка  с пробелами ", TypeParamEnum.SPACE, 4, "Неверное количество пробелов"),
    VOWELS_COUNT("Строка+АаUU", TypeParamEnum.VOWEL, 6, "Неверное количество гласных");

    private final String string;
    private final TypeParamEnum param;
    private final int result;
    private final String message;

    DataForTestEnum(String string, TypeParamEnum param, int result, String message) {
        this.string = string;
        this.param = param;
        this.result = result;
        this.message = message;
    }
}