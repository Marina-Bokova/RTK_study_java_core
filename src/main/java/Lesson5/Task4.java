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
            System.out.println("Длина строки: " + getStringParams(line, TypeParam.LENGTH));
            System.out.println("Количество цифр в строке: " + getStringParams(line, TypeParam.DIGIT));
            System.out.println("Количество букв в строке: " + getStringParams(line, TypeParam.LETTER));
            System.out.println("Количество пробелов в строке: " + getStringParams(line, TypeParam.SPACE));
            System.out.println("Количество гласных букв в строке: " + getStringParams(line, TypeParam.VOWEL));
            System.out.println("Строка в верхнем регистре: \"" + line.toUpperCase() + "\"");
            System.out.println("Строка в нижнем регистре: \"" + line.toLowerCase() + "\"");
        }
    }

    public static int getStringParams(String s, TypeParam param) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        if (param.equals(TypeParam.LENGTH)) {
            return s.length();
        }

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char targetChar = s.charAt(i);
            if (param.equals(TypeParam.DIGIT) && Character.isDigit(targetChar)) {
                count++;
            } else if (param.equals(TypeParam.LETTER) && Character.isAlphabetic(targetChar)) {
                count++;
            } else if (param.equals(TypeParam.SPACE) && targetChar == ' ') {
                count++;
            } else if (param.equals(TypeParam.VOWEL) && VOWELS.contains(String.valueOf(targetChar))) {
                count++;
            }
        }
        return count;
    }
}