package pro.sisit.exception;

public class IllegalEntityType extends Exception {

    private String entityTypeName;

    public IllegalEntityType(String entityTypeName) {
        this.entityTypeName = entityTypeName;
    }

    @Override
    public String toString() {
        return String.format(
            "IllegalEntityType{entityTypeName='%s'}",
            entityTypeName);
    }
}
