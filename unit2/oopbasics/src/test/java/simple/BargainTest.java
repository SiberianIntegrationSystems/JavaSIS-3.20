package simple;

import java.math.BigDecimal;
import java.time.LocalDate;
import org.junit.Test;


public class BargainTest {

    private String[] owners = new String[] {"Петр Горевой", "Иван Драго"};
    private String[] awards = new String[] {"Хвост года 2016", "Самые лучшие уши 2017г."};
    @Test
    public void testBargain() {
//        Cat cat = Cat.builder().name("Пушок").build();
        Cat cat = new Cat(awards, "ID-01121", "Пушок", "grey", 3.5, owners,
            5000L, LocalDate.of(2010, 1, 1));
        Bargain bargain = new Bargain(cat, BigDecimal.valueOf(2000),
            "Петр", "Иона", LocalDate.now());
        System.out.println(bargain.toString());


    }
}
