package interfaces;


public class Cat extends Animal implements Pet, Breed {

    public String paint() {
        return " ,_     _\n"
                + " |\\\\_,-~/\n"
                + " / _  _ |    ,--.\n"
                + "(  @  @ )   / ,-'\n"
                + " \\  _T_/-._( (\n"
                + " /         `. \\\n"
                + "|         _  \\ |\n"
                + " \\ \\ ,  /      |\n"
                + "  || |-_\\__   /\n"
                + " ((_/`(____,-'";
    }



    /**
    * список владельцев
    */
    protected String[] awards;
    protected String[] owners;
    /**
     * запрашиваемая стоимость
     */
    protected Long cost;

    /**
    * Код родословной
    */
    protected String passportCode;

    @Override
    public String[] getOwners() {
        return new String[0];
    }

    @Override
    public String[] getAwards() {
        return awards;
    }

    public Long getCost() {
        return cost;
    }

    @Override
    public String getPassportCode() {
        return passportCode;
    }
}
