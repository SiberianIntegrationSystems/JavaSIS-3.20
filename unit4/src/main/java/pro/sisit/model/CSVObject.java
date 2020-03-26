package pro.sisit.model;

import java.util.List;

/**
 * Интерфейс, определяющий поведение объектов, пригодных для записи в CSV файл
 */
public interface CSVObject {
    String DELIMITER = ";";

    String getCSVString();
    void fillField(List<String> list);
}
