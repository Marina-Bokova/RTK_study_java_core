package Lesson7.Test_JUnit;

import Lesson5.Task4;
import Lesson5.Task4Result;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class Task4Test {
    @Tag("SMOKE")
    @Test
    void getStringParams() {
        Task4Result result = Task4.getStringParams("1 ab");
        Assertions.assertEquals(result.lettersCount, 2);
        Assertions.assertEquals(result.numbersCount, 1);
        Assertions.assertEquals(result.vowelsCount, 1);
        Assertions.assertEquals(result.spacesCount, 1);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void nullOrEmptyString(String s) {
        Task4Result result = Task4.getStringParams(s);
        Assertions.assertEquals(result.lettersCount, 0);
        Assertions.assertEquals(result.numbersCount, 0);
        Assertions.assertEquals(result.vowelsCount, 0);
        Assertions.assertEquals(result.spacesCount, 0);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "123456789",
            "12 3 4 5 6 7 89",
            "1gfg2fg3fr4g5b67u89",
            "aa12 34567 k89",
            "000000000",
            "0000 00000"
    })
    void testNumbersCount(String s) {
        Task4Result result = Task4.getStringParams(s);
        Assertions.assertEquals(result.numbersCount, 9);
    }
}