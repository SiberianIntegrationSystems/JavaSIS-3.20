package pro.sisit.adapter.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import pro.sisit.CSVDelimiter;
import pro.sisit.adapter.IOAdapter;
import pro.sisit.model.CSVObject;

// 1. TODO: написать реализацию адаптера

// Класс, который будет работать с адаптером,
// должен реализовывать интерфейс FieldPlaceholder
// и иметь конструктор по умолчанию
public class CSVAdapter<T extends CSVObject> implements IOAdapter<T>, CSVDelimiter {

    private Class<T> entityType;
    private BufferedReader reader;
    private BufferedWriter writer;

    public CSVAdapter(Class<T> entityType, BufferedReader reader,
        BufferedWriter writer) {

        this.entityType = entityType;
        this.reader = reader;
        this.writer = writer;
        try {
            reWrite();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Не получается создать объект");
        }
    }

    /**
     * Метод считывающий строку из файла и получающий объект из неё
     * @param index Индекс нужной строки
     * @return Объект соответствующего типа
     */
    @Override
    public T read(int index) {
        // Создание переменной типа T
        T newT = null;
        try {
            // Запоминаем начальную позицию
            reader.mark(100000);
            // Получение объекта типа T, с пмощью пустого конструктора
            newT = entityType.getDeclaredConstructor().newInstance();
            // Переход к нужной строке
            goToDesiredLine(index);
            // Считывание строки
            String string = reader.readLine();
            // Если ничего не считалось, то выбрасывается исключение, т.к. строки нет
            if (string==null) throw new RuntimeException(String.format("Файл не имеет строки под номером %d", index));
            // Разбиение строки на список параметров
            List<String> listOfParameters = Arrays.asList(string.split(DELIMITER));
            // Запонение полей объекта
            newT.fillField(listOfParameters);
            // Сбрасываем позицию к началу
            reader.reset();
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
            throw new RuntimeException("Ошибка создания объекта с помощью пустого конструктора");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Ошибка чтения файла");
        }
        return newT;
    }

    /**
     * Метод перезаписи файла для того,
     * чтобы дальнейшая запись шла в конец файла
     * @throws IOException Ошибка работы с файлом
     */
    private void reWrite() throws IOException {
        for (String s: getLines()) {
            writer.write(s);
            writer.newLine();
        }
        writer.flush();
    }

    /**
     * Метод получения всех строк из файла
     * @return Список строк
     * @throws IOException Ошибка работы с файлом
     */
    private List<String> getLines() throws IOException {
        List<String> listOfLines = new ArrayList<>();
        reader.mark(100000);
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
        reader.mark(100000);
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

