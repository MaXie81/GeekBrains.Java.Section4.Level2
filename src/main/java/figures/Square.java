package figures;
import java.math.BigDecimal;

public class Square extends Figure {
    private BigDecimal length;

    public Square(BigDecimal length) {
        this.length = length.setScale(2, BigDecimal.ROUND_HALF_UP);
        area = calculateArea().setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    @Override
    BigDecimal calculateArea() {
        return length
                .multiply(length)
                .setScale(2, BigDecimal.ROUND_HALF_UP);
    }
}
