package school.sorokin.javacore.Testing.Testing_task1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiscountCalculatorTest {

    @Test
    void shouldApplyDiscountForValidPercentage() {
        DiscountCalculator calculator = new DiscountCalculator();
        double result = calculator.discountCalculator(100.00, 10);
        assertEquals(90.00, result);
    }

    @Test
    void shouldNotChangePriceWhenDiscountIsZero() {
        DiscountCalculator calculator = new DiscountCalculator();
        double result = calculator.discountCalculator(100.00, 0);
        assertEquals(100.00, result);
    }

    @Test
    void shouldReturnZeroWhenDiscountIsHundred() {
        DiscountCalculator calculator = new DiscountCalculator();
        double result = calculator.discountCalculator(100.00, 100);
        assertEquals(0.00, result);
    }

    @Test
    void shouldNotChangePriceWhenDiscountIsNegative() {
        DiscountCalculator calculator = new DiscountCalculator();
        double result = calculator.discountCalculator(100.00, -5);
        assertEquals(100.00, result);
    }

    @Test
    void shouldNotChangePriceWhenDiscountIsGreaterThanHundred() {
        DiscountCalculator calculator = new DiscountCalculator();
        double result = calculator.discountCalculator(100.00, 150);
        assertEquals(100.00, result);
    }

    @Test
    void shouldReturnZeroWhenPriceIsZero() {
        DiscountCalculator calculator = new DiscountCalculator();
        double result = calculator.discountCalculator(0.00, 20);
        assertEquals(0.00, result);
    }
}
