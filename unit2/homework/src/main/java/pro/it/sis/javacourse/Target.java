package pro.it.sis.javacourse;

public class Target {

    private int physicalDamage;

    private int fireDamage;

    private int iceDamage;


    public void setPhysicalDamage(int p) {
        physicalDamage = p;
    }

    public void setFireDamage(int f) {
        fireDamage = f;
    }

    public void setIceDamage(int i) {
        iceDamage = i;
    }

    public int getPhysicalDamage() {
        return physicalDamage;
    }

    public int getFireDamage() {
        return fireDamage;
    }

    public int getIceDamage() {
        return iceDamage;
    }
}