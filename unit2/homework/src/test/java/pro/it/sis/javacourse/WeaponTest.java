package pro.it.sis.javacourse;

import org.junit.Test;

import java.nio.file.Watchable;

import static org.junit.Assert.*;

public class WeaponTest {
    @Test
    public void testFireDamage() {
        Weapon fireSword = new FireSword(new Damage(0,50,0));
        Target efreet = new Efreet();
        efreet.takeDamage(fireSword);
    }

    @Test
    public void testIceDamage() {
        Weapon frozenSword = new FrozenSword(new Damage(0,0,50));
        Target iceGiant = new IceGiant();
        iceGiant.takeDamage(frozenSword);
    }
}