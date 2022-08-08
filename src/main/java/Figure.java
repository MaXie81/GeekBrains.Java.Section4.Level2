import java.math.BigDecimal;

abstract public class Figure {
    protected BigDecimal area;

    public Figure() {
        area = calculateArea().setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    abstract BigDecimal calculateArea();

    public BigDecimal getArea() {
        return area;
    }
}