package school.sorokin.javacore;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import school.sorokin.javacore.FinalTasks.Testing_finalTask.Order;
import school.sorokin.javacore.FinalTasks.Testing_finalTask.OrderRepository;
import school.sorokin.javacore.FinalTasks.Testing_finalTask.OrderService;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class OrderServiceTest {
    private Order dummyOrder;
    private OrderService orderService;
    private OrderRepository orderRepositoryMock;


    @AfterAll
    static void tearDownAll() {
        System.out.println("Testing completed!");
    }

    @BeforeEach
    void init() {
        orderRepositoryMock = mock(OrderRepository.class);
        orderService = new OrderService(orderRepositoryMock);
    }

    @Test
    void processOrderSuccessWhenRepositoryReturnsValidId() {

        dummyOrder = new Order(1, "Phone", 3, 1200.00);
        when(orderRepositoryMock.saveOrder(dummyOrder)).thenReturn(dummyOrder.getId());

        String result = orderService.processOrder(dummyOrder);

        assertEquals("Order processed successfully", result);

        verify(orderRepositoryMock, times(1)).saveOrder(dummyOrder);
        verifyNoMoreInteractions(orderRepositoryMock);
    }

    @Test
    void processOrderFailedWhenRepositoryThrowsException() {
        dummyOrder = new Order(1, "Phone", 3, 1200.00);
        when(orderRepositoryMock.saveOrder(dummyOrder)).thenThrow(new RuntimeException("DB error"));

        String result = orderService.processOrder(dummyOrder);
        assertEquals("Order processing failed", result);
        verify(orderRepositoryMock, times(1)).saveOrder(dummyOrder);
        verifyNoMoreInteractions(orderRepositoryMock);
    }

    @Test
    void processOrderFailedWhenOrderIsNull() {
        String result = orderService.processOrder(null);
        assertEquals("Order processing failed", result);
        verifyNoInteractions(orderRepositoryMock);
    }


    @Test
    void calculateTotalSuccessWhenReturnsTotalAmountFromOrder() {
        dummyOrder = new Order(1, "Phone", 3, 100.00);
        when(orderRepositoryMock.getOrderById(dummyOrder.getId())).thenReturn(Optional.ofNullable(dummyOrder));
        double result = orderService.calculateTotal(dummyOrder.getId());
        assertEquals(300.0, result);
        verify(orderRepositoryMock, times(1)).getOrderById(dummyOrder.getId());
        verifyNoMoreInteractions(orderRepositoryMock);
    }

    @Test
    void calculateTotalWhenOrderNotFoundException() {
        dummyOrder = new Order(1, "Phone", 3, 1200.00);
        when(orderRepositoryMock.getOrderById(dummyOrder.getId())).thenReturn(Optional.empty());
        assertThrows(IllegalArgumentException.class, () -> orderService.calculateTotal(dummyOrder.getId()));
        verify(orderRepositoryMock, times(1)).getOrderById(dummyOrder.getId());
        verifyNoMoreInteractions(orderRepositoryMock);
    }

    @Test
    void calculateTotalWhenPriceOrQuantityIsZero() {
        dummyOrder = new Order(1, "Phone", 0, 1200);
        when(orderRepositoryMock.getOrderById(dummyOrder.getId())).thenReturn(Optional.ofNullable(dummyOrder));

        double result = orderService.calculateTotal(dummyOrder.getId());
        assertEquals(0.0, result);
        verify(orderRepositoryMock, times(1)).getOrderById(dummyOrder.getId());
        verifyNoMoreInteractions(orderRepositoryMock);
    }

    @Test
    void calculateTotalShouldThrowExceptionWhenIdIsInvalid() {
        assertThrows(IllegalArgumentException.class, () -> orderService.calculateTotal(-1));
    }
}
