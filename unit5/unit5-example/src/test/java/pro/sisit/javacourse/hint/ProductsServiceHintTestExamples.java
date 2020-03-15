package pro.sisit.javacourse.hint;

import org.junit.Test;
import pro.sisit.javacourse.Producer;
import pro.sisit.javacourse.Product;
import pro.sisit.javacourse.ProductType;
import pro.sisit.javacourse.data.ProductTestData;

import java.math.BigDecimal;
import java.util.List;

/**
 * Дубликат тестов с реализованными методами
 */
public class ProductsServiceHintTestExamples {

    @Test
    public void testExampleFilterByType() {
        ProductType productType = ProductType.Candy;
        List<Product> products = ProductsServiceHint.filterByType(ProductTestData.getProducts(), productType);

        System.out.println("Продукты:");
        products.forEach(product -> System.out.println(product.toString()));
    }

    @Test
    public void testExampleGetUniqueProducers() {
        List<Producer> uniqueProducers = ProductsServiceHint.getUniqueProducers(ProductTestData.getProducts());

        System.out.println("Производители:");
        uniqueProducers.forEach(producer -> System.out.println(producer.getName()));
    }

    @Test
    public void testExampleGetTotalTax() {
        BigDecimal totalTax = ProductsServiceHint.getTotalTax(ProductTestData.getProducts());
        System.out.printf("Общая сумма НДС: '%s'", totalTax);
    }

    @Test
    public void testExampleDetectProducerNameUnsafe() {
        try {
            String producerName = ProductsServiceHint.detectProducerNameUnsafe(ProductTestData.getProducts(), 666);
            System.out.printf("Наименование производителя: '%s'", producerName);
        } catch (RuntimeException ex) {
            System.out.printf("Произошла ошибка: '%s'", ex.toString());
        }
    }

    @Test
    public void testExampleDetectProducerNameSoft() {
        String producerName = ProductsServiceHint.detectProducerNameSoft(ProductTestData.getProducts(), 666);
        System.out.printf("Наименование производителя: '%s'", producerName);
    }

    @Test
    public void testExampleDetectProducerName() {
        try {
            String producerName = ProductsServiceHint.detectProducerName(ProductTestData.getProducts(), 666);
            System.out.printf("Наименование производителя: '%s'", producerName);
        } catch (RuntimeException ex) {
            System.out.printf("Произошла ошибка: '%s'", ex.toString());
        }
    }
}