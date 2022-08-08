import figures.Circle;
import figures.Square;
import figures.Triangle;

import java.math.BigDecimal;

public class Test {
    public static void main(String[] args) {
        Circle circle = new Circle(new BigDecimal(1.55));
        Square square = new Square(new BigDecimal(2.345));
        Triangle triangle = new Triangle(new BigDecimal(1.57), new BigDecimal(2.3));

        System.out.println("area of circle: " + circle.getArea());
        System.out.println("area of square: " + square.getArea());
        System.out.println("area of triangle: " + triangle.getArea());
    }
}
