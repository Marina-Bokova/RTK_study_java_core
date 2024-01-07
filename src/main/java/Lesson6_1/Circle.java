package Lesson6_1;

public class Circle implements FigureInterface {
    private int radius; // радиус окружности

    public Circle() {
    }

    public Circle(int radius) {
        this.radius = validate(radius);
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = validate(radius);
    }

    @Override
    public String getType() {
        return "окружность";
    }

    @Override
    public String getSize() {
        return String.format("радиус = %d", radius);
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}