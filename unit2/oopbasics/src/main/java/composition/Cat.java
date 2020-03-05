package composition;

import java.time.LocalDate;

/**
 * Кошка породистая на продажу + домашний питомец
 */
public class Cat extends Animal implements Petable, Breedable {

    private Breed breed;

    public Breed getBreed() {
        return breed;
    }

    public Pet getPet() {
        return pet;
    }

    private Pet pet;

    public Cat(String name, String color, double weight, LocalDate birthDay, Breed breed, Pet pet)
    {
        super(name, color, weight, birthDay);
        this.breed = breed;
        this.pet = pet;
    }

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

    @Override
    public String[] getOwners() {
        return pet.getOwners();
    }

    @Override
    public String[] getAwards() {
        return breed.getAwards();
    }

    @Override
    public String getPassportCode() {
        return breed.getPassportCode();
    }
}
