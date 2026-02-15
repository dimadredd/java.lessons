package school.sorokin.javacore.FinalTasks.Testing_finalTask;

import java.util.Optional;

public interface OrderRepository {
    int saveOrder(Order order);
    Optional<Order>getOrderById(int id);
}
