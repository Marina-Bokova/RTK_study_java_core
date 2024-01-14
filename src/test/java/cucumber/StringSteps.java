package cucumber;

import Lesson5.Task4;
import Lesson5.TypeParam;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Если;
import io.cucumber.java.ru.То;
import org.junit.jupiter.api.Assertions;

public class StringSteps {
    public String string;
    public TypeParam param;
    public int actualResult;
    public int expectedResult;

    @Дано("{string} с известным количеством проверяемых символов")
    public void строкаСИзвестнымКоличествомПроверяемыхСимволов(String s) {
        this.string = s;
    }

    @Дано("пустая строка")
    public void пустаяСтрока() {
        this.string = "";
    }


    @Если("вызвать функцию анализа строки для подсчета {string}")
    public void вызватьФункциюАнализаСтроки(String value) {
        switch (value) {
            case "всех символов":
                param = TypeParam.LENGTH;
                break;
            case "цифр":
                param = TypeParam.DIGIT;
                break;
            case "букв":
                param = TypeParam.LETTER;
                break;
            case "пробелов":
                param = TypeParam.SPACE;
                break;
            case "гласных":
                param = TypeParam.VOWEL;
                break;
            default:
                throw new IllegalArgumentException("Некорректное значение параметра");
        }
        actualResult = Task4.getStringParams(string, param);
    }

    @Если("вызвать функцию анализа строки для определения длины строки")
    public void вызватьФункциюАнализаСтрокиДляОпределенияДлиныСтроки() {
        actualResult = Task4.getStringParams(string, TypeParam.LENGTH);
    }


    @То("в результате функция должна вернуть {int}")
    public void вРезультатеФункцияДолжнаВернуть(int expectedResult) {
        this.expectedResult = expectedResult;
        Assertions.assertEquals(actualResult, expectedResult);
    }
}