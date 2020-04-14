package pro.sisit.unit9.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.sisit.unit9.data.PurchasedBookRepository;
import pro.sisit.unit9.entity.Book;
import pro.sisit.unit9.entity.Customer;
import pro.sisit.unit9.entity.PurchasedBook;

import java.util.List;

@Service
public class PurchasedBookService {

    @Autowired
    private PurchasedBookRepository purchasedBookRepository;

    /**
     * Метод покупки книги
     * @param customer Покупатель
     * @param book Книга
     * @param cost Стоимость
     */
    public void addPurchasedBook(Customer customer, Book book, int cost) {
        PurchasedBook purchasedBook = new PurchasedBook();
        purchasedBook.setBook(book);
        purchasedBook.setCustomer(customer);
        purchasedBook.setCost(cost);
        purchasedBookRepository.save(purchasedBook);
    }

    public void addPurchasedBook(PurchasedBook purchasedBook) {
        purchasedBookRepository.save(purchasedBook);
    }

    /**
     * Метод получения стоимости всех книг, купленных покупателем
     * @param customer Покупатель
     * @return Стоимость
     */
    public int getCostOfAllPurchasedBookByCustomer(Customer customer) {
        return getCostOfAllPurchasedBooksInList(
                purchasedBookRepository.findAllByCustomer(customer));
    }

    /**
     * Метод получения стоимости всех книг, купленных покупателем
     * @param name Имя покупателя
     * @return Стоимость
     */
    public int getCostOfAllPurchasedBookByCustomerName(String name) {
        return getCostOfAllPurchasedBooksInList(
                purchasedBookRepository.findAllByCustomer_Name(name));
    }

    /**
     * Метод получения стоимости всех купленных книг по самой книге
     * @param book Книг
     * @return Стоимость
     */
    public int getCostOfAllPurchasedBookByBook(Book book) {
        return getCostOfAllPurchasedBooksInList(
                purchasedBookRepository.findAllByBook(book));
    }

    /**
     * Метод получения стоимости всех купленных книг по названию книги
     * @param title Название книги
     * @return Стоимость
     */
    public int getCostOfAllPurchasedBookByBookTitle(String title) {
        return getCostOfAllPurchasedBooksInList(
                purchasedBookRepository.findAllByBook_Title(title));
    }

    /**
     * Метод получения стоимости всех купленных книг в списке
     * @param purchasedBooks Список купленных книг
     * @return Стоимость
     */
    private int getCostOfAllPurchasedBooksInList(List<PurchasedBook> purchasedBooks) {
        return purchasedBooks.stream()
                .reduce(0,
                        (x,y) -> x + y.getCost(),
                        Integer::sum);
    }

    public List<PurchasedBook> getAllPurchasedBooks() {
        return purchasedBookRepository.findAll();
    }

    public void deleteAll() {
        purchasedBookRepository.deleteAll();
    }
}
