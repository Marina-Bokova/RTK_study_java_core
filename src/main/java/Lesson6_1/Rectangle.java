package Lesson6_1;

public class Rectangle implements FigureInterface {
    // Стороны прямоугольника
    private int length;
    private int width;

    public Rectangle() {
    }

    public Rectangle(int length, int width) {
        this.length = validate(length);
        this.width = validate(width);
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = validate(length);
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = validate(width);
    }

    @Override
    public String getType() {
        return "прямоугольник";
    }

    @Override
    public String getSize() {
        return String.format("длина = %d, ширина = %d", length, width);
    }

    @Override
    public double calculatePerimeter() {
        return (double) 2 * (length + width);
    }

    @Override
    public double calculateArea() {
        return (double) length * width;
    }
}