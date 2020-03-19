package pro.sisit.adapter.impl;

import pro.sisit.adapter.IOAdapter;
import pro.sisit.model.CSVObject;

public class CSVAdapterLog<T extends CSVObject> implements IOAdapter<T> {

    private IOAdapter<T> adapter;

    public CSVAdapterLog(IOAdapter<T> adapter) {
        this.adapter = adapter;
    }

    @Override
    public T read(int index) {
        System.out.printf("Чтение из файла сущности по индексу %d.%n", index);
        return adapter.read(index);
    }

    @Override
    public int append(T entity) {
        System.out.printf("Добавление сущности %s в файл.%n", entity.getClass().getSimpleName());
        return adapter.append(entity);
    }
}
