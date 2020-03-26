package pro.sisit.model;

import java.util.List;
import java.util.Objects;

public class Library implements CSVObject {

    private String name;
    private String address;
    private int countOfBook;

    public Library() {
    }

    public Library(String name, String address, int countOfBook) {
        this.name = name;
        this.address = address;
        this.countOfBook = countOfBook;
    }

    @Override
    public String getCSVString() {
        return String.format("%s%s%s%s%d", name, DELIMITER, address, DELIMITER, countOfBook);
    }

    @Override
    public void fillField(List<String> list) {
        if(list.size() == 3) {
            name = list.get(0);
            address = list.get(1);
            try {
                countOfBook = Integer.parseInt(list.get(2));
            } catch (NumberFormatException e) {
                throw new RuntimeException("Типы аргументов не совпадают с типами полей класса");
            }
        } else {
            throw new RuntimeException("Несоответствие длины списка аргумента количеству полей класса");
        }
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getCountOfBook() {
        return countOfBook;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Library library = (Library) o;
        return getName().equals(library.getName()) &&
                getAddress().equals(library.getAddress()) &&
                countOfBook==library.getCountOfBook();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAddress(), getCountOfBook());
    }
}
