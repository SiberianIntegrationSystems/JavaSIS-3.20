package pro.sisit.unit9;

import lombok.Lombok;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pro.sisit.unit9.data.*;
import pro.sisit.unit9.entity.*;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.concurrent.CompletionStage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringDataApplicationTests {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private AuthorRepository authorRepository;

	@Autowired
	private AuthorOfBookRepository authorOfBookRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private PurchasedBookRepository purchasedBookRepository;

	@Autowired
	private PurchaseBookServiceImpl purchaseBookServiceImpl;

	@Before
	public void init() {
		Book book = new Book();
		book.setDescription("Увлекательные приключения Тома Сойера");
		book.setTitle("Приключения Тома Сойера");
		book.setYear(1876);
		bookRepository.save(book);

		Book book2 = new Book();
		book2.setTitle("Михаил Строгов");
		book2.setYear(1876);
		bookRepository.save(book2);

		Book book3 = new Book();
		book3.setTitle("Приключения Гекльберри Финна");
		book3.setYear(1884);
		bookRepository.save(book3);

		Author author = new Author();
		author.setFirstname("Марк");
		author.setLastname("Твен");
		authorRepository.save(author);

		AuthorOfBook authorOfBook = new AuthorOfBook();
		authorOfBook.setAuthor(author);
		authorOfBook.setBook(book);
		authorOfBookRepository.save(authorOfBook);

		AuthorOfBook authorOfBook2 = new AuthorOfBook();
		authorOfBook2.setAuthor(author);
		authorOfBook2.setBook(book3);
		authorOfBookRepository.save(authorOfBook2);

		Author author2 = new Author();
		author2.setFirstname("Жюль");
		author2.setLastname("Верн");
		authorRepository.save(author2);

		AuthorOfBook authorOfBook3 = new AuthorOfBook();
		authorOfBook3.setAuthor(author2);
		authorOfBook3.setBook(book2);
		authorOfBookRepository.save(authorOfBook3);

		Book book4 = new Book();
		book4.setTitle("Буратино");
		book4.setYear(1936);
		bookRepository.save(book4);

		Author author3 = new Author();
		author3.setFirstname("Алексей");
		author3.setLastname("Толстой");
		authorRepository.save(author3);

		AuthorOfBook authorOfBook4 = new AuthorOfBook();
		authorOfBook4.setAuthor(author3);
		authorOfBook4.setBook(book4);
		authorOfBookRepository.save(authorOfBook4);

		Customer customer1 = new Customer();
		customer1.setName("Антон");
		customer1.setAddress("г. Братск");
		customerRepository.save(customer1);

		Customer customer2 = new Customer();
		customer2.setName("Катерина");
		customer2.setAddress("г. Красноярск");
		customerRepository.save(customer2);

		PurchasedBook purchased1 = new PurchasedBook();
		purchased1.setBook(book);
		purchased1.setPrice(BigDecimal.valueOf(1000.0));
		purchased1.setCustomer(customer1);
		purchasedBookRepository.save(purchased1);

		PurchasedBook purchased2 = new PurchasedBook();
		purchased2.setBook(book2);
		purchased2.setPrice(BigDecimal.valueOf(1500.0));
		purchased2.setCustomer(customer1);
		purchasedBookRepository.save(purchased2);

		PurchasedBook purchased3 = new PurchasedBook();
		purchased3.setBook(book3);
		purchased3.setPrice(BigDecimal.valueOf(2000.0));
		purchased3.setCustomer(customer1);
		purchasedBookRepository.save(purchased3);

		PurchasedBook purchased4 = new PurchasedBook();
		purchased4.setBook(book);
		purchased4.setPrice(BigDecimal.valueOf(1000.0));
		purchased4.setCustomer(customer2);
		purchasedBookRepository.save(purchased4);

		PurchasedBook purchased5 = new PurchasedBook();
		purchased5.setBook(book3);
		purchased5.setPrice(BigDecimal.valueOf(1000.0));
		purchased5.setCustomer(customer2);
		purchasedBookRepository.save(purchased5);

	}

	@Test
	public void testCountTotalPriceBook() {
//		Optional<Book> book1 = bookRepository.findById(Long.valueOf(1));
//		if (book1.isPresent()) {
//			assertEquals(new BigDecimal("2000.00"), purchaseBookServiceImpl.countTotalPriceBook(book1.get()));
//		}
//
//		Optional<Customer> customer = customerRepository.findById(Long.valueOf(1));
//		if (customer.isPresent()) {
//			assertEquals(new BigDecimal("4500.00"), purchaseBookServiceImpl.countTotalPurchaseCustomer(customer.get()));
//		}
	}

	@Test
	public void testFindPurchasedBook() {
//		Optional<Book> book1 = bookRepository.findById(Long.valueOf(1));
//		if (book1.isPresent()) {
//			assertEquals(2, purchasedBookRepository.findPurchaseByBook(book1.get()).size());
//		}
//
//		Optional<Customer> customer = customerRepository.findById(Long.valueOf(2));
//		if (customer.isPresent()) {
//			assertEquals(2, purchasedBookRepository.findPurchaseByCustomer(customer.get()).size());
//		}
	}

	@Test
	public void testSavePurchase() {
//		long count = purchasedBookRepository.count();
//		long expected_count = 5;
//
//		assertEquals(expected_count,count);
	}

	@Test
	public void testSaveCustomer() {
//		long count = customerRepository.count();
//		long expected_count = 2;
//
//		assertEquals(expected_count,count);
	}

	@Test
	public void testSave() {
//		boolean founded = false;
//		for (Book iteratedBook : bookRepository.findAll()) {
//			if (iteratedBook.getTitle().equals("Буратино")
//					&& iteratedBook.getId() > 0) {
//				founded = true;
//				break;
//			}
//		}
//		assertTrue(founded);
	}

	@Test
	public void testFindByYear() {
//		assertEquals(2, bookRepository.findByYear(1876).size());
//		assertEquals(1, bookRepository.findByYear(1884).size());
//		assertEquals(0, bookRepository.findByYear(2000).size());
	}

	@Test
	public void testFindAtPage() {
//		PageRequest pageRequest = PageRequest.of(1, 1, Sort.Direction.ASC, "title");
//		assertTrue(bookRepository.findAll(pageRequest)
//				.get().allMatch(book -> book.getTitle().equals("Михаил Строгов")));
	}

	@Test
	public void testFindSame() {
//		Book book = new Book();
//		book.setYear(1876);
//
//		assertEquals(2, bookRepository.findAll(Example.of(book)).size());
	}

	@Test
	public void testFindInRange() {
//		assertEquals(3, bookRepository.findAll(
//				BookSpecifications.byYearRange(1800, 1900)).size());
//		assertEquals(0, bookRepository.findAll(
//				BookSpecifications.byYearRange(2000, 2010)).size());
	}

	@Test
	public void testFindByAuthorLastname() {
//		assertTrue(bookRepository.findByAuthor("Верн")
//				.stream().allMatch(book -> book.getTitle().equals("Михаил Строгов")));
	}

	@Test
	public void testComplexQueryMethod() {
//		assertEquals(4, bookRepository.complexQueryMethod().size());
	}

}
