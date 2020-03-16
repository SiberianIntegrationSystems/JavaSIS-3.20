package polymorphism;

import inheritance.Animal;
import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.Builder;

/**
 * Сделка по продаже животного
 */
public class Bargain {

    @Builder
    public Bargain(Animal animal, BigDecimal cost, String previousOwner, String newOwner, LocalDate bargainDate) {
        this.animal = animal;
        this.cost = cost;
        this.previousOwner = previousOwner;
        this.newOwner = newOwner;
        this.bargainDate = bargainDate;
    }

    private Animal animal;
    private BigDecimal cost;
    private String previousOwner;
    private String newOwner;
    private LocalDate bargainDate;

    public Bargain() {

    }

    @Override
    public String toString() {
        return "Продажа животного {" +
            "имя=" + animal.getName() +
            ", цена=" + cost +
            ", от владельца ='" + previousOwner + '\'' +
            ", новому владельцу='" + newOwner + '\'' +
            ", дата сделки=" + bargainDate +
            ", рисунок животного=\n" + animal.paint() +
            '}';
    }
}
