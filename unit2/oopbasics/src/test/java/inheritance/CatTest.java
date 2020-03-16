package inheritance;

import java.time.LocalDate;
import org.junit.Test;

public class CatTest {

    private String[] awards = new String[]{"Хвост года 2016", "Самые лучшие уши 2017г."};
    private String[] owners = new String[]{"Петр Горевой", "Иван Драго"};

    @Test
    public void testCleanFast() {
        Cat cat = new Cat(awards, "ID-01121", "Пушок", "grey",
            3.5, owners, 5000L, LocalDate.of(2010, 1, 1));
        cat.clean(1);
    }

    @Test
    public void testCleanSlow() {
        Cat cat = new Cat(awards, "ID-01121", "Пушок", "grey",
            3.5, owners, 5000L, LocalDate.of(2010, 1, 1));
        cat.clean(3);
    }


}
