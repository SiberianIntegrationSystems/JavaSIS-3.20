package pro.sisit.model;

import pro.sisit.CSVDelimiter;

import java.util.List;

/**
 * Интерфейс, определяющий поведение объектов, пригодных для записи в CSV файл
 */
public interface CSVObject extends CSVDelimiter {
    String getCSVString();
    void fillField(List<String> list);
}
