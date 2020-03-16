package pro.sisit.javacourse;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Сервис для работы с продуктами
 */
public class ProductsService {

    public static void main(String[] args) {
    }

    /**
     * Фильтрует переданный список продуктов по переданному типу.
     */
    public static List<Product> filterByType(List<Product> products, ProductType type) {
        return null;
    }

    /**
     * Получает отсортированный список уникальных производителей переданных продуктов.
     */
    public static List<Producer> getUniqueSortedProducers(List<Product> products) {
        return null;
    }

    /**
     * Рассчитывает долю НДС для списка продуктов.
     * Долю НДС для одного продукта считаем по формуле: цена * 20 / 120,
     * при этом при делении используется банковское округление.
     */
    public static BigDecimal getTotalTax(List<Product> products) {
        return null;
    }

    /**
     * Получает наименование производителя продукта по переданному продукту.
     * Вспомогательный метод.
     */
    public static String extractProductProducerName(Product product) {
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
    public static String getProductProducerNameByIdUnsafe(List<Product> products, long id) {
        return null;
    }

    /**
     * Выполняет поиск продукта в переданном списке по переданному идентификатору продукта
     */
    public static Optional<Product> findProductById(List<Product> products, long id) {
        return null;
    }

    /**
     * Определяет наименование производителя продукта по переданному идентификатору продукта.
     * Если продукт не найден выбросит RuntimeException с сообщением
     * Товар с идентификатором '%s' не найден
     */
    public static String getProductProducerNameById(List<Product> products, long id) {
        return null;
    }

    /**
     * Определяет наименование производителя продукта по переданному идентификатору продукта
     * Если продукт не найден вернет 'Неизвестный производитель'.
     */
    public static String getProductProducerNameByIdSoft(List<Product> products, long id) {
        return null;
    }
}