package simple;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.Test;

public class CatTest {
    private String[] awards = new String[] {"Хвост года 2016", "Самые лучшие уши 2017г."};
    private String[] owners = new String[] {"Петр Горевой", "Иван Драго"};

    @Test
    public void testConstructor() {
        Cat cat = new Cat(awards, "ID-01121", "Пушок", "grey",
            3.5, owners, 5000L, LocalDate.of(2010, 1, 1));
        System.out.println(cat.speak("привет!!!"));
    }

    @Test
    public void testPropertyRead() {
        Cat cat = new Cat(awards, "ID-01121", "Пушок", "grey",
            3.5, owners, 5000L, LocalDate.of(2010, 1, 1));
        System.out.println(cat.name);
    }

    @Test
    public void testMessagePaint() {
        Cat cat = new Cat(awards, "ID-01121", "Пушок", "grey", 3.5, owners,
            5000L, LocalDate.of(2010, 1, 1));
        System.out.println(cat.getAge());
        System.out.println(cat.speak("Привет!"));
    }

    @Test
    public void testEncapsulationBreak() {
        Cat cat = new Cat(awards, "ID-01121", "Пушок",
            "grey", 3.5, owners,
            5000L, LocalDate.of(2010, 1, 1));
        assertEquals("Пушок", cat.name);

        cat.name = "Том";

        assertEquals("Пушок", cat.name);

    }

    @Test
    public void testEncapsulationBreak2() {
        Cat cat = new Cat(awards, "ID-01121", "Пушок",
            "grey", 3.5, owners,
            5000L, LocalDate.of(2010, 1, 1));

        assertArrayEquals(owners, cat.getOwners());

        // последним хозяином будет сам Пушок
        cat.getOwners()[cat.getOwners().length - 1] = "Пушок";
        System.out.println("Теперь Пушок сам себе хозяин!");
        System.out.println(Arrays.toString(cat.getOwners()));


        assertEquals("Иван Драго", cat.getOwners()[1]);

    }

    @Test
    public void testImmutableList() {
        Cat cat = new Cat(awards, "ID-01121", "Пушок",
            "grey", 3.5, owners,
            5000L, LocalDate.of(2010, 1, 1));

        List<String> ownersList = Arrays.asList(cat.getOwners());
        List<String> immutableList = Collections.unmodifiableList(ownersList);

        // последним хозяином будет сам Пушок

        String ivanDrago = immutableList.get(1);
        ivanDrago = "Пушок";
        System.out.println(immutableList);
        assertEquals("Иван Драго", immutableList.get(1));

        immutableList.set(1, "Пушок");
        System.out.println("Теперь Пушок сам себе хозяин!");
    }
}
