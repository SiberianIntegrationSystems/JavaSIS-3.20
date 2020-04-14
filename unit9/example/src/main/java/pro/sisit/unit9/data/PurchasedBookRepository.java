package pro.sisit.unit9.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pro.sisit.unit9.entity.Book;
import pro.sisit.unit9.entity.Customer;
import pro.sisit.unit9.entity.PurchasedBook;

import java.util.List;

@Repository
public interface PurchasedBookRepository extends CrudRepository<PurchasedBook, Long>,
        JpaRepository<PurchasedBook, Long> {
    List<PurchasedBook> findAllByCustomer(Customer customer);
    List<PurchasedBook> findAllByCustomer_Name(String name);
    List<PurchasedBook> findAllByBook(Book book);
    List<PurchasedBook> findAllByBook_Title(String title);
}
