package pro.sisit.unit9.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.sisit.unit9.data.AuthorOfBookRepository;
import pro.sisit.unit9.entity.Author;
import pro.sisit.unit9.entity.AuthorOfBook;
import pro.sisit.unit9.entity.Book;

import java.util.List;

@Service
public class AuthorOfBookService {

    @Autowired
    private AuthorOfBookRepository authorOfBookRepository;

    public void addAuthorOfBook(Author author, Book book) {
        AuthorOfBook authorOfBook = new AuthorOfBook();
        authorOfBook.setAuthor(author);
        authorOfBook.setBook(book);
        authorOfBookRepository.save(authorOfBook);
    }

    public void addAuthorOfBook(AuthorOfBook authorOfBook) {
        authorOfBookRepository.save(authorOfBook);
    }

    public AuthorOfBook getById(long id) {
        return authorOfBookRepository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException(
                                "Не существует соответствия автора и книги под номером " + id));
    }

    public List<AuthorOfBook> getAllAuthorsOfBook() {
        return authorOfBookRepository.findAll();
    }

    public void deleteAll() {
        authorOfBookRepository.deleteAll();
    }
}
