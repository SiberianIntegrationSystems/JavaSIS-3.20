package pro.it.sis.javacourse;

public abstract class Target {
    private double health;
    private double iceResist;
    private double fireResist;
    protected Target(double health, double iceResist, double fireResist) {
        this.health = health;
        this.iceResist = iceResist;
        this.fireResist = fireResist;
    }

    public double getHealth() {
        return health;
    }

    public double getIceResist() {
        return iceResist;
    }

    public double getFireResist() {
        return fireResist;
    }

    public void takeDamage(Weapon weapon){
        System.out.println("Здоровье до удара: " + this.health);
        if (fireResist > 0){
            // из здоровья вычитаем физ урон, урон от льда и в два раза меньше урон от огня
            health = health - weapon.getDamage().getPhysicalDamage() - weapon.getDamage().getIceDamage() - weapon.getDamage().getFireDamage()/2.0;
        }
        if (iceResist > 0) {
            // из здоровья вычитаем физ урон, в два раза меньше урон от льда и урон от огня
            health = health - weapon.getDamage().getPhysicalDamage() - weapon.getDamage().getIceDamage() / 2.0 - weapon.getDamage().getFireDamage();
        }

        System.out.println("Здоровье после удара: " + this.health);
    }
}
