package school.sorokin.javacore.FinalTasks.Testing_finalTask;

public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public String processOrder(Order order) {

        if (order == null) return "Order processing failed";

        try {
            orderRepository.saveOrder(order);
            return "Order processed successfully";

        } catch (Exception e) {
            return "Order processing failed";
        }
    }

    public double calculateTotal(int id) {
        if (id <= 0) throw new IllegalArgumentException("Invalid id: " + id);
        return orderRepository.getOrderById(id)
                .map(o -> o.getTotalPrice(o.getQuantity(), o.getUnitPrice()))
                .orElseThrow(() -> new IllegalArgumentException("Order not found: " + id));
    }
}
