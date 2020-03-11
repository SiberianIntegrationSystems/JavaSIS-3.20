package pro.it.sis.javacourse;

public class Damage {

    private int physicalDamage;
    private int fireDamage;
    private int iceDamage;

    public Damage(int physicalDamage, int fireDamage, int iceDamage) {

        // Урон не может быть отрицательным или больше 100 (смертельный урон)

        if (physicalDamage>100) this.physicalDamage = 100;
        else if (physicalDamage>0) this.physicalDamage = physicalDamage;

        if (fireDamage>100) this.fireDamage = 100;
        else if (fireDamage>0) this.fireDamage = fireDamage;

        if (iceDamage>100) this.iceDamage = 100;
        else if (iceDamage>0) this.iceDamage = iceDamage;
    }

    public void setPhysicalDamage(int physicalDamage) {
        // Урон не может быть отрицательным или больше 100 (смертельный урон)
        if (physicalDamage>100) this.physicalDamage = 100;
        else if (physicalDamage>0) this.physicalDamage = physicalDamage;
    }

    public void setFireDamage(int fireDamage) {
        // Урон не может быть отрицательным или больше 100 (смертельный урон)
        if (fireDamage>100) this.fireDamage = 100;
        else if (fireDamage>0) this.fireDamage = fireDamage;
    }

    public void setIceDamage(int iceDamage) {
        // Урон не может быть отрицательным или больше 100 (смертельный урон)
        if (iceDamage>100) this.iceDamage = 100;
        else if (iceDamage>0) this.iceDamage = iceDamage;
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
