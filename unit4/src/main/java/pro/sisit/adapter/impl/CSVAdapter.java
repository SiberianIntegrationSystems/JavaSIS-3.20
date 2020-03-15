package pro.sisit.adapter.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import pro.sisit.adapter.IOAdapter;
import pro.sisit.exception.IllegalEntityType;
import pro.sisit.transform.Transformer;
import pro.sisit.transform.TransformerFactory;

public class CSVAdapter<T> implements IOAdapter<T> {

    private Class<T> entityType;
    private BufferedReader reader;
    private BufferedWriter writer;
    private Transformer<T> transformer;
    private List<String> lines;

    public CSVAdapter(Class<T> entityType,
        BufferedReader reader, BufferedWriter writer) {

        try {
            this.entityType = entityType;
            this.reader = reader;
            this.writer = writer;
            this.transformer = TransformerFactory.create(entityType);
        } catch (IllegalEntityType e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public T read(int position) {

        ensureCached();

        return this.lines.stream()
                         .skip(position)
                         .findFirst()
                         .filter(s -> s != null && s.trim().length() > 0)
                         .map(s -> transformer.toEntity(s))
                         .orElseThrow(() -> (
                             new RuntimeException(
                                 String.format(
                                     "no lines at position: %s",
                                     String.valueOf(position)))));
    }

    private void ensureCached() {
        if (Objects.isNull(this.lines)) {
            this.lines = reader.lines()
                               .collect(Collectors.toList());
        }
    }

    @Override
    public int append(T entity) {

        ensureCached();

        try {
            final String line =
                transformer.fromEntity(entity);

            writer.append(line);
            writer.flush();

            lines.add(line);

            return (lines.size() - 1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
