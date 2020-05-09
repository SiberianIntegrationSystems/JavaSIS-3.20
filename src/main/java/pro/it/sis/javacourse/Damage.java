package pro.it.sis.javacourse;

public class Damage {
    private int physicalDamage;

    private int fireDamage;

    private int iceDamage;

    Damage (int physicalDamage, int fireDamage, int iceDamage) {

        this.physicalDamage = physicalDamage;

        this.fireDamage = fireDamage;

        this.iceDamage = iceDamage;
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