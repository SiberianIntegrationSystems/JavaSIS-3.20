package pro.sisit.javacourse;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static pro.sisit.javacourse.data.ProductTestData.*;


public class ProductsServiceTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testFilterByType() {
        ProductType productType = ProductType.Candy;
        List<Product> products = ProductsService.filterByType(getProducts(), productType);

        Assert.assertEquals(getProducts(productType), products);
    }

    @Test
    public void testGetUniqueProducers() {
        List<Producer> uniqueProducers = ProductsService.getUniqueProducers(getProducts());

        Assert.assertEquals(getProducers(), uniqueProducers);
    }

    @Test
    public void testGetTotalTax() {
        BigDecimal totalTax = ProductsService.getTotalTax(getProducts());

        Assert.assertEquals(getTotalTax(), totalTax);
    }

    @Test
    public void testFindExistedProductByIdUnsafe() {
        Assert.assertNotNull(
                ProductsService.findProductByIdUnsafe(getProducts(), getRandomProduct().getId()));
    }

    @Test
    public void testFindNotExistedProductByIdUnsafe() {
        Assert.assertNull(
                ProductsService.findProductByIdUnsafe(getProducts(), getNotExistProductId()));
    }

    @Test
    public void testDetectExistedProductProducerNameUnsafe() {
        Product product = getRandomProduct();
        String producerName = ProductsService.detectProducerNameUnsafe(getProducts(), product.getId());
        Assert.assertEquals(product.getProducer().getName(), producerName);
    }

    @Test
    public void testDetectNotExistedProductProducerNameUnsafe() {
        expectedException.expect(NullPointerException.class);
        ProductsService.detectProducerNameUnsafe(getProducts(), getNotExistProductId());
    }

    @Test
    public void testFindExistedProductById() {
        Optional<Product> productOptional = ProductsService.findProductById(getProducts(), getRandomProduct().getId());
        Assert.assertEquals(Optional.class, productOptional.getClass());
        Assert.assertTrue(productOptional.isPresent());
    }

    @Test
    public void testFindNotExistedProductById() {
        Optional<Product> productOptional = ProductsService.findProductById(getProducts(), getNotExistProductId());
        Assert.assertEquals(Optional.class, productOptional.getClass());
        Assert.assertFalse(productOptional.isPresent());
    }

    @Test
    public void testDetectExistedProductProducerNameSoft() {
        Product product = getRandomProduct();
        String producerName = ProductsService.detectProducerNameSoft(getProducts(), product.getId());
        Assert.assertEquals(product.getProducer().getName(), producerName);
    }

    @Test
    public void testDetectNotExistedProductProducerNameSoft() {
        String producerName = ProductsService.detectProducerNameSoft(getProducts(), getNotExistProductId());
        Assert.assertEquals("Неизвестный производитель", producerName);
    }

    @Test
    public void testDetectExistedProductProducerName() {
        Product product = getRandomProduct();
        String producerName = ProductsService.detectProducerName(getProducts(), product.getId());
        Assert.assertEquals(product.getProducer().getName(), producerName);
    }

    @Test
    public void testDetectNotExistedProductProducerName() {
        long notExistProductId = getNotExistProductId();
        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage(String.format("Товар с идентификатором '%s' не найден", notExistProductId));
        ProductsService.detectProducerName(getProducts(), notExistProductId);
    }

    @Test
    public void testGetProducerNameByProduct() {
        Product product = getRandomProduct();
        String producerName = ProductsService.getProducerNameByProduct(product);

        Assert.assertEquals(product.getProducer().getName(), producerName);
    }
}