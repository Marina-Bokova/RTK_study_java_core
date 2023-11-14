package Lesson1;

public class Calculator {
    public static void main(String[] args) {
        int num1 = (int) (Math.random() * 20);
        int num2 = (int) (Math.random() * 20);
        char operation = '*';

        if (num1 >= 0 && num2 >= 0) {
            System.out.println(performCalculation(num1, num2, operation));
        } else {
            System.out.println("Калькулятор работает только с положительными числами");
        }
    }

    public static String performCalculation(int a, int b, char sign) {
        int result;
        if (sign == '+') {
            result = a + b;
        } else if (sign == '-') {
            result = a - b;
        } else if (sign == '*') {
            result = a * b;
        } else if (sign == '/' && b == 0) {
            return "Деление на ноль запрещено";
        } else if (sign == '/') {
            result = a / b;
        } else if (sign == '%') {
            result = a % b;
        } else if (sign == '^') {
            result = raisePower(a, b);
        } else {
            return "Данная операция неопределенна";
        }
        return (a + " " + sign + " " + b + " = " + result);
    }

    private static int raisePower(int a, int b) {
        int resultRaisePower = 1;
        for (var i = 0; i < b; i++) {
            resultRaisePower *= a;
        }
        return resultRaisePower;
    }
}
