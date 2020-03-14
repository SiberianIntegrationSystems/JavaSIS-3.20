package pro.it.sis.javacourse;

public class Weapon {
    //массив перадаваемый в метод hit, где значение с индексом 1 - физический урон,
    // 2 - урон огнем, 3 - урон холодом
    int[] damage={0,0,0};
    // В данном методе реализована логика нанесения физического урона и дополнительного урона огнем или холодом.
    //Метод принимает на вход массив из значений, наносимого урона оружием.
    void hit(Target target) {
        target.getPhysicalDamage(physicalDamage);
        double x=Math.random();
        x=x*2+1;
        if ((int)x==1){
            target.getFireDamage(fireDamage);
        } else {
            target.getIceDamage(iceDamage);
        }
    }
    private int physicalDamage;

    private int fireDamage;

    private int iceDamage;
}
