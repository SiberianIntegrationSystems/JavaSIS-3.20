package pro.sisit.unit9.data;

import org.springframework.stereotype.Service;
import pro.sisit.unit9.entity.Book;
import pro.sisit.unit9.entity.Customer;

import java.math.BigDecimal;
@Service
public class PurchaseBookServiceImpl implements PurchaseBookService {

    private final PurchasedBookRepository purchasedBookRepository;

    public PurchaseBookServiceImpl(PurchasedBookRepository purchasedBookRepository) {
        this.purchasedBookRepository = purchasedBookRepository;
    }

    @Override
    public BigDecimal countTotalPriceBook(Book book) {

        BigDecimal result = purchasedBookRepository.findPurchaseByBook(book).stream().
                map(e -> e.getPrice()).reduce(BigDecimal.ZERO,BigDecimal::add);

        return result;
    }

    @Override
    public BigDecimal countTotalPurchaseCustomer(Customer customer) {
        BigDecimal result = purchasedBookRepository.findPurchaseByCustomer(customer).stream().
                map(e -> e.getPrice()).reduce(BigDecimal.ZERO,BigDecimal::add);

        return result;
    }
}
