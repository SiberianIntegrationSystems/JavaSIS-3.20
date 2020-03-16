package inheritance;

import java.time.LocalDate;
import org.junit.Test;


public class DogTest {


    private String[] awards = new String[]{"Хвост года 2016", "Самые лучшие уши 2017г."};
    private String[] owners = new String[]{"Петр Горевой", "Иван Драго"};

    @Test
    public void paintDog() {
        Dog dog = new Dog(awards, "ID-01121", "Плуто", "black",
            9.5, owners, 6000L, LocalDate.of(2010, 1, 1));
        System.out.println(dog.speak("привет!!!"));
    }
}
