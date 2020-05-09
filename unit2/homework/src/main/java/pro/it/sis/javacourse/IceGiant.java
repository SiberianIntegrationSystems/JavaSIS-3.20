package pro.it.sis.javacourse;

public class IceGiant extends Target {


    @Override
    public void setIceDamage(int i) {
        System.out.println("Ледяной великан-игнорирует ледяной урон");
    }
}
