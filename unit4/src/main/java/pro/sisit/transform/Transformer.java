package pro.sisit.transform;

public interface Transformer<T> {
    String fromEntity(T entity);
    T toEntity(final String text);
}
