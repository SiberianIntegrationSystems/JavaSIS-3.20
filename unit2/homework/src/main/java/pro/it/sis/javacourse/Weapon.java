package pro.it.sis.javacourse;


public class Weapon{
   public String name;

    private Damage damage;

    public Weapon (String name, int p, int f,int i){
        this.name = name;
        this.damage = new Damage(p,f,i);

    }

    void hit(Target target) {
        target.setPhysicalDamage(this.damage.getWeaponPhysicalDamage());
        target.setFireDamage(this.damage.getWeaponFireDamage());
        target.setIceDamage(this.damage.getWeaponIceDamage());


    }
}
