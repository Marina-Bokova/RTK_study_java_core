package Lesson3;

public class CyclesTheme {
    public static void main(String[] args) {
        System.out.println("1. Подсчет суммы четных и нечетных чисел");
        int firstNumber = -10;
        int lastNumber = 21;
        int sumEvenNumbers = 0;
        int sumOddNumbers = 0;
        int targetNumber = firstNumber;

        do {
            if (targetNumber % 2 == 0) {
                sumEvenNumbers += targetNumber;
            } else {
                sumOddNumbers += targetNumber;
            }
        } while (++targetNumber <= lastNumber);

        System.out.printf("В отрезке [%d, %d] сумма четных чисел = %d, а нечетных = %d\n",
                firstNumber, lastNumber, sumEvenNumbers, sumOddNumbers);


        System.out.println("\n2. Вывод чисел в порядке убывания");
        int number1 = 10;
        int number2 = 5;
        int number3 = -1;

        // Определяем наименьшее и наибольшее число
        int minNumber, maxNumber;
        if (number1 >= number2) {
            minNumber = number2;
            maxNumber = number1;
        } else {
            minNumber = number1;
            maxNumber = number2;
        }
        minNumber = (minNumber > number3) ? number3 : minNumber;
        maxNumber = (maxNumber < number3) ? number3 : maxNumber;

        for (int i = --maxNumber; i > minNumber; i--) {
            System.out.print(i + " ");
        }
        System.out.print('\n');


        System.out.println("\n3. Вывод реверсивного числа и суммы его цифр");
        int inputNumber = 1234;
        int sumDigits = 0;

        System.out.print("Исходное число в обратном порядке: ");
        while (inputNumber > 0) {
            System.out.print(inputNumber % 10);
            sumDigits += inputNumber % 10;
            inputNumber /= 10;
        }
        System.out.println("\nСумму цифр: " + sumDigits);


        System.out.println("\n4. Вывод чисел в несколько строк");
        int startNum = 1;
        int finishNum = 24;
        int scale = 5;

        // Проверяем, что начальное значение нечетное. Если нет, то увеличиваем его на 1
        startNum = (startNum % 2 == 1) ? startNum : startNum + 1;

        while (startNum < finishNum) {
            for (int i = 0; i < scale; i++) {
                int printNum = (startNum < finishNum) ? startNum : 0;
                System.out.printf("%4d", printNum);
                startNum += 2;
            }
            System.out.print("\n");
        }


        System.out.println("\n5. Проверка количества двоек числа на четность/нечетность");
        int testNumber = 3242592;
        int changeNumber = testNumber;
        int countDigit = 0;

        while (changeNumber > 0) {
            countDigit += (changeNumber % 10 == 2) ? 1 : 0;
            changeNumber /= 10;
        }
        if (countDigit % 2 == 0) {
            System.out.printf("В %d четное количество двоек — %d\n", testNumber, countDigit);
        } else {
            System.out.printf("В %d нечетное количество двоек — %d\n", testNumber, countDigit);
        }


        System.out.println("\n6. Отображение геометрических фигур");
        // Прямоугольник из *
        char rectangleChar = '*';
        int sizeRectangle = 5;
        for (int i = 0; i < sizeRectangle; i++) {
            for (int j = 0; j < sizeRectangle * 2; j++) {
                System.out.print(rectangleChar);
            }
            System.out.print("\n");
        }
        System.out.print("\n");

        // Прямоугольный треугольник из #
        char triangleChar1 = '#';
        int triangleLines = 5;
        while (triangleLines > 0) {
            int count = 0;
            while (count++ < triangleLines) {
                System.out.print(triangleChar1);
            }
            System.out.print("\n");
            triangleLines--;
        }
        System.out.print("\n");

        // Равнобедренный треугольник из &
        char triangleChar2 = '&';
        int heightTriangle = 3;
        String triangle = "";
        do {
            int length = 0;
            String line = "";
            do {
                line += triangleChar2;
            } while (++length < heightTriangle);
            line += "\n";
            if (triangle.isEmpty()) {
                triangle = line;
            } else {
                triangle = line + triangle + line;
            }
        } while (--heightTriangle > 0);
        System.out.print(triangle);


        System.out.println("\n7. Отображение ASCII-символов");
        //Создание строки заголовка
        System.out.println("DECIMAL   CHARACTER   DESCRIPTION");

        // Определяем диапазон символов согласно ТЗ: от 15 до цифр
        int symbolCode = 15;
        int numberCode = '0';

        // Выводить будем только символы, имеющие нечетный код в таблице ASCII
        // Определяем первое нечетное значение в заданном диапазоне
        symbolCode = (symbolCode % 2 == 1) ? symbolCode : symbolCode + 1;

        for (int i = symbolCode; i < numberCode; i = i + 2) {
            System.out.printf("  %-12d%-12c%s%n", i, i, Character.getName(i));
        }

        // Определяем диапазон чисел для вывода маленьких английских букв
        int firstLetter = 'a';
        int lastLetter = 'z';

        // Выводить будем только буквы, имеющие четный код в таблице ASCII
        // Определяем первое четное значение в заданном диапазоне
        firstLetter = (firstLetter % 2 == 0) ? firstLetter : firstLetter + 1;

        for (int i = firstLetter; i <= lastLetter; i = i + 2) {
            System.out.printf("  %-12d%-12c%s%n", i, i, Character.getName(i));
        }


        System.out.println("\n8. Проверка, является ли число палиндромом");
        int targetNum = 1234321;
        int invertedNum = 0;
        int rate = 1;
        while (targetNum > rate) {
            int digit = targetNum / rate % 10;
            invertedNum = 10 * invertedNum + digit;
            rate *= 10;
        }
        if (targetNum == invertedNum) {
            System.out.println("Число " + targetNum + " является палиндромом");
        } else {
            System.out.println("Число " + targetNum + " не является палиндромом");
        }


        System.out.println("\n9. Проверка, является ли число счастливым");
        // Создаем случайное число в диапазоне [100000; 999999]
        int sixDigitNumber = (int) (Math.random() * 900000) + 100000;

        int leftPart = sixDigitNumber / 1000;
        int rightPart = sixDigitNumber % 1000;
        int sumInLeftPart = CalculateSumDigits(leftPart);
        int sumInRightPart = CalculateSumDigits(rightPart);

        if (sumInLeftPart == sumInRightPart) {
            System.out.println("Число " + sixDigitNumber + " является счастливым");
        } else {
            System.out.println("Число " + sixDigitNumber + " не является счастливым");
        }
        System.out.printf("Сумма цифр %d = %d, а сумма %d = %d%n",
                leftPart, sumInLeftPart, rightPart, sumInRightPart);


        System.out.println("\n10. Отображение таблицы умножения Пифагора");
        System.out.printf("%23s%n", "ТАБЛИЦА   ПИФАГОРА");
        for (int i = 1; i < 10; i++) {
            if (i == 1) {
                System.out.printf("%3c", '|');
            } else {
                System.out.printf("%n%d |", i);
            }
            for (int j = 2; j < 10; j++) {
                System.out.printf("%3d", i * j);
            }
            if (i == 1) {
                System.out.print("\n");
                // Рисуем горизонтальную линию
                for (int j = 1; j < 10; j++) {
                    System.out.print("---");
                }
            }
        }
    }

    // Метод для расчета суммы цифр положительного числа
    static private int CalculateSumDigits(int number) {
        int sumDigits = 0;
        while (number > 0) {
            sumDigits += number % 10;
            number /= 10;
        }
        return sumDigits;
    }
}
