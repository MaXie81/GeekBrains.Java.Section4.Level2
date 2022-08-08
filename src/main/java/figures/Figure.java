package figures;

import java.math.BigDecimal;

abstract public class Figure {
    protected BigDecimal area;

    abstract BigDecimal calculateArea();

    public BigDecimal getArea() {
        return area;
    }
}