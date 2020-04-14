package pro.sisit.unit9.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.sisit.unit9.data.BookRepository;
import pro.sisit.unit9.entity.Author;
import pro.sisit.unit9.entity.Book;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public void addBook(String title, String description, int year) {
        Book book = new Book();
        book.setTitle(title);
        book.setDescription(description);
        book.setYear(year);
        bookRepository.save(book);
    }

    public void addBook(Book book) {
        bookRepository.save(book);
    }

    public Book getById(long id) {
        return bookRepository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException("Не существует книги под номером " + id));
    }

    public List<Book> getAllBook() {
        return bookRepository.findAll();
    }

    public List<Book> getByYear(int year) {
        return bookRepository.findByYear(year);
    }

    public List<Book> getByAuthorLastName(String lastName) {
        return bookRepository.findByAuthor(lastName);
    }

    public void deleteAll() {
        bookRepository.deleteAll();
    }
}
