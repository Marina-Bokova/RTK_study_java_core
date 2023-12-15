package Lesson5;

public class Task1 extends StringTheme {
    public static void main(String[] args) {
        System.out.println("1. Нахождение самой длинной и самой короткой строки");

        String longestString = findLongestString(GIVEN_STRINGS);
        String shortestString = findShortestString(GIVEN_STRINGS);

        // Результат оформим в виде таблицы
        // Определим название столбцов и формат вывода строк
        String firstColName = "Строка";
        String secondColName = "Длина";
        int maxLength = longestString.length();

        String template = "%-" + (maxLength) + "s %" + (secondColName.length()) + "s%n";
        System.out.printf(template, firstColName, secondColName);

        //Заполним таблицу значениями
        for (String line : GIVEN_STRINGS) {
            System.out.printf(template, line, line.length());
        }
        System.out.printf("%nСамая длинная строка: \"%s\"%n", longestString);
        System.out.printf("Самая короткая строка: \"%s\"%n", shortestString);
    }
}