import java.math.BigDecimal;

public class Triangle extends Figure {
    private BigDecimal height;
    private BigDecimal base;

    public Triangle(BigDecimal height, BigDecimal base) {
        this.height = height.setScale(2, BigDecimal.ROUND_HALF_UP);
        this.base = base.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    @Override
    BigDecimal calculateArea() {
        return height
                .multiply(base)
                .divide(new BigDecimal(2))
                .setScale(2, BigDecimal.ROUND_HALF_UP);
    }
}
