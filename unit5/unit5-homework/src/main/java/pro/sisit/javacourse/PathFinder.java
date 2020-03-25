package pro.sisit.javacourse;

import pro.sisit.javacourse.optimal.DeliveryTask;
import pro.sisit.javacourse.optimal.Route;
import pro.sisit.javacourse.optimal.RouteType;
import pro.sisit.javacourse.optimal.Transport;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PathFinder {

    /**
     * Возвращает оптимальный транспорт для переданной задачи.
     * Если deliveryTask равна null, то оптимальеый транспорт тоже равен null.
     * Если список transports равен null, то оптимальеый транспорт тоже равен null.
     */
    public Transport getOptimalTransport(DeliveryTask deliveryTask, List<Transport> transports) {
        // ToDo: realize me!
        if (deliveryTask == null || transports == null) {
            return null;
        }
        Map<RouteType, BigDecimal> lengthOfRouteType = deliveryTask.getRoutes().stream()
                .collect(Collectors.toMap(Route::getType, Route::getLength));
        return transports.stream()
                .filter(transport -> transport.getVolume().compareTo(deliveryTask.getVolume()) >= 0)
                .filter(transport -> lengthOfRouteType.containsKey(transport.getType()))
                .min(Comparator.comparing(transport ->
                        transport.getPrice().multiply(lengthOfRouteType.get(transport.getType()))))
                .orElse(null);
    }
}
