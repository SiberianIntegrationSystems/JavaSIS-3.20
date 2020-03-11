package pro.it.sis.javacourse;

import org.junit.Test;

import java.nio.file.Watchable;

import static org.junit.Assert.*;

public class WeaponTest {

    @Test
    public void testPhysicalDamage() {

        Target giant = new IceGiant();
        Target efreet = new Efreet();
        Weapon yakutskNightSword = new YakutskNightSword();
        Weapon flamingAsphaltSword = new FlamingAsphaltSword();

        yakutskNightSword.hit(giant);
        assertEquals(100 - yakutskNightSword.getPhysicalDamage(), giant.getPhysicalHealthPoints());

        flamingAsphaltSword.hit(efreet);
        assertEquals(100 - flamingAsphaltSword.getPhysicalDamage(), efreet.getPhysicalHealthPoints());
    }

    @Test
    public void testFireDamage() {

        Target giant = new IceGiant();
        Target efreet = new Efreet();
        Weapon yakutskNightSword = new YakutskNightSword();
        Weapon flamingAsphaltSword = new FlamingAsphaltSword();

        yakutskNightSword.hit(giant);
        assertEquals(100 - yakutskNightSword.getFireDamage(), giant.getFireHealthPoints());

        flamingAsphaltSword.hit(giant);
        assertEquals(100 - flamingAsphaltSword.getFireDamage(), giant.getFireHealthPoints());
        flamingAsphaltSword.hit(giant);
        assertFalse(giant.isAlive());

        flamingAsphaltSword.hit(efreet);
        assertEquals(100, efreet.getFireHealthPoints());
    }

    @Test
    public void testIceDamage() {

        Target giant = new IceGiant();
        Target efreet = new Efreet();
        Weapon yakutskNightSword = new YakutskNightSword();
        Weapon flamingAsphaltSword = new FlamingAsphaltSword();

        flamingAsphaltSword.hit(efreet);
        assertEquals(100 - flamingAsphaltSword.getIceDamage(), efreet.getIceHealthPoints());

        yakutskNightSword.hit(efreet);
        assertEquals(100 - yakutskNightSword.getIceDamage(), efreet.getIceHealthPoints());
        yakutskNightSword.hit(efreet);
        assertFalse(efreet.isAlive());

        yakutskNightSword.hit(giant);
        assertEquals(100, giant.getIceHealthPoints());
    }
}