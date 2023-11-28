package Lesson4;

import java.util.Random;
import java.util.Arrays;

public class ArraysTheme {
    public static void main(String[] args) {
        System.out.println("1. Создайте массив целых чисел и найдите его сумму");
        final int LENGTH = 5;
        int[] arrayForTask1 = BuildRandomIntArray(LENGTH);

        int sumNumbers = SumArrayElements(arrayForTask1);
        System.out.println("Сумма элементов массива равна " + sumNumbers);


        System.out.println("\n2. Создайте массив строк и выведите на экран все строки, " +
                "у которых длина больше 5 символов");
        final int WORDSCOUNT = 7;
        final int MIN_LENGTH_WORD = 5;
        String[] wordsForTask2 = BuildStringArray(WORDSCOUNT);
        int numberWord = 0;
        System.out.println("Список слов длинее 5 символов:");
        for (String word : wordsForTask2) {
            if (word.length() > MIN_LENGTH_WORD) {
                System.out.printf("%d. %s%n", ++numberWord, word);
            }
        }
        if (numberWord == 0) {
            System.out.println("к сожалению, подходящих слов в массиве нет =(");
        }


        System.out.println("\n3. Создайте массив целых чисел и найдите минимальное" +
                " и максимальное значение в нем");
        final int LENGTH_ARRAY = 13;
        int[] randomIntArray = BuildRandomIntArray(LENGTH_ARRAY);
        int minNumber = MinElementArray(randomIntArray);
        int maxNumber = MaxElementArray(randomIntArray);
        System.out.println("Минимальное значение в массиве = " + minNumber);
        System.out.println("Максимальное значение в массиве = " + maxNumber);


        System.out.println("\n4. Создайте массив целых чисел и отсортируйте его по возрастанию");
        // Будем использовать массив из предыдущего задания
        System.out.printf("%-33s", "Исходный массив:");
        System.out.println(Arrays.toString(randomIntArray));

        // Реализуем алгоритм сортировки выбором
        for (int i = 0; i < randomIntArray.length; i++) {
            int minValue = randomIntArray[i];
            int indexMinValue = i;

            for (int j = i; j < randomIntArray.length; j++) {
                if (minValue > randomIntArray[j]) {
                    minValue = randomIntArray[j];
                    indexMinValue = j;
                }
            }
            randomIntArray[indexMinValue] = randomIntArray[i];
            randomIntArray[i] = minValue;
        }

        System.out.printf("%-33s", "Массив после сортировки выбором:");
        System.out.println(Arrays.toString(randomIntArray));


        System.out.println("\n5. Создайте двумерный массив и выведите на экран сумму каждой строки");
        final int ROWS_COUNT = 3;
        final int COLS_COUNT = 5;
        int[][] arrayForTask5 = BuildRandomIntMatrix(ROWS_COUNT, COLS_COUNT);

        int sumNumInRow;
        for (int i = 0; i < ROWS_COUNT; i++) {
            sumNumInRow = SumArrayElements(arrayForTask5[i]);
            System.out.printf("Сумма чисел в %d-й строке равна %d%n", (i + 1), sumNumInRow);
        }


        System.out.println("\n6. Создайте двумерный массив и найдите наименьший элемент в каждом столбце");
        // Размеры массива будут взяты из предыдущего задания
        int[][] arrayForTask6 = BuildRandomIntMatrix(ROWS_COUNT, COLS_COUNT);

        int minNumInRow;
        for (int i = 0; i < COLS_COUNT; i++) {
            minNumInRow = arrayForTask6[0][i];
            for (int j = 0; j < ROWS_COUNT; j++) {
                if (minNumInRow > arrayForTask6[j][i]) {
                    minNumInRow = arrayForTask6[j][i];
                }
            }
            System.out.printf("Наименьшее число в %d-м столбце равно %d%n", (i + 1), minNumInRow);
        }


        System.out.println("\n7. Создайте массив целых чисел и определите, является ли он палиндромом");
        // Зададим массив вручную, т.к. вероятность получить палиндромом при случайной генерации близка к 0
        int[] arrayForTask7 = {5, 2, 4, 12, 7, 0, 7, 12, 4, 2, 5};

        boolean isPalindrome = true;
        int lastIndex = arrayForTask7.length - 1;

        for (int i = 0; i < arrayForTask7.length / 2; i++) {
            if (arrayForTask7[i] != arrayForTask7[lastIndex - i]) {
                isPalindrome = false;
                break;
            }
        }
        if (isPalindrome) {
            System.out.println("Созданный массив " + Arrays.toString(arrayForTask7) +
                    " является палиндромом");
        } else {
            System.out.println("Созданный массив " + Arrays.toString(arrayForTask7) +
                    " не является палиндромом");
        }


        System.out.println("\n8. Вычислить средние значения элементов подмассивов в неравномерном массиве" +
                " и записать результаты в новый массив");
        // Массив взят из задания
        int[][] arrayForTask8 = {{1, 2, 3}, {4, 5}, {6, 7, 8, 9}};
        int lenArray = arrayForTask8.length;
        double[] arrayAverageValues = new double[lenArray];
        for (int i = 0; i < arrayAverageValues.length; i++) {
            arrayAverageValues[i] = SumArrayElements(arrayForTask8[i]) / (double) arrayForTask8[i].length;
        }
        System.out.println(Arrays.toString(arrayAverageValues));


        System.out.println("\n\n9. Найти максимальную сумму элементов подмассива в неравномерном массиве");
        final int SUBARRAY_COUNT = 7;
        // Создадим массив, определяеющий длины элементов в неравномерном массиве
        // По заданию подмассивы могут содержать от 3 до 10 элементов включительно
        int[] subarrayLengths = BuildRandomIntArray(SUBARRAY_COUNT, 3, 10, false);

        // Создадим неравномерный массив
        int[][] irregularArray = new int[SUBARRAY_COUNT][];
        for (int i = 0; i < SUBARRAY_COUNT; i++) {
            // Создадим подмассив случайных чисел в диапозоне от -100 до 100
            int[] array = BuildRandomIntArray(subarrayLengths[i], -100, 100, false);
            irregularArray[i] = array;
        }

        System.out.println("Созданный неравномерный массив:");
        for (int[] row : irregularArray) {
            System.out.println(Arrays.toString(row));
        }

        // Создадим одномерный массив с суммами элементов подмассивов
        int[] arrayWithSum = new int[SUBARRAY_COUNT];
        for (int i = 0; i < SUBARRAY_COUNT; i++) {
            arrayWithSum[i] = SumArrayElements(irregularArray[i]);
        }
        System.out.println("\nОдномерный массив, содержащий суммы элементов подмассивов:");
        System.out.println(Arrays.toString(arrayWithSum));

        System.out.println("\nМаксимальная сумма = " + MaxElementArray(arrayWithSum));
        System.out.println("Минимальная сумма = " + MinElementArray(arrayWithSum));
        System.out.printf("Среднее значение = %.2f%n", (float) SumArrayElements(arrayWithSum) / SUBARRAY_COUNT);
    }


    // Генератор массива случайных целых чисел в диапозоне от minValue до maxValue
    private static int[] BuildRandomIntArray(int sizeArray, int minValue, int maxValue, boolean printArray) {
        Random random = new Random();
        int[] numsArray = new int[sizeArray];
        for (int i = 0; i < sizeArray; i++) {
            // заполняем каждый элемент случайным числом от minValue до maxValue
            numsArray[i] = random.nextInt(maxValue + 1 - minValue) + minValue;
        }

        // выводим массив на экран
        if (printArray) {
            System.out.printf("Созданный массив длиной %d: ", sizeArray);
            System.out.println(Arrays.toString(numsArray));
        }
        return numsArray;
    }

    private static int[] BuildRandomIntArray(int sizeArray) {
        int minValue = 0;
        int maxValue = 20;
        boolean printArray = true;
        return BuildRandomIntArray(sizeArray, minValue, maxValue, printArray);
    }


    // Генератор массива слов. Слова выбираются из перечня доступных слов случайным образом
    private static String[] BuildStringArray(int sizeArray, boolean printArray) {
        String[] dictionaryAvailableWords = {"ад", "пол", "сок", "емкость", "собака", "обед", "возница",
                "наручник", "мел", "дневник", "кран", "ноготь", "овечка", "сани", "карточка", "империя",
                "фирма", "алебарда", "икона", "бал", "каракуль", "витамин", "ворона", "макет", "косынка",
                "кружево", "дождевик", "кандалы", "бассейн", "кокон", "кратер", "тюлень", "зола", "дом",
                "кладовка", "кетчуп", "плющ", "листок", "ловушка", "таверна", "бандит", "инструмент",
                "сироп", "лесоруб", "бор", "кот", "мама", "час", "нога", "ваза"};
        int maxIndex = dictionaryAvailableWords.length;

        Random random = new Random();
        String[] wordArray = new String[sizeArray];
        for (int i = 0; i < sizeArray; i++) {
            // заполняем каждый элемент случайным словом из словаря
            int index = random.nextInt(maxIndex);
            wordArray[i] = dictionaryAvailableWords[index];
        }
        // выводим массив на экран
        if (printArray) {
            System.out.printf("Созданный массив длиной %d: ", sizeArray);
            System.out.println(Arrays.toString(wordArray));
        }
        return wordArray;
    }

    private static String[] BuildStringArray(int sizeArray) {
        boolean printArray = true;
        return BuildStringArray(sizeArray, printArray);
    }


    // Генератор матрицы, заполненной случайными числами от minValue до maxValue
    private static int[][] BuildRandomIntMatrix(int rows, int cols, int minValue, int maxValue, boolean printArray) {
        int[][] numsArray = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            numsArray[i] = BuildRandomIntArray(cols, minValue, maxValue, false);
        }

        if (printArray) {
            System.out.printf("Созданный массив размером %dx%d:%n", rows, cols);
//            System.out.println(Arrays.deepToString(numsArray)); // Вывод двумерного массива в одну строку
            for (int[] row : numsArray) {
                System.out.println(Arrays.toString(row));
            }
        }
        return numsArray;
    }

    private static int[][] BuildRandomIntMatrix(int rows, int cols) {
        int minValue = 0;
        int maxValue = 50;
        boolean printArray = true;
        int[][] numsArray = BuildRandomIntMatrix(rows, cols, minValue, maxValue, printArray);
        return numsArray;
    }


    // Математические функции
    private static int SumArrayElements(int[] array) {
        int sumElements = 0;
        for (int number : array) {
            sumElements += number;
        }
        return sumElements;
    }

    private static int MinElementArray(int[] array) {
        int minElement = array[0];
        for (int number : array) {
            if (minElement > number) {
                minElement = number;
            }
        }
        return minElement;
    }

    private static int MaxElementArray(int[] array) {
        int maxElement = array[0];
        for (int number : array) {
            if (maxElement < number) {
                maxElement = number;
            }
        }
        return maxElement;
    }
}
