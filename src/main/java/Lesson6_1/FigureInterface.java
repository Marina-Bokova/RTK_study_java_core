package Lesson6_1;

public interface FigureInterface extends Message {
    String getType();

    String getSize();

    double calculatePerimeter();

    double calculateArea();

    default int validate(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException(SIZE_ERROR_MESSAGE);
        }
        return size;
    }

    default void printDetails() {
        System.out.println(MESSAGE_TYPE + getType());
        System.out.println(MESSAGE_SIZE + getSize());
        System.out.printf("%s%.2f%n", MESSAGE_PERIMETER, calculatePerimeter());
        System.out.printf("%s%.2f%n", MESSAGE_AREA, calculateArea());
    }
}