package pro.it.sis.javacourse;

public class Target {
    // Метод, в котором происходит увеличение общего нанесенного физического урона
    public void getPhysicalDamage(int physical) {
        physicalDamage+=physical;
    }
    // Метод, в котором происходит увеличение общего нанесенного урона огнем
    public void getFireDamage(int fire) {
        fireDamage+=fire;
    }
    // Метод, в котором происходит увеличение общего нанесенного урона холодом
    public void getIceDamage(int ice) {
        iceDamage+=ice;
        }
    //Вывод нанесенного физического урона
    public int returnPhysicalDamage() {
        return physicalDamage;
    }
    //Вывод нанесенного урона огнем
    public int returnFireDamage() {
        return fireDamage;
    }
    //Вывод нанесенного урона холодом
    public int returnIceDamage() {
        return iceDamage;
    }
    private int physicalDamage;

    private int fireDamage;

    private int iceDamage;
}
