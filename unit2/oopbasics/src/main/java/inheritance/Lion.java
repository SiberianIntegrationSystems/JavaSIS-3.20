package inheritance;

import java.time.LocalDate;
import java.util.Date;
import lombok.Getter;


@Getter
public class Lion extends Cat {

    private String meow = "ARRRRGGGHHH";


    public String hearMyRoar() {
        return meow + System.lineSeparator() + paint();
    }

    public Lion() {

    }

    public Lion(String[] awards, String passportCode, String name, String color, double weight, String[] owners,
        Long cost, LocalDate birthDay) {
        super(awards, passportCode, name, color, weight, owners, cost, birthDay);
    }

    @Override
    public String paint() {
        return "                       \\\\\\\\\\\\\\////\n"
            + "                             \\\\//\\/\\\\\\\\\\\\\\///\n"
            + "                           \\\\\\`      \\\\\\\\\\\\///\n"
            + "                          \\\\       ||\\      \\\n"
            + "                          \\  \\\\   //     _\\  `\\\n"
            + "                         /  /. \\  \\\\    /O.    `\\,\n"
            + "                        //  |__\\\\ //\\         . __\\\n"
            + "                      /`           //\\\\      , .\\ /\n"
            + "                     \\\\\\\\          //\\        ___|\n"
            + "                    ////\\\\            \\\\     `   \\\n"
            + "                  //////////\\\\\\\\       //__       |\n"
            + "                 |`  \\\\\\//////\\\\        \\_ \\______|\n"
            + "                 |     \\\\\\\\//\\\\/////\\\\\\   \\\n"
            + "                ./      \\\\\\\\////////\\\\     |\\\n"
            + "                |        \\\\\\\\////\\\\//\\\\\\\\\\\\\\\\\n"
            + "                |          \\\\\\///      \\\\\\\\\\\\\n"
            + "                |          \\\\\\//         \\//\n"
            + "                |            \\/        \\ |\n"
            + "                |             `         \\|\n"
            + "                | |                      \\                       /\n"
            + "                | |           \\           \\                     //\n"
            + "                | |                        \\                   ////\n"
            + "                | |             .          `|                 /////\n"
            + "                | |                         `\\                \\\\////\n"
            + "                 \\`|                          `|              \\\\||/\n"
            + "                  | |             \\            `|  ,--.         \\ \\,\n"
            + "                  |  \\                          |./    `\\        | |\n"
            + "                   |  |                                 |        | |\n"
            + "                   |___|            .                   |        | |\n"
            + "                   /   |                                |        | |\n"
            + "                   |    |                               ;        | |\n"
            + "                   |                                    |        | |\n"
            + "                 __|                                   /`       /` ;\n"
            + "                /   \\                          ,      ; \\     ,` ,/\n"
            + "                \\____\\              \\       \\,/__________|__.' ,`\n"
            + "                  nmf \\______________\\_______________________.'\n ";
    }

}
