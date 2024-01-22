package cucumber;

import Lesson5.Task4;
import Lesson5.TypeParamEnum;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Если;
import io.cucumber.java.ru.То;
import lombok.Getter;
import org.junit.jupiter.api.Assertions;

@Getter
public class StringSteps {
    private String string;
    private TypeParamEnum param;
    private int actualResult;
    private int expectedResult;

    @Дано("{string} с известным количеством проверяемых символов")
    public void stringWithKnownNumberCharacters(String s) {
        this.string = s;
    }

    @Дано("пустая строка")
    public void emptyString() {
        this.string = "";
    }


    @Если("вызвать функцию анализа строки для подсчета {string}")
    // Если будет указан неверный параметр, то тест выбросит исключение
    public void callStringAnalysisFunction(String value) {
        switch (value) {
            case "всех символов":
                param = TypeParamEnum.LENGTH;
                break;
            case "цифр":
                param = TypeParamEnum.DIGIT;
                break;
            case "букв":
                param = TypeParamEnum.LETTER;
                break;
            case "пробелов":
                param = TypeParamEnum.SPACE;
                break;
            case "гласных":
                param = TypeParamEnum.VOWEL;
                break;
            default:
                throw new IllegalArgumentException("Некорректное значение параметра");
        }
        actualResult = Task4.getStringParams(string, param);
    }

    @Если("вызвать функцию анализа строки для определения длины строки")
    public void callStringAnalysisFunctionToDetermineStringLength() {
        actualResult = Task4.getStringParams(string, TypeParamEnum.LENGTH);
    }


    @То("в результате функция должна вернуть {int}")
    public void FunctionMustReturn(int expectedResult) {
        this.expectedResult = expectedResult;
        Assertions.assertEquals(actualResult, expectedResult);
    }
}