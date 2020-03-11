package pro.it.sis.javacourse;

public class Damage {
    private int physicalDamage;

    private int fireDamage;

    private int iceDamage;

    Damage (int p, int f, int i) {

        physicalDamage = p;

        fireDamage = f;

        iceDamage = i;
    }

    public int getWeaponPhysicalDamage() {

        return physicalDamage;

    }

    public int getWeaponFireDamage() {

        return fireDamage;

    }

    public int getWeaponIceDamage() {

        return iceDamage;

    }
}
