package school.sorokin.javacore.Testing.Testing_task2;

public class OrderService {
    private final PaymentService paymentService;
    private final NotificationService notificationService;

    public OrderService(PaymentService paymentService, NotificationService notificationService) {
        this.paymentService = paymentService;
        this.notificationService = notificationService;
    }

    public void createOrder(double amount) {
        System.out.println("Заказ принят");
        try {
            paymentService.pay(amount);
            notificationService.notifyUser("Заказ успешно оплачен. Сумма: " + amount);
        } catch (RuntimeException e) {
            System.out.println("Ошибка оплаты: " + e.getMessage());
        }
    }
}
