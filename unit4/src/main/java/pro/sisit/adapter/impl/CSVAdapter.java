package pro.sisit.adapter.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import pro.sisit.adapter.IOAdapter;
import pro.sisit.model.CSVObject;
import pro.sisit.model.CSVObjectFactory;
import pro.sisit.model.CSVObjectType;

// Класс, который будет работать с адаптером,
// должен реализовывать интерфейс CSVObject
// и иметь конструктор по умолчанию
public class CSVAdapter<T extends CSVObject> implements IOAdapter<T> {

    private Class<T> entityType;
    private final CSVObjectFactory csvObjectFactory;
    private BufferedReader reader;
    private BufferedWriter writer;

    private final static String DELIMITER = ";";
    private final static int readAheadLimit = 100000;

    public CSVAdapter(Class<T> entityType, CSVObjectFactory csvObjectFactory,
                      BufferedReader reader, BufferedWriter writer) {

        this.entityType = entityType;
        this.csvObjectFactory = csvObjectFactory;
        this.reader = reader;
        this.writer = writer;
    }

    /**
     * Метод считывающий строку из файла и получающий объект из неё
     * @param index Индекс нужной строки
     * @return Объект соответствующего типа
     */
    @Override
    public T read(int index) {
        // Создание переменной типа T
        T resultObject = null;
        try {
            // Запоминаем начальную позицию
            reader.mark(readAheadLimit);
            // Получение объекта
            switch (entityType.getSimpleName()) {
                case "Author":
                    resultObject = (T) csvObjectFactory.createCSVObject(CSVObjectType.AUTHOR);
                    break;
                case "Book":
                    resultObject = (T) csvObjectFactory.createCSVObject(CSVObjectType.BOOK);
                    break;
                case "Library":
                    resultObject = (T) csvObjectFactory.createCSVObject(CSVObjectType.LIBRARY);
                    break;
                default:
                    throw new RuntimeException("Попытка создания неизвестного объекта");
            }
            // Переход к нужной строке
            goToDesiredLine(index);
            // Считывание строки
            String string = reader.readLine();
            // Если ничего не считалось, то выбрасывается исключение, т.к. строки нет
            if (string==null) {
                throw new RuntimeException(
                        String.format("Файл не имеет строки под номером %d", index));
            }
            // Разбиение строки на список параметров
            List<String> listOfParameters = Arrays.asList(string.split(DELIMITER));
            // Запонение полей объекта
            resultObject.fillField(listOfParameters);
            // Сбрасываем позицию к началу
            reader.reset();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Ошибка чтения файла");
        }
        return resultObject;
    }

    /**
     * Метод получения всех строк из файла
     * @return Список строк
     * @throws IOException Ошибка работы с файлом
     */
    private List<String> getLines() throws IOException {
        List<String> listOfLines = new ArrayList<>();
        reader.mark(readAheadLimit);
        String s;
        while ((s = reader.readLine()) != null) {
            listOfLines.add(s);
        }
        reader.reset();
        return listOfLines;
    }

    /**
     * Метод перехода к нужной строке в файле
     * @param lineIndex Индекс необходимой строки
     */
    private void goToDesiredLine(int lineIndex) {
        // Проход по ненужным строкам
        for (int i = 0; i < lineIndex; i++) {
            try {
                if (reader.readLine() == null) {
                    throw new RuntimeException(String.format("Файл не имеет строки под номером %d", lineIndex));
                }
            } catch (IOException e) {
                throw new RuntimeException("Ошибка чтения файла");
            }
        }
    }

    private int countOfLen() throws IOException {
        int count = 0;
        String s;
        reader.mark(readAheadLimit);
        while ((s = reader.readLine()) != null) {
            count++;
        }
        reader.reset();
        return count;
    }

    /**
     * Метод записывающий объект в файл
     * @param entity Сущность для записи
     * @return Индекс новой строки (-1 если запись не удалась)
     */
    @Override
    public int append(CSVObject entity) {
        int index = -1;
        if (entity == null) {
            return index;
        }
        try {
            writer.write(entity.getCSVString());
            writer.newLine();
            writer.flush();
            index = countOfLen()-1;
        } catch (IOException e) {
            return index;
        }
        return index;
    }
}

