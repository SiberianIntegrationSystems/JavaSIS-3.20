package pro.it.sis.javacourse;

public class Target {

    private String name;

    private int physicalHealthPoints;
    private int fireHealthPoints;
    private int iceHealthPoints;

    private boolean[] immunity = new boolean[3];

    private boolean alive;

    {
        physicalHealthPoints = 100;
        fireHealthPoints = 100;
        iceHealthPoints = 100;
        alive = true;
    }

    public Target(String name, boolean physicalImmunity, boolean fireImmunity, boolean iceImmunity) {
        this.name = name;
        immunity[0] = physicalImmunity;
        immunity[1] = fireImmunity;
        immunity[2] = iceImmunity;
    }

    public void acceptHit(Damage damage) {
        // Если цель уже мертва, то не надо её больше трогать
        if (!isAlive()) return;
        // Если урон больше оставшихся очков жизни, то очки жизни обнуляются
        // Изменение очков здоровья происходит только при отсутствия иммунитета
        if (!immunity[0]) physicalHealthPoints = Math.max(physicalHealthPoints - damage.getPhysicalDamage(), 0);
        if (!immunity[1]) fireHealthPoints = Math.max(fireHealthPoints - damage.getFireDamage(), 0);
        if (!immunity[2]) iceHealthPoints = Math.max(iceHealthPoints - damage.getIceDamage(), 0);
        // Если один из показателей очков здоровья обнулён, то цель погибает
        if (physicalHealthPoints==0 || fireHealthPoints==0 || iceHealthPoints==0)
            alive = false;
    }

    public String getName() {
        return name;
    }

    public int getPhysicalHealthPoints() {
        return physicalHealthPoints;
    }

    public int getFireHealthPoints() {
        return fireHealthPoints;
    }

    public int getIceHealthPoints() {
        return iceHealthPoints;
    }

    public boolean isAlive() {
        return alive;
    }
}
