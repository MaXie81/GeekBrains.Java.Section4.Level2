package figures;

import java.math.BigDecimal;

public class Circle extends Figure {
    private BigDecimal raius;

    public Circle(BigDecimal raius) {
        this.raius = raius.setScale(2, BigDecimal.ROUND_HALF_UP);
        area = calculateArea().setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    @Override
    BigDecimal calculateArea() {
        return raius
                .multiply(raius)
                .multiply(new BigDecimal(Math.PI))
                .setScale(2, BigDecimal.ROUND_HALF_UP);
    }
}
