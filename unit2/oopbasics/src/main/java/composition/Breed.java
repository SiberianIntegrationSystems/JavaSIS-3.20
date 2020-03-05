package composition;

public class Breed implements Breedable {

    /**
     * список владельцев
     */
    protected String[] awards;
    /**
     * запрашиваемая стоимость
     */
    protected Long cost;

    /**
     * Код родословной
     */
    protected String passportCode;


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
