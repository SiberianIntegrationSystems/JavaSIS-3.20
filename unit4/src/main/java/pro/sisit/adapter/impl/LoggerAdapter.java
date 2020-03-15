package pro.sisit.adapter.impl;

import pro.sisit.adapter.IOAdapter;
import pro.sisit.logger.Logger;

public class LoggerAdapter<T> implements IOAdapter<T> {

    private IOAdapter<T> internalAdapter;
    private Logger logger;

    public LoggerAdapter(IOAdapter<T> internalAdapter, Logger logger) {
        this.internalAdapter = internalAdapter;
        this.logger = logger;
    }

    @Override
    public T read(int index) {
        logger.log(String.format("Start read at index: %d", index));

        final T result = internalAdapter.read(index);

        logger.log(String.format("Read entity '%s' at index: %d", result.toString(), index));

        return result;
    }

    @Override
    public int append(T entity) {
        logger.log(String.format("Start append entity: '%s'", entity.toString()));

        int result = internalAdapter.append(entity);

        logger.log(String.format("Appended entity: '%s' at index: %d", entity.toString(), result));

        return result;
    }
}
