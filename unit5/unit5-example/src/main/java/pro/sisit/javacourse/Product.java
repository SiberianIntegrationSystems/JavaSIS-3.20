package pro.sisit.javacourse;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Продукт
 */
@Data
public class Product {

    private final long id;
    private final String name;
    private final ProductType type;
    private final BigDecimal price;
    private final Producer producer;

    @Override
    public String toString() {
        return String.format("Продукт('%s' \\ '%s'): '%s', цена: '%s';",
                getProducer().getName(), getType().getLocalName(), getName(), getPrice());
    }

}
