package pro.sisit.unit9.data;

import org.springframework.data.repository.CrudRepository;
import pro.sisit.unit9.entity.Book;
import pro.sisit.unit9.entity.Customer;
import pro.sisit.unit9.entity.PurchasedBook;

import java.math.BigDecimal;
import java.util.List;

public interface PurchasedBookRepository extends CrudRepository<PurchasedBook,Long> {

    List<PurchasedBook> findPurchaseByBook(Book book);

    List<PurchasedBook> findPurchaseByCustomer(Customer customer);

}
