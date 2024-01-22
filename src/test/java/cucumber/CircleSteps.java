package cucumber;

import Lesson6_1.Circle;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Если;
import io.cucumber.java.ru.То;
import lombok.Getter;
import org.junit.jupiter.api.Assertions;

@Getter
public class CircleSteps {
    Circle circle;
    private int initialRadius;
    private int actualRadius;
    private String type;
    private double perimeter;
    private double area;
    private IllegalArgumentException error;


    @Дано("окружность с радиусом {int}")
    // При попытке создать окружность с радиусом <= 0, поймаем выброшенное исключение
    public void circleWithGivenRadius(int radius) {
        try {
            this.initialRadius = radius;
            this.circle = new Circle(initialRadius);
        } catch (IllegalArgumentException e) {
            error = e;
        }

    }

    @Дано("окружность с незаданным радиусом")
    public void circleWithUnspecifiedRadius() {
        this.circle = new Circle();
    }


    @Если("запросить информацию о радиусе окружности")
    public void requestInformationAboutRadiusCircle() {
        actualRadius = circle.getRadius();
    }

    @Если("задать радиус окружности равным {int}")
    // При попытке создать окружность с радиусом <= 0, поймаем выброшенное исключение
    public void setCircleRadiusEqual(int radius) {
        try {
            circle.setRadius(radius);
        } catch (IllegalArgumentException e) {
            error = e;
        }
    }

    @Если("запросить информацию о типе объекта")
    public void requestObjectTypeInformation() {
        this.type = circle.getType();
    }

    @Если("вычислить {string} окружности")
    // Проверяемый метод может рассчитать периметр и площадь окружности,
    // в остальных случаях будет выброшено исключение
    public void calculateParameterCircle(String param) {
        switch (param) {
            case "периметр":
                this.perimeter = circle.calculatePerimeter();
                break;
            case "площадь":
                this.area = circle.calculateArea();
                break;
            default:
                throw new IllegalArgumentException(
                        "Данный параметр для окружности не определен." +
                                " Доступные значения: периметр и площадь");
        }
    }


    @То("радиус созданной окружности должен быть равен {int}")
    public void circleRadiusMustBeEqual(int expectedValue) {
        Assertions.assertEquals(circle.getRadius(), expectedValue);
    }

    @То("радиус окружности не должен быть равен {int}")
    public void circleRadiusShouldNotBeEqual(int expectedValue) {
        Assertions.assertNotEquals(circle.getRadius(), expectedValue);
    }

    @То("тип объекта должен быть равен {string}")
    public void objectTypeMustBeEqual(String expectedValue) {
        Assertions.assertEquals(circle.getType(), expectedValue);
    }

    @То("параметр {string} должен быть равен {double} с точность {double}")
    public void calculatedParameterMustBeEqualToAccuracy(String param, double expectedValue, double accuracy) {
        switch (param) {
            case "периметр":
                Assertions.assertEquals(perimeter, expectedValue, accuracy);
                break;
            case "площадь":
                Assertions.assertEquals(area, expectedValue, accuracy);
                break;
            default:
                throw new IllegalArgumentException("Данный параметр для окружности не определен." +
                        " Доступные значения: периметр и площадь");
        }
    }

    @То("должно быть выброшено исключение {string}")
    public void exceptionMustBeThrown(String message) {
        Assertions.assertNotEquals(error, null);
        Assertions.assertEquals(error.getMessage(), message);
    }
}