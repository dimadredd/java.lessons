package school.sorokin.javacore.Testing.Testing_task2;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class OrderServiceTest {
    @Test
    void shouldSendNotificationWhenPaymentIsSuccessful() {
        PaymentService paymentServiceMock = mock(PaymentService.class);
        NotificationService notificationServiceMock = mock(NotificationService.class);

        OrderService orderService = new OrderService(paymentServiceMock, notificationServiceMock);

        orderService.createOrder(1000.00);
        verify(paymentServiceMock, times(1)).pay(1000.00);
        verify(notificationServiceMock, times(1)).notifyUser(anyString());
    }

    @Test
    void shouldNotSendNotificationWhenPaymentFails() {
        PaymentService paymentServiceMock = mock(PaymentService.class);
        NotificationService notificationServiceMock = mock(NotificationService.class);

        doThrow(new RuntimeException("Payment failed")).when(paymentServiceMock).pay(1000.00);

        OrderService orderService = new OrderService(paymentServiceMock, notificationServiceMock);

        orderService.createOrder(1000.00);

        verify(paymentServiceMock, times(1)).pay(1000.00);
        verifyNoInteractions(notificationServiceMock);
    }
}