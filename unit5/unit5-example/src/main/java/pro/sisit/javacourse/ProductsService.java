package pro.sisit.javacourse;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

/**
 * Сервис для работы с продуктами
 */
public class ProductsService {

    public static void main(String[] args) {
    }

    /**
     * Фильтрует переданный список продуктов по переданному типу список продуктов.
     */
    public static List<Product> filterByType(List<Product> products, ProductType type) {
        return null;
    }

    /**
     * Получает отсортированный список уникальных производителей переданных продуктов.
     */
    public static List<Producer> getUniqueProducers(List<Product> products) {
        return null;
    }

    /**
     * Рассчитвает долю НДС для списка продуктов.
     * Долю НДС для одного продукта считаем по формуле: цена * 20 / 120,
     * при этом при делении используется банковское округление.
     */
    public static BigDecimal getTotalTax(List<Product> products) {
        return null;
    }

    /**
     * Выполняет поиск продукта в переданном списке по переданному идентификатору продукта.
     * Если продукт найден, то вернет его, иначе вернет null.
     * Метод - в императивном стиле без использования стримов.
     */
    public static Product findProductByIdUnsafe(List<Product> products, long id) {
        return null;
    }

    /**
     * Определяет наименование производителя продукта по переданному идентификатору продукта
     */
    public static String detectProducerNameUnsafe(List<Product> products, long id) {
        return null;
    }

    /**
     * Выполняет поиск продукта в переданном списке по переданному идентификатору продукта
     */
    public static Optional<Product> findProductById(List<Product> products, long id) {
        return null;
    }

    /**
     * Определяет наименование производителя продукта по переданному идентификатору продукта
     * Если продукт не найден вернет 'Неизвестный производитель'.
     */
    public static String detectProducerNameSoft(List<Product> products, long id) {
        return null;
    }

    /**
     * Получает продукт в переданном списке по переданному идентификатору продукта.
     * Если продукт найден, то вернет его, иначе выбросит RuntimeException с сообщением
     * Товар с идентификатором '%s' не найден
     */
    public static Product getProductById(List<Product> products, long id) {
        return null;
    }

    /**
     * Определяет наименование производителя продукта по переданному идентификатору продукта.
     * Если продукт не найден выбросит RuntimeException с сообщением
     * Товар с идентификатором '%s' не найден
     */
    public static String detectProducerName(List<Product> products, long id) {
        return null;
    }

    /**
     * Получает наименование производителя продукта по переданному продукту
     */
    public static String getProducerNameByProduct(Product product) {
        return null;
    }
}