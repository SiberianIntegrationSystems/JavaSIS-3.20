package pro.sisit.transform.impl;

import pro.sisit.model.Book;
import pro.sisit.transform.Transformer;

public class TransformerBookCsvImpl implements Transformer<Book> {

    @Override
    public String fromEntity(Book entity) {
        return String.format("%s;%s;%s;%s;",
            entity.getName(),
            entity.getAuthor(),
            entity.getGenre(),
            entity.getIsbn());
    }

    @Override
    public Book toEntity(String text) {
        String[] pieces = text.split(";");
        return new Book(
            pieces[0],
            pieces[1],
            pieces[2],
            pieces[3]);
    }
}
