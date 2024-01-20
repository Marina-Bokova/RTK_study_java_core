package testJUnit;

import Lesson5.TypeParamEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import static Lesson5.Task4.getStringParams;

class Task4Test {
    // Смоук проверка основного функционала метода: проверка расчета параметра каждого типа
    @Tag("SMOKE")
    @ParameterizedTest
    @EnumSource(DataForTestEnum.class)
    void TestGetStringParams(DataForTestEnum testdata) {
        String s = testdata.getString();
        TypeParamEnum param = testdata.getParam();
        int result = testdata.getResult();
        String message = testdata.getMessage();

        Assertions.assertEquals(getStringParams(s, param), result, message);
    }

    @ParameterizedTest
    @EnumSource(TypeParamEnum.class)
    void EmptyString(TypeParamEnum param) {
        String s = "";

        Assertions.assertEquals(getStringParams(s, param), 0);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "123456789",
            "12 3 4 5 6 7 89",
            "1gfg2fg3fr4g5b67u89",
            "(aa12,34567^ k89)",
            "000000000",
            "(1:11 11,1111)"
    })
    void testDigitsCount(String s) {
        Assertions.assertEquals(getStringParams(s, TypeParamEnum.DIGIT), 9);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "Строка",
            "(String)",
            "tik^Tak",
            "aa12bb34cc"
    })
    void testLettersCount(String s) {
        Assertions.assertEquals(getStringParams(s, TypeParamEnum.LETTER), 6);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "Test String with spaces",
            "   String",
            " tik Tak ",
            "String   "
    })
    void testSpacesCount(String s) {
        Assertions.assertEquals(getStringParams(s, TypeParamEnum.SPACE), 3);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "Аа Ии",
            "Aa Uu",
            "UuИи"
    })
    void testVowelsCount(String s) {
        Assertions.assertEquals(getStringParams(s, TypeParamEnum.VOWEL), 4);
    }

    @Test
    void testLength() {
        String s = "  Проверка определения длины строки  ";
        Assertions.assertEquals(getStringParams(s, TypeParamEnum.LENGTH), 37);
    }
}