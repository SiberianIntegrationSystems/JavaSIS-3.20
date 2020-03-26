package pro.sisit.adapter;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.io.*;
import java.nio.file.Paths;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pro.sisit.adapter.impl.CSVAdapter;
import pro.sisit.adapter.impl.CSVAdapterLog;
import pro.sisit.model.Author;
import pro.sisit.model.Book;
import pro.sisit.model.CSVObjectFactory;
import pro.sisit.model.Library;


public class CSVAdapterTest {

    @Before
    public void createFile() {

        File authorsFile = Paths.get("test-author-file.csv").toFile();
        File booksFile = Paths.get("test-book-file.csv").toFile();
        File librariesFile = Paths.get("test-library-file.csv").toFile();
        try {
            authorsFile.createNewFile();
            booksFile.createNewFile();
            librariesFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Не удалось создать файл");
        }

        try (BufferedWriter authorWriter = new BufferedWriter(new FileWriter(authorsFile, true));
             BufferedWriter bookWriter = new BufferedWriter(new FileWriter(booksFile, true));
             BufferedWriter libraryWriter = new BufferedWriter(new FileWriter(librariesFile, true))) {

            authorWriter.write("Есенин С.А.;Российская империя");
            authorWriter.newLine();
            authorWriter.write("Шекспир У.;Королевство Англия");
            authorWriter.newLine();
            authorWriter.write("Драйзер Т.;США");
            authorWriter.newLine();
            authorWriter.write("Моэм С.;Франция");
            authorWriter.newLine();
            authorWriter.flush();

            bookWriter.write("Титан;Драйзер Т.;Психологический реализм;9-78605-736-3");
            bookWriter.newLine();
            bookWriter.write("Трагедия о Кориолане;Шекспир У.;Трагедия;8-234-84233-6");
            bookWriter.newLine();
            bookWriter.write("Театр;Моэм С.;Роман;9-36552-745-0");
            bookWriter.newLine();
            bookWriter.flush();

            libraryWriter.write("ГПНТБ;Новосибирск;109752");
            libraryWriter.newLine();
            libraryWriter.write("РГБ;Москва;534722");
            libraryWriter.newLine();
            libraryWriter.write("Библиотека СФУ;Красноярск;56072");
            libraryWriter.newLine();
            libraryWriter.flush();

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Не удалось записать файлы");
        }
    }

    @After
    public void deleteFile() {
        File authorsFile = Paths.get("test-author-file.csv").toFile();
        File booksFile = Paths.get("test-book-file.csv").toFile();
        File librariesFile = Paths.get("test-library-file.csv").toFile();

        librariesFile.delete();
        authorsFile.delete();
        booksFile.delete();

        assertFalse(authorsFile.exists());
        assertFalse(booksFile.exists());
        assertFalse(librariesFile.exists());
    }

    @Test
    public void testRead() {

        File authorsFile = Paths.get("test-author-file.csv").toFile();
        File booksFile = Paths.get("test-book-file.csv").toFile();
        File librariesFile = Paths.get("test-library-file.csv").toFile();

        try (BufferedReader authorReader = new BufferedReader(new FileReader(authorsFile));
             BufferedWriter authorWriter = new BufferedWriter(new FileWriter(authorsFile, true));
             BufferedReader bookReader = new BufferedReader(new FileReader(booksFile));
             BufferedWriter bookWriter = new BufferedWriter(new FileWriter(booksFile, true));
             BufferedReader libraryReader = new BufferedReader(new FileReader(librariesFile));
             BufferedWriter libraryWriter = new BufferedWriter(new FileWriter(librariesFile, true))) {

            // Тесты сущности Author
            IOAdapter<Author> authorAdapter = new CSVAdapterLog<>(
                    new CSVAdapter<>(Author.class, new CSVObjectFactory(), authorReader, authorWriter));
            Author author = authorAdapter.read(1);
            assertEquals("Шекспир У.", author.getName());
            assertEquals("Королевство Англия", author.getBirthPlace());
            Author expectedAuthor = new Author(
                    "Есенин С.А.",
                    "Российская империя"
            );
            Author actualAuthor = authorAdapter.read(0);
            assertEquals(expectedAuthor, actualAuthor);

            // Тесты сущности Book
            IOAdapter<Book> bookAdapter = new CSVAdapterLog<>(
                    new CSVAdapter<>(Book.class, new CSVObjectFactory(), bookReader, bookWriter));
            Book book = bookAdapter.read(1);
            assertEquals("Трагедия о Кориолане", book.getName());
            assertEquals("Шекспир У.", book.getAuthor());
            assertEquals("Трагедия", book.getGenre());
            assertEquals("8-234-84233-6", book.getIsbn());

            Book expectedBook = new Book(
                    "Титан",
                    "Драйзер Т.",
                    "Психологический реализм",
                    "9-78605-736-3");
            Book actualBook = bookAdapter.read(0);
            assertEquals(expectedBook, actualBook);

            // Тесты сущности Library
            IOAdapter<Library> libraryAdapter = new CSVAdapterLog<>(
                    new CSVAdapter<>(Library.class, new CSVObjectFactory(), libraryReader, libraryWriter));
            Library library = libraryAdapter.read(1);
            assertEquals("РГБ", library.getName());
            assertEquals("Москва", library.getAddress());
            assertEquals(534722, library.getCountOfBook());

            Library expectedLibrary = new Library(
                    "ГПНТБ",
                    "Новосибирск",
                    109752
            );
            Library actualLibrary = libraryAdapter.read(0);
            assertEquals(expectedLibrary, actualLibrary);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Тесты на чтение не пройдены");
        }
    }

    @Test
    public void testAppend() {

        File authorsFile = Paths.get("test-author-file.csv").toFile();
        File booksFile = Paths.get("test-book-file.csv").toFile();
        File librariesFile = Paths.get("test-library-file.csv").toFile();

        try (BufferedReader authorReader = new BufferedReader(new FileReader(authorsFile));
             BufferedWriter authorWriter = new BufferedWriter(new FileWriter(authorsFile, true));
             BufferedReader bookReader = new BufferedReader(new FileReader(booksFile));
             BufferedWriter bookWriter = new BufferedWriter(new FileWriter(booksFile, true));
             BufferedReader libraryReader = new BufferedReader(new FileReader(librariesFile));
             BufferedWriter libraryWriter = new BufferedWriter(new FileWriter(librariesFile, true))) {

            // Тесты сущности Author
            IOAdapter<Author> authorAdapter = new CSVAdapterLog<>(
                    new CSVAdapter<>(Author.class, new CSVObjectFactory(), authorReader, authorWriter));
            Author newAuthor = new Author(
                    "Кори Дж.",
                    "Великобритания"
            );
            int appendIndex = authorAdapter.append(newAuthor);
            Author authorInIndex = authorAdapter.read(appendIndex);
            assertEquals(newAuthor, authorInIndex);

            // Тесты сущности Book
            IOAdapter<Book> bookAdapter = new CSVAdapterLog<>(
                    new CSVAdapter<>(Book.class, new CSVObjectFactory(), bookReader, bookWriter));
            Book newBook = new Book(
                    "Финансист",
                    "Драйзер Т.",
                    "Психологический реализм",
                    "9-78235-341-0");
            int bookIndex = bookAdapter.append(newBook);
            Book bookInIndex = bookAdapter.read(bookIndex);
            assertEquals(newBook, bookInIndex);

            // Тесты сущности Library
            IOAdapter<Library> libraryAdapter = new CSVAdapterLog<>(
                    new CSVAdapter<>(Library.class, new CSVObjectFactory(), libraryReader, libraryWriter));
            Library newLibrary = new Library(
                    "Библиотека Конгресса",
                    "Вашингтон",
                    22934752
            );
            int libraryIndex = libraryAdapter.append(newLibrary);
            Library libraryInIndex = libraryAdapter.read(libraryIndex);
            assertEquals(newLibrary, libraryInIndex);

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Тесты на запись не пройдены");
        }

    }
}
