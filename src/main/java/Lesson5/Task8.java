package Lesson5;

public class Task8 extends StringTheme {
    public static void main(String[] args) {
        System.out.println("8. Замена подстроки");

        // Вывод исходного списка строк
        System.out.println("\nСписок заданных строк:");
        for (String line : GIVEN_STRINGS) {
            System.out.println("\"" + line + "\"");
        }

        // Вывод списка строк с заменой пробела на "**"
        String replacement = "**";
        System.out.println("\nСписок строк после замены пробела на \"**\":");
        for (String line : GIVEN_STRINGS) {
            System.out.println("\"" + customReplace(line, ' ', replacement) + "\"");
        }

        // Вывод списка строк c заменой подстроки "пр" на "ПППррр"
        String substring = "пр";
        String newSubstring = "ПППррр";
        System.out.println("\nСписок строк после замены \"пр\" на \"ПППррр\":");
        for (String line : GIVEN_STRINGS) {
            System.out.println("\"" + customReplace(line, substring, newSubstring) + "\"");
        }
    }
}