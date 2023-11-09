package Lesson1;

public class VariablesTheme {
    public static void main(String[] args) {
        System.out.println("1. Вывод характеристик компьютера");
        boolean isLaptop = true;
        char osType = 'W';
        byte osVersion = 10;
        short osBitDepth = 64;
        int numberCores = 4;
        long ssdVolume = 510_560_374_784L;
        float ram = 16.0F;
        double cpuFrequency = 2.80;

        System.out.println("Устройство является ноутбуком: " + isLaptop);
        System.out.println("Код операционной системы: " + osType);  // W = Windows, L = Linux, M = MacOS
        System.out.println("Версия операционной системы: " + osVersion);
        System.out.println("Разрядность операционной системы: " + osBitDepth);
        System.out.println("Количество ядер: " + numberCores);
        System.out.println("Объем памяти: " + ssdVolume + " байт");
        System.out.println("Объем оперативной памяти: " + String.format("%.1f", ram) + " ГБ");
        System.out.println("Частота процессора: " + String.format("%.2f", cpuFrequency) + " ГГц");


        System.out.println("\n2. Расчет стоимости товара со скидкой");
        var penPrice = 100;
        var bookPrice = 200;
        var amountDiscount = 0.11;
        var withoutDiscount = penPrice + bookPrice;
        var discount = withoutDiscount * amountDiscount;
        var totalWithDiscount = withoutDiscount - discount;

        System.out.println("Общая стоимость товаров без скидки: " + withoutDiscount + " руб.");
        System.out.println("Сумма скидки: " + discount + " руб.");
        System.out.println("Общая стоимость товаров со скидкой: " + totalWithDiscount + " руб.");


        System.out.println("\n3. Вывод слова JAVA");
        System.out.println("   J    a  v     v  a     ");
        System.out.println("   J   a a  v   v  a a    ");
        System.out.println("J  J  aaaaa  V V  aaaaa   ");
        System.out.println(" JJ  a     a  V  a     a");


        System.out.println("\n4. Вывод min и max значений целых числовых типов");
        byte byteNumber = 127;
        short shortNumber = 32_767;
        int intNumber = 2_147_483_647;
        long longNumber = 9_223_372_036_854_775_807L;

        System.out.println("byte: " + byteNumber + " " + ++byteNumber + " " + --byteNumber);
        System.out.println("short: " + shortNumber + " " + ++shortNumber + " " + --shortNumber);
        System.out.println("int: " + intNumber + " " + ++intNumber + " " + --intNumber);
        System.out.println("long: " + longNumber + " " + ++longNumber + " " + --longNumber);


        System.out.println("\n5. Перестановка значений переменных");
        var a = 2;
        var b = 5;

        System.out.println("Перестановка с помощью третьей переменной");
        System.out.printf("    До перестановки: a = %d, b = %d\n", a, b);
        var buffer = a;
        a = b;
        b = buffer;
        System.out.printf("    После перестановки: a = %d, b = %d\n", a, b);

        System.out.println("Перестановка с помощью арифметических операций");
        System.out.printf("    До перестановки: a = %d, b = %d\n", a, b);
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.printf("    После перестановки: a = %d, b = %d\n", a, b);

        System.out.println("Перестановка с помощью побитовой операции ^");
        System.out.printf("    До перестановки: a = %d, b = %d\n", a, b);
        a = a ^ b;
        b = b ^ a;
        a = a ^ b;
        System.out.printf("    После перестановки: a = %d, b = %d\n", a, b);


        System.out.println("\n6. Вывод символов и их кодов");
        char code1 = 36;
        System.out.printf("%-4d --  %c\n", (int) code1, code1);
        char code2 = 42;
        System.out.printf("%-4d --  %c\n", (int) code2, code2);
        char code3 = 64;
        System.out.printf("%-4d --  %c\n", (int) code3, code3);
        char code4 = 124;
        System.out.printf("%-4d --  %c\n", (int) code4, code4);
        char code5 = 126;
        System.out.printf("%-4d --  %c\n", (int) code5, code5);


        System.out.println("\n7. Вывод в консоль ASCII-арт Дюка");
        var char1 = '/';
        var char2 = '\\';
        var char3 = '_';
        var char4 = '(';
        var char5 = ')';

        System.out.printf("%5c%-5c\n", char1, char2);
        System.out.printf("%4c  %-4c\n", char1, char2);
        System.out.printf("%3c%c%c%2c%-3c\n", char1, char3, char4, char5, char2);
        System.out.printf(" %-4c%4c \n", char1, char2);

        char[] charsList = {char1, char3, char3, char3, char3, char1, char2, char3, char3, char2};
        System.out.println(charsList);


        System.out.println("\n8. Вывод количества сотен, десятков и единиц числа");
        var targetNumber = 123;
        var units = targetNumber % 10;
        var tens = (targetNumber / 10) % 10;
        var hundreds = targetNumber / 100;
        System.out.println("Число N содержит:");
        System.out.println("  сотен - " + hundreds);
        System.out.println("  десятков - " + tens);
        System.out.println("  единиц - " + units);
        System.out.println("Сумма его цифр = " + (units + tens + hundreds));
        System.out.println("Произведение = " + (units * tens * hundreds));


        System.out.println("\n9. Вывод времени");
        var totalSeconds = 86399;
        var hours = totalSeconds / (60 * 60);
        var minutes = (totalSeconds / 60) % 60;
        var seconds = totalSeconds % 60;
        System.out.printf("%02d:%02d:%02d", hours, minutes, seconds);
    }
}
