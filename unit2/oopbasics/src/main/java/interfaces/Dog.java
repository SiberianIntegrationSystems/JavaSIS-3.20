package interfaces;


public class Dog extends Animal implements Pet, Breed {

    public String paint() {
        return "  __      _\n"
                + "o'')}____//\n"
                + " `_/      )\n"
                + " (_(_/-(_/";
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
