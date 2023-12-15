package Lesson5;

import java.util.Arrays;

public class Task6 extends StringTheme {
    public static void main(String[] args) {
        System.out.println("6. Разделение строки на массив слов");

        for (String line : GIVEN_STRINGS) {
            System.out.printf("%nИсходная строка: %s%n", line);
            String[] wordsArray = line.split(" ");
            System.out.printf("Массив слов: %s%n", Arrays.toString(wordsArray));
            System.out.printf("Количество слов: %d%n", wordsArray.length);
        }
    }
}