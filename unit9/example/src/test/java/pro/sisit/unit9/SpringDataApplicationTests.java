package pro.sisit.unit9;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pro.sisit.unit9.entity.*;
import pro.sisit.unit9.service.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringDataApplicationTests {

	private static final int cost1 = 599;
	private static final int cost2 = 395;
	private static final int cost3 = 490;
	private static final int cost4 = 415;

	@Autowired
	private BookService bookService;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private AuthorService authorService;

	@Autowired
	private AuthorOfBookService authorOfBookService;

	@Autowired
	private PurchasedBookService purchasedBookService;

	@Before
	public void init() {
		Book book1 = new Book();
		book1.setDescription("Увлекательные приключения Тома Сойера");
		book1.setTitle("Приключения Тома Сойера");
		book1.setYear(1876);
		bookService.addBook(book1);

		Book book2 = new Book();
		book2.setTitle("Приключения Гекльберри Финна");
		book2.setYear(1884);
		bookService.addBook(book2);

		Author author = new Author();
		author.setFirstName("Марк");
		author.setLastName("Твен");
		authorService.addAuthor(author);

		authorOfBookService.addAuthorOfBook(author, book1);

		authorOfBookService.addAuthorOfBook(author, book2);

		Book book3 = new Book();
		book3.setTitle("Михаил Строгов");
		book3.setYear(1876);
		bookService.addBook(book3);

		Author author2 = new Author();
		author2.setFirstName("Жюль");
		author2.setLastName("Верн");
		authorService.addAuthor(author2);

		authorOfBookService.addAuthorOfBook(author2, book3);

		Book book4 = new Book();
		book4.setTitle("Буратино");
		book4.setYear(1936);
		bookService.addBook(book4);

		Author author3 = new Author();
		author3.setFirstName("Алексей");
		author3.setLastName("Толстой");
		authorService.addAuthor(author3);

		authorOfBookService.addAuthorOfBook(author3, book4);

		Customer customer = new Customer();
		customer.setName("Алексей");
		customer.setAddress("Красноярск");
		customerService.addCustomer(customer);

		purchasedBookService.addPurchasedBook(customer, book1, cost1);
		purchasedBookService.addPurchasedBook(customer, book3, cost3);

		Customer customer1 = new Customer();
		customer1.setName("Андрей");
		customer1.setAddress("Дивногорск");
		customerService.addCustomer(customer1);

		purchasedBookService.addPurchasedBook(customer1, book1, cost1);
		purchasedBookService.addPurchasedBook(customer1, book2, cost2);
		purchasedBookService.addPurchasedBook(customer1, book4, cost4);

		Customer customer2 = new Customer();
		customer2.setName("Денис");
		customer2.setAddress("Сосновоборск");
		customerService.addCustomer(customer2);

		purchasedBookService.addPurchasedBook(customer2, book1, cost1);
		purchasedBookService.addPurchasedBook(customer2, book3, cost3);
		purchasedBookService.addPurchasedBook(customer2, book4, cost4);

	}

	@After
	public void clear() {
		purchasedBookService.deleteAll();
		authorOfBookService.deleteAll();
		customerService.deleteAll();
		bookService.deleteAll();
		authorService.deleteAll();
	}

	@Test
	public void testSaveCustomer() {
		assertEquals(3, customerService.getAllCustomers().size());
		boolean founded = false;
		for (Customer customer : customerService.getAllCustomers()) {
			if (customer.getName().equals("Алексей")
					&& customer.getId() > 0) {
				founded = true;
				break;
			}
		}
		assertTrue(founded);
	}

	@Test
	public void testSavePurchasedBook() {
		assertEquals(8, purchasedBookService.getAllPurchasedBooks().size());
		boolean founded = false;
		for (PurchasedBook purchasedBook : purchasedBookService.getAllPurchasedBooks()) {
			if (purchasedBook.getBook().getTitle().equals("Приключения Тома Сойера")
					&& purchasedBook.getId() > 0) {
				founded = true;
				break;
			}
		}
		assertTrue(founded);
	}

	@Test
	public void testGetCostByBookTitle() {
		int cost;

		cost = purchasedBookService.getCostOfAllPurchasedBookByBookTitle("Приключения Тома Сойера");
		assertEquals(cost1*3, cost);

		cost = purchasedBookService.getCostOfAllPurchasedBookByBookTitle("Приключения Гекльберри Финна");
		assertEquals(cost2*1, cost);

		cost = purchasedBookService.getCostOfAllPurchasedBookByBookTitle("Михаил Строгов");
		assertEquals(cost3*2, cost);

		cost = purchasedBookService.getCostOfAllPurchasedBookByBookTitle("Буратино");
		assertEquals(cost4*2, cost);
	}

	@Test
	public void testGetCostByCustomerName() {
		int cost;

		cost = purchasedBookService.getCostOfAllPurchasedBookByCustomerName("Алексей");
		assertEquals(cost1+cost3, cost);

		cost = purchasedBookService.getCostOfAllPurchasedBookByCustomerName("Андрей");
		assertEquals(cost1+cost2+cost4, cost);

		cost = purchasedBookService.getCostOfAllPurchasedBookByCustomerName("Денис");
		assertEquals(cost1+cost3+cost4, cost);
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
	public void testFindByAuthorLastName() {
//		assertTrue(bookRepository.findByAuthor("Верн")
//				.stream().allMatch(book -> book.getTitle().equals("Михаил Строгов")));
	}

	@Test
	public void testComplexQueryMethod() {
//		assertEquals(4, bookRepository.complexQueryMethod().size());
	}

}
