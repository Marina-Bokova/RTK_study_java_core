package Lesson5;

public class Task4 extends StringTheme {
    public static void main(String[] args) {
        System.out.println("4. Вывод информации о строке");

        for (String line : ADDITIONAL_STRING) {
            if (line.isEmpty()) {
                System.out.println("\nИсходная строка пустая");
                continue;
            }

            Task4Result result = getStringParams(line);

            System.out.printf("\nИсходная строка: \"%s\"%n", line);
            System.out.println("Длина строки: " + line.length());
            System.out.println("Количество цифр в строке: " + result.numbersCount);
            System.out.println("Количество букв в строке: " + result.lettersCount);
            System.out.println("Количество пробелов в строке: " + result.spacesCount);
            System.out.println("Количество гласных букв в строке: " + result.vowelsCount);
            System.out.println("Строка в верхнем регистре: \"" + line.toUpperCase() + "\"");
            System.out.println("Строка в нижнем регистре: \"" + line.toLowerCase() + "\"");
        }
    }

    public static Task4Result getStringParams(String s) {
        int numbersCount = 0;
        int lettersCount = 0;
        int spacesCount = 0;
        int vowelsCount = 0;

        if (s == null) {
            return new Task4Result(numbersCount, lettersCount, spacesCount, vowelsCount);
        }

        for (int i = 0; i < s.length(); i++) {
            char targetChar = s.charAt(i);
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
        return new Task4Result(numbersCount, lettersCount, spacesCount, vowelsCount);
    }
}