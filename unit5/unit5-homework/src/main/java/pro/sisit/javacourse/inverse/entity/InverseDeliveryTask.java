package pro.sisit.javacourse.inverse.entity;

import lombok.Data;
import pro.sisit.javacourse.optimal.entity.Transport;
import pro.sisit.javacourse.optimal.entity.DeliveryTask;

import java.util.List;

/**
 * Обратная задача по доставке груза
 */
@Data
public class InverseDeliveryTask {

    /**
     * Список задач по доставке груза, которые могли быть решены
     */
    private final List<DeliveryTask> tasks;

    /**
     * Виды транспорта, которые могли быть использованы для решения задач доставки
     */
    private final List<Transport> transports;

    /**
     * Диапазон цены решенной задачи
     */
    private final BigDecimalRange priceRange;


}
