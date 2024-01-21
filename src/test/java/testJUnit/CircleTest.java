package testJUnit;

import Lesson6_1.Circle;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

abstract class CircleLogger implements Logger {
    static public Logger getLogger() {
        return LoggerFactory.getLogger(CircleTest.class);
    }
}

class CircleTest {
    final Logger logger = CircleLogger.getLogger();
    final int initialRadius = 5;

    @BeforeAll
    static void initAll() {
        Logger loggerBefore = CircleLogger.getLogger();
        loggerBefore.info("Тестирование класса Circle запущено\n");
    }

    @Test
    void getRadius() {
        logger.debug("Вызван конструктор метода Circle с параметром {}", initialRadius);
        Circle circle = new Circle(initialRadius);

        logger.debug("Проверка радиуса созданной окружности: он равен {}\n", circle.getRadius());
        Assertions.assertEquals(circle.getRadius(), initialRadius);
    }

    @Test
    void setRadius() {
        logger.debug("Вызван конструктор метода Circle без параметра");
        Circle circle = new Circle();

        logger.debug("Установлен новый радиус окружности равный {}", initialRadius);
        circle.setRadius(initialRadius);

        logger.debug("Проверка радиуса созданной окружности: он равен {}\n", circle.getRadius());
        Assertions.assertEquals(circle.getRadius(), initialRadius);
    }

    @Test
    void changeRadius() {
        logger.debug("Вызван конструктор метода Circle с параметром {}", initialRadius);
        Circle circle = new Circle(initialRadius);

        int newRadius = initialRadius + (int) (Math.random() * 10);
        logger.debug("Радиус окружности изменен с {} на {}", initialRadius, newRadius);
        circle.setRadius(newRadius);

        logger.debug("Проверка, что изменение выполнено успешно\n");
        Assertions.assertNotEquals(circle.getRadius(), initialRadius);
    }

    @Test
    void getType() {
        logger.debug("Вызван конструктор метода Circle без параметра");
        Circle circle = new Circle();

        logger.debug("Проверка, что при запросе типа фигуры получено значение \"окружность\"\n");
        Assertions.assertEquals(circle.getType(), "окружность");
    }

    @Test
    void calculatePerimeter() {
        logger.debug("Вызван конструктор метода Circle с параметром {}", initialRadius);
        Circle circle = new Circle(initialRadius);

        logger.debug("Вычисление периметра окружности и сравнение с ожидаемым значением\n");
        double result = circle.calculatePerimeter();

        Assertions.assertEquals(result, 31.416, 0.001);
    }

    @Test
    void calculateArea() {
        logger.debug("Вызван конструктор метода Circle с параметром {}", initialRadius);
        Circle circle = new Circle(initialRadius);

        logger.debug("Вычисление площади окружности и сравнение с ожидаемым значением\n");
        double result = circle.calculateArea();

        Assertions.assertEquals(result, 78.54, 0.001);
    }

    // Негативный тест. При невалидном значении радиуса должно быть выброшено исключение
    @ParameterizedTest
    @ValueSource(ints = {0, -10})
    void createCircleWithNotValidValue(int radius) {
        logger.error("Вызван конструктор метода Circle с невалидным значением \"{}\"\n", radius);
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                new Circle(radius)
        );
    }

    // Негативный тест. При изменении радиуса на невалидное значение должно быть выброшено исключение
    @ParameterizedTest
    @ValueSource(ints = {0, -10})
    void changeRadiusOnNotValidValue(int radius) {
        logger.debug("Вызван конструктор метода Circle с параметром {}", initialRadius);
        Circle circle = new Circle(initialRadius);

        logger.error("Изменение радиуса окружности на невалидное значение \"{}\"\n", radius);
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                circle.setRadius(radius)
        );
    }

    @AfterAll
    static void tearDownAll() {
        Logger loggerAfter = CircleLogger.getLogger();
        loggerAfter.info("Тестирование класса Circle завершено");
    }
}