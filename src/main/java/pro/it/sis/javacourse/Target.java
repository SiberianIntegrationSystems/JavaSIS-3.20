package pro.it.sis.javacourse;

public class Target {

    private int physicalDamage;

    private int fireDamage;

    private int iceDamage;



    public void takePhysicalDamage(int physicalDamage) {
        this.physicalDamage += physicalDamage;
    }


    public void takeFireDamage(int fireDamage) {
        this.fireDamage += fireDamage;
    }

    public void takeIceDamage(int iceDamage) {
        this.iceDamage += iceDamage;
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