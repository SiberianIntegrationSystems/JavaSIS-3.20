package pro.sisit.adapter;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pro.sisit.adapter.impl.CSVAdapter;
import pro.sisit.adapter.impl.LoggerAdapter;
import pro.sisit.logger.impl.SystemOutputLogger;
import pro.sisit.model.Book;

public class CSVAdapterTest {

    private Path getBookFilePath() {
        return Paths.get("test-book-file.csv");
    }

    @Before
    public void createFile() throws IOException {
        // Если будут использовать Files, то даже лучше
        // значит запомнили этот момент :)
        //
        Files.write(getBookFilePath(), Arrays.asList(
            "Убик;Филип Дик;Научная фантастика;978-5-699-97309-5",
            "Будущее;Глуховский;Научная фантастика;978-5-17-118366-0"));
    }

    @After
    public void deleteFile() throws IOException {
        Files.delete(getBookFilePath());
    }

    @Test
    public void testRead() throws IOException {
        try (
            BufferedReader bookReader = new BufferedReader(
                new FileReader(getBookFilePath().toFile()));

            BufferedWriter bookWriter = new BufferedWriter(
                new FileWriter(getBookFilePath().toFile(), true));
        ) {

            CSVAdapter<Book> bookCsvAdapter =
                new CSVAdapter(Book.class, bookReader, bookWriter);

            // * Задание под звездочкой *
            LoggerAdapter<Book> bookLoggerAdapter =
                new LoggerAdapter<>(bookCsvAdapter, new SystemOutputLogger());

            Book book1 = bookLoggerAdapter.read(1);
            assertEquals("Глуховский", book1.getAuthor());
            assertEquals("Будущее", book1.getName());
            assertEquals("978-5-17-118366-0", book1.getIsbn());
            assertEquals("Научная фантастика", book1.getGenre());

            Book expectedBook0 = new Book(
                "Убик",
                "Филип Дик",
                "Научная фантастика",
                "978-5-699-97309-5");
            Book actualBook0 = bookLoggerAdapter.read(0);
            assertEquals(expectedBook0, actualBook0);
        }

        // TODO: написать тесты для проверки сущности автора
    }

    @Test
    public void testAppend() throws IOException {
        try (
            // Просто примеры более развернутого описания
            // ( если так напишут, то ничего страшного )
            //
            BufferedReader bookReader = new BufferedReader(
                new InputStreamReader(
                    new FileInputStream(getBookFilePath().toFile()),
                    "UTF8"));

            BufferedWriter bookWriter = new BufferedWriter(
                new OutputStreamWriter(
                    new FileOutputStream(getBookFilePath().toFile(), true),
                    "UTF8"));
        ) {

            CSVAdapter<Book> bookCsvAdapter =
                new CSVAdapter(Book.class, bookReader, bookWriter);

            // * Задание под звездочкой *
            LoggerAdapter<Book> bookLoggerAdapter =
                new LoggerAdapter<>(bookCsvAdapter, new SystemOutputLogger());

            Book newBook = new Book(
                "Чертоги разума. Убей в себе идиота!",
                "Андрей Курпатов",
                "Психология",
                "978-5-906902-91-7");

            int bookIndex = bookLoggerAdapter.append(newBook);
            Book bookAtIndex = bookLoggerAdapter.read(bookIndex);
            assertEquals(newBook, bookAtIndex);

            // TODO: написать тесты для проверки сущности автора
        }
    }
}
