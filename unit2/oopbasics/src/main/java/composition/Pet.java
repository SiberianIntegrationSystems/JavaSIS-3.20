package composition;

public class Pet implements Petable {

    /**
     * список владельцев
     */
    protected String[] owners;

    @Override
    public String[] getOwners() {
        return owners;
    }
}
