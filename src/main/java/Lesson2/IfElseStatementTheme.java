package Lesson2;

public class IfElseStatementTheme {
    public static void main(String[] args) {
        System.out.println("1. Перевод псевдокода на язык Java");
        // Входная информация
        String name = "Liam";
        int age = 25;
        boolean male = true;
        double height = 2.2;

        final int AGE_LIMIT = 20;
        final double HEIGHT_LIMIT = 1.8;

        if (age > AGE_LIMIT) {
            System.out.println("Добро пожаловать в нашу спортивную школу для взрослых");
        } else {
            System.out.println("Добро пожаловать в нашу детскую спортивную школу");
        }
        if (!male) {
            System.out.println("Женская раздевалка расположена слева");
        } else {
            System.out.println("Мужская раздевалка расположена справа");
        }
        if (height < HEIGHT_LIMIT) {
            System.out.println("Выбирайте любую понравившуюся вам секцию");
        } else {
            System.out.println("Рекомендуем вам заняться баскетболом");
        }
        char firstCharBrand = name.charAt(0);
        if (firstCharBrand == 'M') {
            System.out.println("В марте вам предоставляется персональная скидка 10%");
        } else if (firstCharBrand == 'I') {
            System.out.println("В апреле вам предоставляется персональная скидка 10%");
        } else {
            System.out.println("В мае вам предоставляется персональная скидка 5%");
        }


        System.out.println("\n2. Поиск max и min числа");
        // Генерирует рандомное целое число в диапазоне [-50; 50)
        int number1 = (int) (Math.random() * 100 - 50);
        int number2 = (int) (Math.random() * 100 - 50);

        if (number1 < number2) {
            System.out.println("min = " + number1 + "\nmax = " + number2);
        } else if (number1 > number2) {
            System.out.println("min = " + number2 + "\nmax = " + number1);
        } else {
            System.out.println("Значения равны");
        }


        System.out.println("\n3. Проверка числа");
        // Генерирует рандомное целое число в диапазоне [-50; 50)
        int randomNumber = (int) (Math.random() * 100 - 50);

        System.out.println("Выбранное число равно " + randomNumber);
        if (randomNumber != 0) {
            String property1 = (randomNumber % 2 == 0) ? "четным" : "нечетным";
            String property2 = (randomNumber > 0) ? "положительным" : "отрицательным";
            System.out.println("Оно является " + property1 + " и " + property2);
        }


        System.out.println("\n4. Поиск одинаковых цифр в числах");
        // Генерирует рандомное целое число в диапазоне [100; 999]
        int targetNumber1 = (int) (Math.random() * 900 + 100);
        int targetNumber2 = (int) (Math.random() * 900 + 100);
        System.out.printf("Исходные числа: %d и %d\n", number1, number2);

        int numberHundreds1 = targetNumber1 / 100;
        int numberHundreds2 = targetNumber2 / 100;
        int numberTens1 = (targetNumber1 / 10) % 10;
        int numberTens2 = (targetNumber2 / 10) % 10;
        int numberUnits1 = targetNumber1 % 10;
        int numberUnits2 = targetNumber2 % 10;

        // Создадим маркер, которые будет указывать на наличие одинаковых цифр в числах
        boolean haveSameDigits = false;

        if (numberHundreds1 == numberHundreds2) {
            System.out.println("Числа содержат одинаковое количество сотен: " + numberHundreds1);
            haveSameDigits = true;
        }
        if (numberTens1 == numberTens2) {
            System.out.println("Числа содержат одинаковое количество десятков: " + numberTens1);
            haveSameDigits = true;
        }
        if (numberUnits1 == numberUnits2) {
            System.out.println("Числа содержат одинаковое количество единиц: " + numberUnits1);
            haveSameDigits = true;
        }
        if (!haveSameDigits) {
            System.out.println("Числа не содержат одинаковых цифр, стоящих в одном и том же разряде");
        }


        System.out.println("\n5. Определение символа по его коду");
        char symbol = '\u0057';
        String characteristic;

        if ('a' <= symbol && symbol <= 'z') {
            characteristic = "маленькая буква";
        } else if ('A' <= symbol && symbol <= 'Z') {
            characteristic = "большая буква";
        } else if ('0' <= symbol && symbol <= '9') {
            characteristic = "число";
        } else {
            characteristic = "не буква и не число";
        }
        System.out.printf("Загаданный символ - это %s, он равен %c\n", characteristic, symbol);


        System.out.println("\n6. Подсчет суммы вклада и начисленных банком процентов");
        int deposit = 300_000;
        final double RATE_LOW = 0.05;
        final double RATE_MIDDLE = 0.07;
        final double RATE_HIGH = 0.1;

        int interest;
        if (deposit > 300_000) {
            interest = (int) (deposit * RATE_HIGH);
        } else if (deposit > 100_000) {
            interest = (int) (deposit * RATE_MIDDLE);
        } else {
            interest = (int) (deposit * RATE_LOW);
        }
        System.out.println("Сумму вклада: " + deposit);
        System.out.println("Начисленный процент: " + interest);
        System.out.println("Итоговую сумму с процентами: " + (deposit + interest));


        System.out.println("\n7. Определение оценки по предметам");
        int historyPercent = 59;
        int programmingPercent = 91;

        int historyGrade = FromPercentToGrade(historyPercent);
        int programmingGrade = FromPercentToGrade(programmingPercent);
        double averageGrades = (double) (historyGrade + programmingGrade) / 2;
        int averagePercents = (historyPercent + programmingPercent) / 2;

        System.out.printf("Оценки по предметам:\n%d - история\n%d - программирование\n",
                historyGrade, programmingGrade);
        System.out.printf("%.2f - средний балл\n", averageGrades);
        System.out.printf("%d - средний процент\n", averagePercents);


        System.out.println("\n8. Расчет прибыли за год");
        int monthlyRent = 5_000;
        int monthlyIncome = 13_000;
        int monthlyExpenses = 9_000;

        int annualProfit = (monthlyIncome - monthlyExpenses - monthlyRent) * 12;
        if (annualProfit > 0) {
            System.out.println("Прибыль за год: +" + annualProfit + " руб.");
        } else {
            System.out.println("Прибыль за год: " + annualProfit + " руб.");
        }


        System.out.println("\n9. Подсчет количества банкнот");
        int billsOf100 = 10;
        int billsOf10 = 5;
        int billsOf1 = 50;
        int cashAtAtm = 100 * billsOf100 + 10 * billsOf10 + billsOf1;

        int requiredAmount = 567;

        if (requiredAmount > cashAtAtm) {
            System.out.println("В банкомате недостаточно средств");
        } else {
            int targetBillsOf100 = 0;
            int targetBillsOf10 = 0;
            int targetBillsOf1 = 0;

            // Определяем необходимое количество банкнот по 100
            while (requiredAmount >= 100 && targetBillsOf100 <= billsOf100) {
                requiredAmount -= 100;
                targetBillsOf100 += 1;
            }

            // Определяем необходимое количество банкнот по 10
            while (requiredAmount >= 10 && targetBillsOf10 < billsOf10) {
                requiredAmount -= 10;
                targetBillsOf10 += 1;
            }

            // Определяем необходимое количество банкнот по 1
            while (requiredAmount >= 1 && targetBillsOf1 < billsOf1) {
                requiredAmount -= 1;
                targetBillsOf1 += 1;
            }

            // Определяем, собрана ли нужная сумма и выводим результат
            int total = 100 * targetBillsOf100 + 10 * targetBillsOf10 + targetBillsOf1;
            if (requiredAmount == 0) {
                System.out.printf("Банкомат выдаст:\nбанкнот по 100 USD - %d\n" +
                                "банкнот по 10 USD - %d\nбанкнот по 1 USD - %d\n",
                        targetBillsOf100, targetBillsOf10, targetBillsOf1);
                System.out.println("Итого в выдаче: " + total + " USD");
            } else {
                System.out.printf("Имеющимися в банкомате купюрами нельзя получить " +
                        (total + requiredAmount) + " USD");
            }
        }
    }

    // Метод преобразует процент в оценку по пятибальной шкале
    private static int FromPercentToGrade(int percent) {
        int grade;
        if (percent > 91) {
            grade = 5;
        } else if (percent > 73) {
            grade = 4;
        } else if (percent > 60) {
            grade = 3;
        } else {
            grade = 2;
        }
        return grade;
    }
}
