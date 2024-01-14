package testJUnit;

import Lesson5.TypeParam;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import static Lesson5.Task4.getStringParams;

class Task4Test {
    @Tag("SMOKE")
    @ParameterizedTest
    @EnumSource(ForSmokeTest.class)
    void TestGetStringParams(ForSmokeTest testdata) {
        String s = testdata.getString();
        TypeParam param = testdata.getParam();
        int result = testdata.getResult();
        String message = testdata.getMessage();

        Assertions.assertEquals(getStringParams(s, param), result, message);
    }

    @ParameterizedTest
    @EnumSource(TypeParam.class)
    void EmptyString(TypeParam param) {
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
        Assertions.assertEquals(getStringParams(s, TypeParam.DIGIT), 9);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "Строка",
            "(String)",
            "tik^Tak",
            "aa12bb34cc"
    })
    void testLettersCount(String s) {
        Assertions.assertEquals(getStringParams(s, TypeParam.LETTER), 6);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "Test String with spaces",
            "   String",
            " tik Tak ",
            "String   "
    })
    void testSpacesCount(String s) {
        Assertions.assertEquals(getStringParams(s, TypeParam.SPACE), 3);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "Аа Ии",
            "Aa Uu",
            "UuИи"
    })
    void testVowelsCount(String s) {
        Assertions.assertEquals(getStringParams(s, TypeParam.VOWEL), 4);
    }

    @Test
    void testLength() {
        String s = "  Проверка определения длины строки  ";
        Assertions.assertEquals(getStringParams(s, TypeParam.LENGTH), 37);
    }
}