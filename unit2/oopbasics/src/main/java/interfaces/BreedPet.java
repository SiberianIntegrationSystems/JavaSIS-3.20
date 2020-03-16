package interfaces;

public class BreedPet implements Breed, Pet {

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
