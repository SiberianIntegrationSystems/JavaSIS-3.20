package pro.sisit.transform.impl;

import pro.sisit.model.Author;
import pro.sisit.transform.Transformer;

public class TransformerAuthorCsvImpl implements Transformer<Author> {

    @Override
    public String fromEntity(Author entity) {
        return String.format("%s;", entity.getName());
    }

    @Override
    public Author toEntity(String text) {
        String[] pieces = text.split(";");
        return new Author(pieces[0], pieces[1]);
    }
}
