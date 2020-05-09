package pro.it.sis.javacourse;

public class IceGiant extends Target {


    @Override
    public void takeIceDamage(int icetarget) {
        System.out.println("\nЛедяной великан-игнорирует ледяной урон");
    }
}