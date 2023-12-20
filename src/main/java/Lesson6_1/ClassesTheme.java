package Lesson6_1;

import java.util.Random;

public class ClassesTheme implements Message {
    public static void main(String[] args) {
        // Создаем генератор псевдослучайных чисел
        Random r = new Random();

        // Создание окружности с помощью конструктора с аргументами
        System.out.println("1. Создание окружности с помощью конструктора с аргументами и изменение радиуса");
        int radius = r.nextInt(20) + 1; // "+ 1" для исключения 0 из возможных значений
        Circle myCircle = new Circle(radius);
        myCircle.printDetails();
        myCircle.setRadius(r.nextInt(20) + 1);
        System.out.println("\nИзменение радиуса окружности: новый радиус" + myCircle.getRadius());
        System.out.println("Новое значение периметра: " + myCircle.calculatePerimeter());
        System.out.println("Новое значение площади: " + myCircle.calculateArea());

        // Создание прямоугольник с помощью пустого конструктора с аргументами и получение длин сторон
        System.out.println("\n\n2. Создание прямоугольника с помощью пустого конструктора и получение значений сторон");
        Rectangle myRectangle = new Rectangle();
        myRectangle.setLength(r.nextInt(20) + 1);
        myRectangle.setWidth(r.nextInt(20) + 1);
        myRectangle.printDetails();
        System.out.println("\nШирина прямоугольника = " + myRectangle.getWidth());
        System.out.println("Длина прямоугольника = " + myRectangle.getLength());

        // Создание треугольника с помощью конструктора с аргументами и изменение сторон
        System.out.println("\n\n3. Создание треугольника конструктора и изменение одной из сторон");
        int firstSide = 10;
        int secondSide = 12;
        int thirdSide = 5;
        Triangle myTriangle = new Triangle(firstSide, secondSide, thirdSide);
        myTriangle.printDetails();
        System.out.println("\nИзменение второй стороны");
        int newSecondSide = 8;
        myTriangle.setSide(2, newSecondSide);
        myTriangle.printDetails();

        System.out.println("\n\n4. Негативные сценарии");
        System.out.println("4.1 Изменение радиуса на отрицательное значение");
        try {
            Circle errorCircle = new Circle();
            myCircle.setRadius(-5);
        } catch (IllegalArgumentException e) {
            System.out.println(SIZE_ERROR_MESSAGE);
        }

        System.out.println("\n4.2 Создание прямоугольника с длиной = 0 и шириной = 5");
        try {
            Rectangle errorRectangle = new Rectangle(0, 5);
        } catch (IllegalArgumentException e) {
            System.out.println(SIZE_ERROR_MESSAGE);
        }

        System.out.println("\n4.3 Создание треугольника со сторонами 5, 5, 25");
        try {
            Triangle errorTriangle = new Triangle(5, 5, 25);
        } catch (IllegalArgumentException e) {
            System.out.println(TRIANGLE_SIZE_ERROR_MESSAGE);
        }

        System.out.println("\n4.4 Изменение стороны треугольника на значение больше допустимого");
        System.out.println("Попробуем изменить первую стороны до 15");
        try {
            Triangle newTriangle = new Triangle();
            newTriangle.setSide(1, 15);
        } catch (IllegalArgumentException e) {
            System.out.println(TRIANGLE_SIZE_ERROR_MESSAGE);
        }

        System.out.println("\n4.5 Попробуем изменить несуществующую сторону треугольника");
        try {
            Triangle newTriangle = new Triangle(3, 4, 5);
            newTriangle.setSide(5, 6);
        } catch (IllegalArgumentException e) {
            System.out.println(INVALID_VALUE_ERROR_MESSAGE);
        }
    }
}