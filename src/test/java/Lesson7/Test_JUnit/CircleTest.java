package Lesson7.Test_JUnit;

import Lesson6_1.Circle;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CircleTest {
    final int initialRadius = 5;

    @Test
    void getRadius() {
        Circle circle = new Circle(initialRadius);

        Assertions.assertEquals(circle.getRadius(), initialRadius);
    }

    @Test
    void setRadius() {
        Circle circle = new Circle();

        circle.setRadius(initialRadius);

        Assertions.assertEquals(circle.getRadius(), initialRadius);
    }

    @Test
    void changeRadius() {
        Circle circle = new Circle(initialRadius);

        circle.setRadius(initialRadius + 2);

        Assertions.assertNotEquals(circle.getRadius(), initialRadius);
    }

    @Test
    void getType() {
        Circle circle = new Circle();

        Assertions.assertEquals(circle.getType(), "окружность");
    }

    @Test
    void calculatePerimeter() {
        Circle circle = new Circle(initialRadius);

        double result = circle.calculatePerimeter();

        Assertions.assertEquals(result, 31.416, 0.001);
    }

    @Test
    void calculateArea() {
        Circle circle = new Circle(initialRadius);

        double result = circle.calculateArea();

        Assertions.assertEquals(result, 78.54, 0.001);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -10})
    void createCircleWithNotValidValue(int radius) {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Circle(radius)
        );
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -10})
    void changeRadiusOnNotValidValue(int radius) {
        Circle circle = new Circle(initialRadius);
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                circle.setRadius(radius)
        );
    }
}