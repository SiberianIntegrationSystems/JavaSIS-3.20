package pro.it.sis.javacourse;

public class Weapon {
    private String name;

    private Damage damage;

    public Weapon (String name, int physical, int fire,int ice){
        this.name = name;
        this.damage = new Damage(physical,fire,ice);

    }


    void hit(Target target) {


        target.takePhysicalDamage(this.damage.getWeaponPhysicalDamage());
        target.takeFireDamage(this.damage.getWeaponFireDamage());
        target.takeIceDamage(this.damage.getWeaponIceDamage());

    }
}

