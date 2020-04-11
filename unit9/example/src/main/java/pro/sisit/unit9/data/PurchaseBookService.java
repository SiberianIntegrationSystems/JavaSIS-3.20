package pro.sisit.unit9.data;

import pro.sisit.unit9.entity.Book;
import pro.sisit.unit9.entity.Customer;

import java.math.BigDecimal;

public interface PurchaseBookService {

    BigDecimal countTotalPriceBook(Book book);

    BigDecimal countTotalPurchaseCustomer (Customer customer);

}
