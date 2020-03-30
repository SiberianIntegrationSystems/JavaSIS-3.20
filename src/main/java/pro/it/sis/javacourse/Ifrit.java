package pro.it.sis.javacourse;

public class Ifrit extends Target {

    @Override
    public void takeFireDamage(int  firetarget) {
        System.out.println("\nЭфрит-игнорирует огненный урон");
    }
}