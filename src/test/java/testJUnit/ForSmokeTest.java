package testJUnit;

import Lesson5.TypeParam;
import lombok.Getter;

@Getter
public enum ForSmokeTest {
    LENGTH("Длина строки", TypeParam.LENGTH, 12, "Неверная длина строки"),
    DIGITS_COUNT("Строка в числом 12", TypeParam.DIGIT, 2, "Неверное количество цифр"),
    LETTERS_COUNT("Стр0ка", TypeParam.LETTER, 5, "Неверное количество букв"),
    SPACES_COUNT("Строка  с пробелмами ", TypeParam.SPACE, 4, "Неверное количество пробелов"),
    VOWELS_COUNT("Строка+АаUU", TypeParam.VOWEL, 6, "Неверное количество гласных");

    private final String string;
    private final TypeParam param;
    private final int result;
    private final String message;

    ForSmokeTest(String string, TypeParam param, int result, String message) {
        this.string = string;
        this.param = param;
        this.result = result;
        this.message = message;
    }
}