package pro.sisit.model;

import java.util.List;
import java.util.Objects;

public class Author implements CSVObject {

    private String name;
    private String birthPlace;

    public Author() {
    }

    public Author(String name, String birthPlace) {
        this.name = name;
        this.birthPlace = birthPlace;
    }

    /**
     * Метод возвращающий строку для записи в CSV файл
     * @return Строка для записи
     */
    @Override
    public String getCSVString() {
        return String.format("%s%s%s", name, DELIMITER, birthPlace);
    }

    /**
     * Метод, заполняющий поля класса
     * @param list Список значений для заполнения
     */
    @Override
    public void fillField(List<String> list) {
        if (list.size() == this.getClass().getDeclaredFields().length) {
            name = list.get(0);
            birthPlace = list.get(1);
        } else {
            throw new RuntimeException("Несоответствие длины списка аргумента количеству полей класса");
        }
    }

    public String getName() {
        return name;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Author author = (Author) o;
        return getName().equals(author.getName()) &&
            getBirthPlace().equals(author.getBirthPlace());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getBirthPlace());
    }


}
