package Lesson5;

public class Task4 extends StringTheme {
    public static void main(String[] args) {
        System.out.println("4. Вывод информации о строке");

        for (String line : ADDITIONAL_STRING) {
            if (line.isEmpty()) {
                System.out.println("\nИсходная строка пустая");
                continue;
            }
            System.out.printf("\nИсходная строка: \"%s\"%n", line);
            int numbersCount = 0;
            int lettersCount = 0;
            int spacesCount = 0;
            int vowelsCount = 0;

            for (int i = 0; i < line.length(); i++) {
                char targetChar = line.charAt(i);
                if (Character.isDigit(targetChar)) {
                    numbersCount++;
                } else if (Character.isAlphabetic(targetChar)) {
                    lettersCount++;
                } else if (targetChar == ' ') {
                    spacesCount++;
                }
                if (VOWELS.contains(String.valueOf(targetChar))) {
                    vowelsCount++;
                }
            }

            System.out.println("Количество цифр в строке: " + numbersCount);
            System.out.println("Количество букв в строке: " + lettersCount);
            System.out.println("Количество пробелов в строке: " + spacesCount);
            System.out.println("Количество гласных букв в строке: " + vowelsCount);
            System.out.println("Строка в верхнем регистре: \"" + line.toUpperCase() + "\"");
            System.out.println("Строка в нижнем регистре: \"" + line.toLowerCase() + "\"");
        }
    }
}