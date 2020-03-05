package polymorphism;

import inheritance.Animal;
import inheritance.Cat;
import inheritance.Lion;
import java.math.BigDecimal;
import java.time.LocalDate;
import org.junit.Test;


public class PolyBargainTest {

    private String[] awards = new String[]{"Хвост года 2016", "Самые лучшие уши 2017г."};
    private String[] owners = new String[]{"Петр Горевой", "Иван Драго"};


    @Test
    public void testCatUpcasting() {
        Animal cat = new Cat(awards, "ID-01121", "Пушок", "grey", 3.5, owners,
            5000L, LocalDate.of(2010, 1, 1));
        System.out.println(cat);
        Bargain b = Bargain.builder().animal(cat)
                           .bargainDate(LocalDate.now())
                           .newOwner("Vasya")
                           .previousOwner("Petya").cost(BigDecimal.valueOf(33)).build();
        System.out.println(b.toString());
    }

    @Test
    public void testLionDowncasting() {
        Lion lion = new Lion(awards, "ID-01121", "Бонифаций", "yellow", 355, owners,
            5000L, LocalDate.of(2010, 1, 1));

        System.out.println(lion.hearMyRoar());

        Cat cat = new Cat(awards, "ID-01121", "Бонифация", "yellow", 3.5, owners,
            5000L, LocalDate.of(2010, 1, 1));

        Lion catLion = (Lion) cat;
        catLion.hearMyRoar();

//        Bargain b = Bargain.builder().animal(lion)
//                           .bargainDate(LocalDate.now())
//                           .newOwner("Vasya")
//                           .previousOwner("Petya")
//                           .cost(BigDecimal.valueOf(33)).build();
//        System.out.println(b.toString());


    }

}
