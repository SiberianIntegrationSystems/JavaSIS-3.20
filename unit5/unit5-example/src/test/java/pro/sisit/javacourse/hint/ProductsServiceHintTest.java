package pro.sisit.javacourse.hint;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import pro.sisit.javacourse.Producer;
import pro.sisit.javacourse.Product;
import pro.sisit.javacourse.ProductType;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static pro.sisit.javacourse.data.ProductTestData.*;


public class ProductsServiceHintTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testFilterByType() {
        ProductType productType = ProductType.Candy;
        List<Product> products = ProductsServiceHint.filterByType(getProducts(), productType);

        Assert.assertEquals(getProducts(productType), products);
    }

    @Test
    public void testGetUniqueProducers() {
        List<Producer> uniqueProducers = ProductsServiceHint.getUniqueProducers(getProducts());

        Assert.assertEquals(
                getProducers()
                        .stream()
                        .sorted(Comparator.comparing(Producer::getName))
                        .collect(Collectors.toList()), uniqueProducers);
    }

    @Test
    public void testGetTotalTax() {
        BigDecimal totalTax = ProductsServiceHint.getTotalTax(getProducts());
        Assert.assertEquals(getTotalTax(), totalTax);
    }

    @Test
    public void testFindExistedProductByIdUnsafe() {
        Assert.assertNotNull(
                ProductsServiceHint.findProductByIdUnsafe(getProducts(), getRandomProduct().getId()));
    }

    @Test
    public void testFindNotExistedProductByIdUnsafe() {
        Assert.assertNull(
                ProductsServiceHint.findProductByIdUnsafe(getProducts(), getNotExistProductId()));
    }

    @Test
    public void testDetectExistedProductProducerNameUnsafe() {
        Product product = getRandomProduct();
        String producerName = ProductsServiceHint.detectProducerNameUnsafe(getProducts(), product.getId());
        Assert.assertEquals(product.getProducer().getName(), producerName);
    }

    @Test
    public void testDetectNotExistedProductProducerNameUnsafe() {
        expectedException.expect(NullPointerException.class);
        ProductsServiceHint.detectProducerNameUnsafe(getProducts(), getNotExistProductId());
    }

    @Test
    public void testFindExistedProductById() {
        Optional<Product> productOptional = ProductsServiceHint.findProductById(getProducts(), getRandomProduct().getId());
        Assert.assertEquals(Optional.class, productOptional.getClass());
        Assert.assertTrue(productOptional.isPresent());
    }

    @Test
    public void testFindNotExistedProductById() {
        Optional<Product> productOptional = ProductsServiceHint.findProductById(getProducts(), getNotExistProductId());
        Assert.assertEquals(Optional.class, productOptional.getClass());
        Assert.assertFalse(productOptional.isPresent());
    }

    @Test
    public void testDetectExistedProductProducerNameSoft() {
        Product product = getRandomProduct();
        String producerName = ProductsServiceHint.detectProducerNameSoft(getProducts(), product.getId());
        Assert.assertEquals(product.getProducer().getName(), producerName);
    }

    @Test
    public void testDetectNotExistedProductProducerNameSoft() {
        String producerName = ProductsServiceHint.detectProducerNameSoft(getProducts(), getNotExistProductId());
        Assert.assertEquals("Неизвестный производитель", producerName);
    }

    @Test
    public void testGetExistedProductById() {
        Product product = ProductsServiceHint.getProductById(getProducts(), getRandomProduct().getId());
        Assert.assertNotNull(product);
    }

    @Test
    public void testGetNotExistedProductById() {
        long notExistProductId = getNotExistProductId();
        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage(String.format("Товар с идентификатором '%s' не найден", notExistProductId));
        ProductsServiceHint.getProductById(getProducts(), notExistProductId);
    }

    @Test
    public void testDetectExistedProductProducerName() {
        Product product = getRandomProduct();
        String producerName = ProductsServiceHint.detectProducerName(getProducts(), product.getId());
        Assert.assertEquals(product.getProducer().getName(), producerName);
    }

    @Test
    public void testDetectNotExistedProductProducerName() {
        long notExistProductId = getNotExistProductId();
        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage(String.format("Товар с идентификатором '%s' не найден", notExistProductId));
        ProductsServiceHint.detectProducerName(getProducts(), notExistProductId);
    }

    @Test
    public void testGetProducerNameByProduct() {
        Product product = getRandomProduct();
        String producerName = ProductsServiceHint.getProducerNameByProduct(product);

        Assert.assertEquals(product.getProducer().getName(), producerName);
    }
}