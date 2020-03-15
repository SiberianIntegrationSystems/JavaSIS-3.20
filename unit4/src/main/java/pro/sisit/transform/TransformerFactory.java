package pro.sisit.transform;

import pro.sisit.exception.IllegalEntityType;
import pro.sisit.model.Author;
import pro.sisit.model.Book;
import pro.sisit.transform.impl.TransformerAuthorCsvImpl;
import pro.sisit.transform.impl.TransformerBookCsvImpl;

public class TransformerFactory {

    public static Transformer create(Class type) throws IllegalEntityType {
        if (Author.class.equals(type)) {
            return new TransformerAuthorCsvImpl();
        } else if (Book.class.equals(type)) {
            return new TransformerBookCsvImpl();
        } else {
            throw new IllegalEntityType(type.getTypeName());
        }
    }
}
