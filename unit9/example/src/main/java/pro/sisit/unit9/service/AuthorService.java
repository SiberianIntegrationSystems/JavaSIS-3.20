package pro.sisit.unit9.service;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.sisit.unit9.data.AuthorRepository;
import pro.sisit.unit9.entity.Author;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public void addAuthor(String firstName, String lastName) {
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);
        authorRepository.save(author);
    }

    public void addAuthor(Author author) {
        authorRepository.save(author);
    }

    public Author getById(long id) {
        return authorRepository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException("Несуществует автора под номером " + id));
    }

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public void deleteAll() {
        authorRepository.deleteAll();
    }
}
