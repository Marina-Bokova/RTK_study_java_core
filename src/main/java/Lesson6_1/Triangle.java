package Lesson6_1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Triangle implements FigureInterface {
    // Стороны треугольника
    private int side1;
    private int side2;
    private int side3;

    public Triangle() {
    }

    public Triangle(int side1, int side2, int side3) {
        this.side1 = validate(side1);
        this.side2 = validate(side2);
        this.side3 = validate(side3);
        validateSides();
    }

    // Проверка, что треугольник с такими размерами может существовать
    private void validateSides() {
        List<Integer> sidesList = Arrays.asList(side1, side2, side3);
        // Сортировка списка в порядке возрастания
        Collections.sort(sidesList);
        if (sidesList.get(0) + sidesList.get(1) <= sidesList.get(2)) {
            throw new IllegalArgumentException(TRIANGLE_SIZE_ERROR_MESSAGE +
                    String.format(": %d + %d <= %d", sidesList.get(0), sidesList.get(1), sidesList.get(2)));
        }
    }

    public int getSide(int sideNumber) {
        if (sideNumber == 1) {
            return side1;
        } else if (sideNumber == 2) {
            return side2;
        } else if (sideNumber == 3) {
            return side3;
        } else {
            throw new IllegalArgumentException(INVALID_VALUE_ERROR_MESSAGE);
        }
    }

    public void setSide(int sideNumber, int length) {
        if (sideNumber == 1) {
            side1 = validate(length);
        } else if (sideNumber == 2) {
            side2 = validate(length);
        } else if (sideNumber == 3) {
            side3 = validate(length);
        } else {
            throw new IllegalArgumentException(INVALID_VALUE_ERROR_MESSAGE);
        }
        validateSides();
    }

    @Override
    public String getType() {
        return "треугольник";
    }

    @Override
    public String getSize() {
        return String.format("стороны треугольника равны %d, %d и %d", side1, side2, side3);
    }

    @Override
    public double calculatePerimeter() {
        return side1 + side2 + side3;
    }

    @Override
    public double calculateArea() {
        // Площадь будем определять по трем сторонам
        // Определим полупериметр треугольника
        double p = calculatePerimeter() / 2;
        return Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));
    }
}