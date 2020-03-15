package pro.it.sis.javacourse;

public class Damage {
    private int physicalDamage; // физический урон
    private int fireDamage; // урон огнем
    private int iceDamage;  // урон холодом
    public Damage(int physicalDamage, int fireDamage, int iceDamage){
        this.physicalDamage = physicalDamage;
        this.fireDamage = fireDamage;
        this.iceDamage = iceDamage;
    }
    public int getFireDamage() {
        return fireDamage;
    }
    public int getPhysicalDamage() {
        return physicalDamage;
    }
    public int getIceDamage() {
        return iceDamage;
    }
}