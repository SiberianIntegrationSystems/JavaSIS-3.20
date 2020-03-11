package pro.it.sis.javacourse;

public class ColdWeapon extends Weapon {

    public ColdWeapon(String name, Damage damageDealt) {
        super(name, damageDealt);
    }

    public ColdWeapon(String name, int physicalDamage, int fireDamage, int iceDamage) {
        super(name, physicalDamage, fireDamage, iceDamage);
    }
}
