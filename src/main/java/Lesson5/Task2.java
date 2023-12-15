package Lesson5;

public class Task2 extends StringTheme {
    public static void main(String[] args) {
        System.out.println("2. Вывод инвертированной строки");

        int leftColumnWidth = 8;
        int rightColumnWidth = findLongestString(GIVEN_STRINGS).length();
        String tableTemplate = "%-" + leftColumnWidth + "s%s%n";

        for (String line : GIVEN_STRINGS) {
            for (int i = 0; i < (leftColumnWidth + rightColumnWidth); i++) {
                System.out.print('-');
            }
            System.out.println();
            StringBuilder reverseLine = new StringBuilder(line).reverse();
            System.out.printf(tableTemplate, "Было:", line);
            System.out.printf(tableTemplate, "Стало:", reverseLine);
        }
    }
}