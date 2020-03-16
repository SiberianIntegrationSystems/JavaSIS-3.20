package composition;

import lombok.Getter;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


@Getter
public abstract class Animal {

//    /**
//     * Код родословной
//     */
//    protected String passportCode;
    /**
     * имя
     */
    protected String name;
    /**
     * Окрас
     */
    protected String color;
    /**
     * вес
     */
    protected double weight;
    /**
     * запрашиваемая стоимость
     */
    protected LocalDate birthDay;

    public Animal() {
    }

    public Animal(String name, String color, double weight, LocalDate birthDay) {
        this.name = name;
        this.color = color;
        this.weight = weight;
        this.birthDay = birthDay;
    }

    /**
     * Метод рассчитывающий возраст кота в годах.
     * Пред условие - наличие дня рождения,
     * если его нет - бросаем исключение.
     * Пост условие - возращается возраст в годах.
     */
    public int getAge() {
        if (birthDay != null) {
            return (int) ChronoUnit.YEARS.between(birthDay, LocalDate.now());
        } else {
            throw new RuntimeException("Не указана дата рождения кота!");
        }
    }

    //?????
//    public String paint() {
//        return " ,_     _\n"
//            + " |\\\\_,-~/\n"
//            + " / _  _ |    ,--.\n"
//            + "(  @  @ )   / ,-'\n"
//            + " \\  _T_/-._( (\n"
//            + " /         `. \\\n"
//            + "|         _  \\ |\n"
//            + " \\ \\ ,  /      |\n"
//            + "  || |-_\\__   /\n"
//            + " ((_/`(____,-'";
//    }

    public abstract String paint();

}
