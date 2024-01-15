package cucumber;

import Lesson6_1.Circle;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Если;
import io.cucumber.java.ru.То;
import org.junit.jupiter.api.Assertions;

public class CircleSteps {
    Circle circle;
    int initialRadius;
    int actualRadius;
    String type;
    double perimeter;
    double area;

    @Дано("окружность с радиусом {int}")
    public void circleWithGivenRadius(int radius) {
        this.initialRadius = radius;
        this.circle = new Circle(initialRadius);
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
    public void setCircleRadiusEqual(int radius) {
        circle.setRadius(radius);
    }

    @Если("запросить информацию о типе объекта")
    public void requestObjectTypeInformation() {
        this.type = circle.getType();
    }

    @Если("вычислить {string} окружности")
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
                        "Данный параметр для окружности неопределен." +
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
    public void calculatedParameterMustBeEqualToAccuracy(String param, double expectedValue, double aaccuracy) {
        switch (param) {
            case "периметр":
                Assertions.assertEquals(perimeter, expectedValue, aaccuracy);
                break;
            case "площадь":
                Assertions.assertEquals(area, expectedValue, aaccuracy);
                break;
            default:
                throw new IllegalArgumentException("Данный параметр для окружности неопределен." +
                        " Доступные значения: периметр и площадь");
        }
    }

//
//    @То("должно быть выбрашено исключение {string}")
//    public void должноБытьВыбрашеноИсключение(String arg0) {
//    }
}

