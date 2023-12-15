package Lesson5;

import java.util.Arrays;

public class Task5 extends StringTheme {
    public static void main(String[] args) {
        System.out.println("5. Список сотрудников");

        String[] coworkersArray = {"Приданников Николай Михайлович",
                "Шканова Алина Александровна",
                "Яковлева Светлана Юрьевна ",
                "Елисеев Антон Олегович",
                "Бычков Алексей Александрович",
                "Масанов Александр Николаевич",
                "Золотарёва Диана Евгеньевна",
                "Жулин Роман Геннадьевич",
                "Шевченко Евгения Николаевна",
                "Боровских Антон Евгеньевич",
                "Юсупова Светлана Эмильевна",
                "Бокова Марина Викторовна"};
        Arrays.sort(coworkersArray);

        // Создадим массив с массивов с именами коллег
        String[][] myCoworkers = new String[coworkersArray.length][];
        for (int i = 0; i < coworkersArray.length; i++) {
            String[] coworker = coworkersArray[i].split(" ");
            myCoworkers[i] = coworker;
        }

        System.out.println("\nФамилии и инициалы моих коллег:");
        int number = 1;
        for (String[] coworker : myCoworkers) {
            String surname = coworker[0];
            String name = coworker[1];
            String patronymic = coworker[2];

            System.out.printf("%2d. %s %c.%c.%n", number++,
                    surname, name.charAt(0), patronymic.charAt(0));
        }

        System.out.println("\nСписок сотрудников, чьи фамилии начинаются с гласной:");
        number = 1;
        for (String coworker : coworkersArray) {
            if (VOWELS.contains(String.valueOf(coworker.charAt(0)))) {
                System.out.printf("%2d. %s%n", number++, coworker);
            }
        }

        System.out.println("\nСписок сотрудников, чьи имена заканчиваются на согласные:");
        number = 1;
        for (String[] coworker : myCoworkers) {
            if (CONSONANTS.contains(String.valueOf(coworker[1].charAt(coworker[1].length() - 1)))) {
                System.out.printf("%2d. %s %s %s%n", number++, coworker[0], coworker[1], coworker[2]);
            }
        }

        System.out.println("\nФИО сотрудников без повторяющихся символов:");
        number = 1;
        for (String coworker : coworkersArray) {
            StringBuilder uniqueLettersName = new StringBuilder();
            for (int i = 0; i < coworker.length(); i++) {
                String letter = String.valueOf(coworker.charAt(i));
                if (letter.equals(" ") || !uniqueLettersName.toString().contains(letter)) {
                    uniqueLettersName.append(letter);
                }
            }
            System.out.printf("%2d. %s%n", number++, uniqueLettersName);
        }
    }
}