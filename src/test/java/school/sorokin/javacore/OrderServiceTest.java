package school.sorokin.javacore;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
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


    @BeforeAll
    static void initAll() {
        System.out.println("Start testing...");
    }

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
//       Given
        dummyOrder = new Order(1, "Phone", 3, 1200.00);
        when(orderRepositoryMock.saveOrder(dummyOrder)).thenReturn(dummyOrder.getId());

//        When
        String result = orderService.processOrder(dummyOrder);

//        Then
        assertEquals("Order processed successfully", result);

//        Проверяем: saveOrder вызывается 1 раз с нужным заказом
        verify(orderRepositoryMock, times(1)).saveOrder(dummyOrder);
        verifyNoMoreInteractions(orderRepositoryMock);
    }

    @Test
    void processOrderFailedWhenRepositoryThrowsException() {
//        Diven
        dummyOrder = new Order(1, "Phone", 3, 1200.00);
        when(orderRepositoryMock.saveOrder(dummyOrder)).thenThrow(new RuntimeException("DB error"));

//        When
        String result = orderService.processOrder(dummyOrder);

//        Then
        assertEquals("Order processing failed", result);

//        Проверяем: saveOrder вызывается 1 раз с нужным заказом
        verify(orderRepositoryMock, times(1)).saveOrder(dummyOrder);
        verifyNoMoreInteractions(orderRepositoryMock);
    }

    @Test
    void processOrderFailedWhenOrderIsNull() {

//        When
        String result = orderService.processOrder(null);

//        Then
        assertEquals("Order processing failed", result);

//        Проверяем: saveOrder вызывается 1 раз с нужным заказом
        verifyNoInteractions(orderRepositoryMock);
    }


    @Test
    void calculateTotalSuccessWhenReturnsTotalAmountFromOrder() {
//        Given
        dummyOrder = new Order(1, "Phone", 3, 100.00);
        when(orderRepositoryMock.getOrderById(dummyOrder.getId())).thenReturn(Optional.ofNullable(dummyOrder));

//        When
        double result = orderService.calculateTotal(dummyOrder.getId());

//        Then
        assertEquals(300.0, result);

//        Проверяем: saveOrder вызывается 1 раз с нужным заказом
        verify(orderRepositoryMock, times(1)).getOrderById(dummyOrder.getId());
        verifyNoMoreInteractions(orderRepositoryMock);
    }

    @Test
    void calculateTotalWhenOrderNotFoundException() {
//        Given
        dummyOrder = new Order(1, "Phone", 3, 1200.00);
        when(orderRepositoryMock.getOrderById(dummyOrder.getId())).thenReturn(Optional.empty());

//        When
        assertThrows(IllegalArgumentException.class, () -> orderService.calculateTotal(dummyOrder.getId()));

//        Проверяем: saveOrder вызывается 1 раз с нужным заказом
        verify(orderRepositoryMock, times(1)).getOrderById(dummyOrder.getId());
        verifyNoMoreInteractions(orderRepositoryMock);
    }

    @Test
    void calculateTotalWhenPriceOrQuantityIsZero() {
//        Given
        dummyOrder = new Order(1, "Phone", 0, 1200);
        when(orderRepositoryMock.getOrderById(dummyOrder.getId())).thenReturn(Optional.ofNullable(dummyOrder));

//        When
        double result = orderService.calculateTotal(dummyOrder.getId());

//        When
        assertEquals(0.0, result);

//        Проверяем: saveOrder вызывается 1 раз с нужным заказом
        verify(orderRepositoryMock, times(1)).getOrderById(dummyOrder.getId());
        verifyNoMoreInteractions(orderRepositoryMock);
    }

    @Test
    void calculateTotalShouldThrowExceptionWhenIdIsInvalid() {
//        When
        assertThrows(IllegalArgumentException.class, () -> orderService.calculateTotal(-1));

//        Проверяем: saveOrder вызывается 1 раз с нужным заказом
        verifyNoMoreInteractions(orderRepositoryMock);
    }
}
