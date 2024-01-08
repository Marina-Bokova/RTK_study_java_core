package Lesson7.Cucumber;

import Lesson5.Task4;
import Lesson5.Task4Result;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Тогда;
import org.junit.jupiter.api.Assertions;

public class StepDefinitions {
    public String string;
    @Дано("пустая строка")
    public void пустаяСтрока() {
        this.string = "";
    }

    @Дано("строка {string}")
    public void строка(String s) {
        this.string = s;
    }

    @Тогда("строка содержит {int} букв, {int} цифр, {int} пробелов, {int} гласных")
    public void строкаСодержитБуквЦифрПробеловГласных(int letters, int numbers, int spaces, int vowels) {
        Task4Result result = Task4.getStringParams(string);
        Assertions.assertEquals(result.lettersCount, letters);
        Assertions.assertEquals(result.numbersCount, numbers);
        Assertions.assertEquals(result.vowelsCount, spaces);
        Assertions.assertEquals(result.spacesCount, vowels);
    }
}