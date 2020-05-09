package pro.it.sis.javacourse;

import org.junit.Test;

import java.nio.file.Watchable;

import static org.junit.Assert.*;

public class WeaponTest {

    @Test
    public  void  Weapon () {
        Weapon sword1 = new Weapon("Пылающий асфальт",50,50,0);
        Weapon sword2 = new Weapon("Меч ночи в якутске",50,0,50);


        IceGiant i = new IceGiant();
        Ifrit f = new Ifrit();


        sword1.hit(i);
        System.out.println("Полученный урон от меча Пылающий асвальт: "+" " + "Физ.урон-"+ i.getPhysicalDamage() + " " +"Урон огнем-"+i.getFireDamage()+" "+
                "Ледяной урон-" + i.getIceDamage());



        sword2.hit(f);
        System.out.println("Полученый урон от меча Ночь в Якутске: "+" " + "Физ.урон-"+ f.getPhysicalDamage() + " " +"Урон огнем-"+f.getFireDamage()+" "+
                "Ледяной урон-" + f.getIceDamage());
    }

}