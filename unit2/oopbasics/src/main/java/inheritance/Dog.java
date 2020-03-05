package inheritance;

import java.time.LocalDate;
import lombok.Getter;


@Getter
public class Dog extends Animal {

    public Dog(String[] awards, String passportCode, String name, String color, double weight, String[] owners,
        Long cost, LocalDate birthDay) {
        super(awards, passportCode, name, color, weight, owners, cost, birthDay);
    }

    @Override
    public String paint() {
        return "  __      _\n"
            + "o'')}____//\n"
            + " `_/      )\n"
            + " (_(_/-(_/";
    }

}
