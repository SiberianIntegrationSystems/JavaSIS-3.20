package interfaces;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface Guest {
    LocalDate getStartDate();
    LocalDate getFinishDate();
    BigDecimal getCost();
    String getServiceLevel();

}
