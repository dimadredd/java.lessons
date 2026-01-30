package school.sorokin.javacore.Testing.Testing_task1;

public class DiscountCalculator {
    private final DiscountFunction discountFunction =
            (price, discount) -> {
                if (discount <= 0 || discount > 100) {
                    return (double) price;
                }
                return (double) price - (price * discount / 100);
            };

    public double discountCalculator(double price, int discount) {
        return discountFunction.apply(price, discount);
    }
}

