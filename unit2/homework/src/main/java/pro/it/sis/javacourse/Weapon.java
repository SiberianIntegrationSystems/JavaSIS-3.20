package pro.it.sis.javacourse;

public abstract class Weapon {
    protected Damage damage;
    protected Weapon(Damage damage) {
        this.damage = damage;
    }

    public Damage getDamage() {
        return damage;
    }

}