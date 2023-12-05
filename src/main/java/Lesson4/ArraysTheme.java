package Lesson4;

import java.util.Random;
import java.util.Arrays;

public class ArraysTheme {
    public static void main(String[] args) {
        // Задача №1
        System.out.println("1. Создайте массив целых чисел и найдите его сумму");
        final int LENGTH = 5;
        int[] randomIntArray = buildRandomIntArray(LENGTH);

        int sumNumbers = sumArrayElements(randomIntArray);
        System.out.println("Сумма элементов массива равна " + sumNumbers);


        // Задача №2
        System.out.println("\n2. Создайте массив строк и выведите на экран все строки, " +
                "у которых длина больше 5 символов");
        final int WORDS_COUNT = 7;
        final int MIN_LENGTH_WORD = 5;
        String[] wordsForTask2 = buildStringArray(WORDS_COUNT);
        System.out.printf("Список слов длиннее %d символов:%n", MIN_LENGTH_WORD);
        int wordNumber = 0;
        for (String word : wordsForTask2) {
            if (word.length() > MIN_LENGTH_WORD) {
                System.out.printf("%d. %s%n", ++wordNumber, word);
            }
        }
        if (wordNumber == 0) {
            System.out.println("к сожалению, подходящих слов в массиве нет =(");
        }


        // Задача №3
        System.out.println("\n3. Создайте массив целых чисел и найдите минимальное" +
                " и максимальное значение в нем");
        final int ARRAY_LENGTH = 13;
        randomIntArray = buildRandomIntArray(ARRAY_LENGTH);
        System.out.println("Минимальное значение в массиве = " + minElementArray(randomIntArray));
        System.out.println("Максимальное значение в массиве = " + maxElementArray(randomIntArray));


        // Задача №4
        System.out.println("\n4. Создайте массив целых чисел и отсортируйте его по возрастанию");
        // Будем использовать массив из предыдущего задания
        System.out.printf("%-33s", "Исходный массив:");
        System.out.println(Arrays.toString(randomIntArray));

        // Реализуем алгоритм сортировки выбором
        for (int i = 0; i < randomIntArray.length; i++) {
            int minValue = randomIntArray[i];
            int indexMin = i;

            for (int j = i; j < randomIntArray.length; j++) {
                if (minValue > randomIntArray[j]) {
                    minValue = randomIntArray[j];
                    indexMin = j;
                }
            }
            randomIntArray[indexMin] = randomIntArray[i];
            randomIntArray[i] = minValue;
        }

        System.out.printf("%-33s", "Массив после сортировки выбором:");
        System.out.println(Arrays.toString(randomIntArray));


        // Задача №5
        System.out.println("\n5. Создайте двумерный массив и выведите на экран сумму каждой строки");
        final int ROWS_COUNT = 3;
        final int COLS_COUNT = 5;
        int[][] randomIntMatrix = buildRandomIntMatrix(ROWS_COUNT, COLS_COUNT);

        for (int i = 0; i < ROWS_COUNT; i++) {
            int rowSum = sumArrayElements(randomIntMatrix[i]);
            System.out.printf("Сумма чисел в %d-й строке равна %d%n", (i + 1), rowSum);
        }


        // Задача №6
        System.out.println("\n6. Создайте двумерный массив и найдите наименьший элемент в каждом столбце");
        // Размеры массива будут взяты из предыдущего задания
        randomIntMatrix = buildRandomIntMatrix(ROWS_COUNT, COLS_COUNT);

        int minNumInRow;
        for (int i = 0; i < COLS_COUNT; i++) {
            minNumInRow = randomIntMatrix[0][i];
            for (int j = 0; j < ROWS_COUNT; j++) {
                if (minNumInRow > randomIntMatrix[j][i]) {
                    minNumInRow = randomIntMatrix[j][i];
                }
            }
            System.out.printf("Наименьшее число в %d-м столбце равно %d%n", (i + 1), minNumInRow);
        }


        // Задача №7
        System.out.println("\n7. Создайте массив целых чисел и определите, является ли он палиндромом");
        // Зададим массив вручную, т.к. вероятность получить палиндромом при случайной генерации близка к 0
        int[] intArray = {5, 2, 4, 12, 7, 0, 7, 12, 4, 2, 5};

        boolean isPalindrome = true;
        int lastIndex = intArray.length - 1;

        for (int i = 0; i < intArray.length / 2; i++) {
            if (intArray[i] != intArray[lastIndex - i]) {
                isPalindrome = false;
                break;
            }
        }
        if (isPalindrome) {
            System.out.println("Созданный массив " + Arrays.toString(intArray) +
                    " является палиндромом");
        } else {
            System.out.println("Созданный массив " + Arrays.toString(intArray) +
                    " не является палиндромом");
        }


        // Задача №8
        System.out.println("\n8. Вычислить средние значения элементов подмассивов в неравномерном массиве" +
                " и записать результаты в новый массив");
        // Массив взят из задания
        int[][] inconsistentLengthArray = {{1, 2, 3}, {4, 5}, {6, 7, 8, 9}};
        int arrayLength = inconsistentLengthArray.length;
        double[] arrayAverageValues = new double[arrayLength];
        for (int i = 0; i < arrayAverageValues.length; i++) {
            if (inconsistentLengthArray[i].length > 0) {
                arrayAverageValues[i] = sumArrayElements(inconsistentLengthArray[i]) /
                        (double) inconsistentLengthArray[i].length;
            }
        }
        System.out.println(Arrays.toString(arrayAverageValues));


        // Задача №9
        System.out.println("\n9. Найти максимальную сумму элементов подмассива в неравномерном массиве");
        final int SUBARRAY_COUNT = 7;
        final int MIN_ARRAY_LENGTH = 3;
        final int MAX_ARRAY_LENGTH = 3;
        final int MIN_VALUE = -100;
        final int MAX_VALUE = 100;
        // Создадим массив, определяеющий длины элементов в неравномерном массиве
        // По заданию подмассивы могут содержать от 3 до 10 элементов включительно
        int[] subarrayLengths = buildRandomIntArray(SUBARRAY_COUNT, MIN_ARRAY_LENGTH, MAX_ARRAY_LENGTH, false);

        // Создадим неравномерный массив
        int[][] irregularArray = new int[SUBARRAY_COUNT][];
        for (int i = 0; i < SUBARRAY_COUNT; i++) {
            // Создадим подмассив случайных чисел в диапозоне от -100 до 100
            int[] array = buildRandomIntArray(subarrayLengths[i], MIN_VALUE, MAX_VALUE, false);
            irregularArray[i] = array;
        }

        System.out.println("Созданный неравномерный массив:");
        for (int[] row : irregularArray) {
            System.out.println(Arrays.toString(row));
        }

        // Создадим одномерный массив с суммами элементов подмассивов
        int[] sumArray = new int[SUBARRAY_COUNT];
        for (int i = 0; i < SUBARRAY_COUNT; i++) {
            sumArray[i] = sumArrayElements(irregularArray[i]);
        }
        System.out.println("\nОдномерный массив, содержащий суммы элементов подмассивов:");
        System.out.println(Arrays.toString(sumArray));

        System.out.println("\nМаксимальная сумма = " + maxElementArray(sumArray));
        System.out.println("Минимальная сумма = " + minElementArray(sumArray));
        System.out.printf("Среднее значение = %.2f%n", (float) sumArrayElements(sumArray) / SUBARRAY_COUNT);
    }


    // Генератор массива случайных целых чисел в диапозоне от minValue до maxValue
    private static int[] buildRandomIntArray(int arraySize, int minValue, int maxValue, boolean printArray) {
        Random random = new Random();
        int[] numbers = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            // заполняем каждый элемент случайным числом от minValue до maxValue
            numbers[i] = random.nextInt(maxValue + 1 - minValue) + minValue;
        }

        // выводим массив на экран
        if (printArray) {
            System.out.printf("Созданный массив длиной %d: ", arraySize);
            System.out.println(Arrays.toString(numbers));
        }
        return numbers;
    }

    private static int[] buildRandomIntArray(int arraySize) {
        int minValue = 0;
        int maxValue = 20;
        boolean printArray = true;
        return buildRandomIntArray(arraySize, minValue, maxValue, printArray);
    }


    // Генератор массива слов. Слова выбираются из перечня доступных слов случайным образом
    private static String[] buildStringArray(int arraySize, boolean printArray) {
        String[] availableWordsDictionary = {"ад", "пол", "сок", "емкость", "собака", "обед", "возница",
                "наручник", "мел", "дневник", "кран", "ноготь", "овечка", "сани", "карточка", "империя",
                "фирма", "алебарда", "икона", "бал", "каракуль", "витамин", "ворона", "макет", "косынка",
                "кружево", "дождевик", "кандалы", "бассейн", "кокон", "кратер", "тюлень", "зола", "дом",
                "кладовка", "кетчуп", "плющ", "листок", "ловушка", "таверна", "бандит", "инструмент",
                "сироп", "лесоруб", "бор", "кот", "мама", "час", "нога", "ваза"};
        int maxIndex = availableWordsDictionary.length;

        Random random = new Random();
        String[] wordsArray = new String[arraySize];
        for (int i = 0; i < arraySize; i++) {
            // заполняем каждый элемент случайным словом из словаря
            int index = random.nextInt(maxIndex);
            wordsArray[i] = availableWordsDictionary[index];
        }
        // выводим массив на экран
        if (printArray) {
            System.out.printf("Созданный массив длиной %d: ", arraySize);
            System.out.println(Arrays.toString(wordsArray));
        }
        return wordsArray;
    }

    private static String[] buildStringArray(int arraySize) {
        boolean printArray = true;
        return buildStringArray(arraySize, printArray);
    }


    // Генератор матрицы, заполненной случайными числами от minValue до maxValue
    private static int[][] buildRandomIntMatrix(int rows, int cols, int minValue, int maxValue, boolean printArray) {
        int[][] numbers = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            numbers[i] = buildRandomIntArray(cols, minValue, maxValue, false);
        }

        if (printArray) {
            System.out.printf("Созданный массив размером %dx%d:%n", rows, cols);
            for (int[] row : numbers) {
                System.out.println(Arrays.toString(row));
            }
        }
        return numbers;
    }

    private static int[][] buildRandomIntMatrix(int rows, int cols) {
        int minValue = 0;
        int maxValue = 50;
        boolean printArray = true;
        int[][] numbers = buildRandomIntMatrix(rows, cols, minValue, maxValue, printArray);
        return numbers;
    }

    // Математические функции
    private static int sumArrayElements(int[] array) {
        int sumElements = 0;
        for (int number : array) {
            sumElements += number;
        }
        return sumElements;
    }

    private static int minElementArray(int[] array) {
        int minElement = array[0];
        for (int number : array) {
            if (minElement > number) {
                minElement = number;
            }
        }
        return minElement;
    }

    private static int maxElementArray(int[] array) {
        int maxElement = array[0];
        for (int number : array) {
            if (maxElement < number) {
                maxElement = number;
            }
        }
        return maxElement;
    }
}
