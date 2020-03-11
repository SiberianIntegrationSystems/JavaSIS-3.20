package pro.it.sis.javacourse;

public class Weapon {

    private String name;

    private Damage damageDealt;

    public Weapon(String name, Damage damageDealt) {
        this.name = name;
        this.damageDealt = damageDealt;
    }

    public Weapon(String name, int physicalDamage, int fireDamage, int iceDamage) {
        this.name = name;
        this.damageDealt = new Damage(physicalDamage, fireDamage, iceDamage);
    }

    void hit(Target target) {
        target.acceptHit(damageDealt);
    }

    public void setPhysicalDamage(int physicalDamage) {
        damageDealt.setPhysicalDamage(physicalDamage);
    }

    public void setFireDamage(int fireDamage) {
        damageDealt.setFireDamage(fireDamage);
    }

    public void setIceDamage(int iceDamage) {
        damageDealt.setIceDamage(iceDamage);
    }

    public String getName() {
        return name;
    }

    public int getPhysicalDamage() {
        return damageDealt.getPhysicalDamage();
    }

    public int getFireDamage() {
        return damageDealt.getFireDamage();
    }

    public int getIceDamage() {
        return damageDealt.getIceDamage();
    }
}
