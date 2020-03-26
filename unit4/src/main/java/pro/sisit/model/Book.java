package pro.sisit.model;

import java.util.List;
import java.util.Objects;

public class Book implements CSVObject {

    private String name;
    private String author;
    private String genre;
    private String isbn;

    public Book() {
    }

    public Book(String name, String author, String genre, String isbn) {
        this.name = name;
        this.author = author;
        this.genre = genre;
        this.isbn = isbn;
    }

    /**
     * Метод возвращающий строку для записи в CSV файл
     * @return Строка для записи
     */
    @Override
    public String getCSVString() {
        return String.format("%s%s%s%s%s%s%s", name, DELIMITER, author, DELIMITER, genre, DELIMITER, isbn);
    }

    /**
     * Метод, заполняющий поля класса
     * @param list Список значений для заполнения
     */
    @Override
    public void fillField(List<String> list) {
        if(list.size() == 4) {
            name = list.get(0);
            author = list.get(1);
            genre = list.get(2);
            isbn = list.get(3);
        } else {
            throw new RuntimeException("Несоответствие длины списка аргумента количеству полей класса");
        }
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public String getIsbn() {
        return isbn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Book book = (Book) o;
        return getName().equals(book.getName()) &&
            getAuthor().equals(book.getAuthor()) &&
            getGenre().equals(book.getGenre()) &&
            getIsbn().equals(book.getIsbn());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAuthor(), getGenre(), getIsbn());
    }
}
