package Lesson6_1;

public interface Message {
    String MESSAGE_TYPE = "Тип фигуры: ";
    String MESSAGE_SIZE = "Размеры фигуры: ";
    String MESSAGE_PERIMETER = "Периметр фигуры: ";
    String MESSAGE_AREA = "Площадь фигуры: ";
    String SIZE_ERROR_MESSAGE = "ERROR: Для создания фигуры необходимо использовать целые числа больше 0";
    String TRIANGLE_SIZE_ERROR_MESSAGE = "ERROR: Треугольник с такими параметрами не может быть создан";
    String INVALID_VALUE_ERROR_MESSAGE = "ERROR: Параметр sideNumber может иметь значение 1, 2 или 3";
}