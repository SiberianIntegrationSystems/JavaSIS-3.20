package simple;

import lombok.Getter;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Класс кота на продажу
 */
@Getter
public class Cat {

    String[] awards;
    /**
     * Код родословной
     */
    String passportCode;

    /**
     * имя
     */
    String name;

    /**
     * Окрас
     */
    String color;

    /**
     * вес
     */
    double weight;
    /**
     * запрашиваемая стоимость
     */
    Long cost;

    LocalDate birthDay;
    /**
     * список владельцев
     */
    private String[] owners;

    public Cat(String[] awards, String passportCode, String name,
               String color, double weight, String[] owners,
               Long cost, LocalDate birthDay) {
        this.awards = awards;
        this.passportCode = passportCode;
        this.name = name;
        this.color = color;
        this.weight = weight;
        this.owners = owners;
        this.cost = cost;
        this.birthDay = birthDay;
    }

    /**
     * Метод рассчитывающий возраст кота в годах.
     *
     * @return Возраст в годах.
     * @throws RuntimeException Если дата рождения не указана.
     */
    public int getAge() {
        if (birthDay != null) {
            return (int) ChronoUnit.YEARS.between(birthDay, LocalDate.now());
        } else {
            throw new RuntimeException("Не указана дата рождения кота!");
        }
    }

    String speak(String text) {
        String name = this.name != null ? this.name : "Безымянный";
        return paint() + System.lineSeparator()
                + name + " speaks: Meooowwwww, " + text;
    }

    public String paint() {
        return " ,_     _\n"
                + " |\\\\_,-~/\n"
                + " / _  _ |    ,--.\n"
                + "(  @  @ )   / ,-'\n"
                + " \\  _T_/-._( (\n"
                + " /         `. \\\n"
                + "|         _  \\ |\n"
                + " \\ \\ ,  /      |\n"
                + "  || |-_\\__   /\n"
                + " ((_/`(____,-'";
    }

}
