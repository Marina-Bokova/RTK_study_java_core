package Lesson5;

public class Task7 extends StringTheme {
    public static void main(String[] args) {
        System.out.println("7. Поиск пустых строк");

        // Вывод исходного списка строк
        System.out.println("\nСписок заданных строк:");
        for (String line : ADDITIONAL_STRING) {
            System.out.println("\"" + line + "\"");
        }

        // Вывод индексов пустых строк
        System.out.print("\nИндексы пустых строк:");
        for (int i = 0; i < ADDITIONAL_STRING.length; i++) {
            if (ADDITIONAL_STRING[i].isEmpty()) {
                System.out.print(" " + i);
            }
        }
        System.out.println();
    }
}