package simple;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Сделка по продаже кота
 */
public class Bargain {

    public Bargain(Cat cat, BigDecimal cost, String previousOwner, String newOwner, LocalDate bargainDate) {
        this.cat = cat;
        this.cost = cost;
        this.previousOwner = previousOwner;
        this.newOwner = newOwner;
        this.bargainDate = bargainDate;
    }

    private Cat cat;
    private BigDecimal cost;
    private String previousOwner;
    private String newOwner;
    private LocalDate bargainDate;

    @Override
    public String toString() {
        return "Продажа кота {" +
            "имя=" + cat.getName() +
            ", цена=" + cost +
            ", от владельца ='" + previousOwner + '\'' +
            ", новому владельцу='" + newOwner + '\'' +
            ", дата сделки=" + bargainDate +
            '}';
    }
}
