package school.sorokin.javacore.FinalTasks.StreamFinalTask;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

//      Набор продуктов
        Product p1 = new Product(1L, "Alphabet", "Books", BigDecimal.valueOf(1200));
        Product p2 = new Product(2L, "Fairy Tales", "Books", BigDecimal.valueOf(950));
        Product p3 = new Product(3L, "Math Workbook", "Books", BigDecimal.valueOf(825));
        Product p4 = new Product(4L, "English Primer", "Books", BigDecimal.valueOf(1000));
        Product t1 = new Product(5L, "Wooden Building Blocks", "Toys", BigDecimal.valueOf(2490));
        Product t2 = new Product(6L, "Toy Car Set", "Toys", BigDecimal.valueOf(1499));
        Product t3 = new Product(7L, "Plush Teddy Bear", "Toys", BigDecimal.valueOf(1850));
        Product t4 = new Product(8L, "Educational Puzzle", "Toys", BigDecimal.valueOf(1175));
        Product t5 = new Product(9L, "Remote Control Car", "Toys", BigDecimal.valueOf(3999));

//      Заказы
        Order o1 = new Order(1L, LocalDate.of(2021, 2, 1), LocalDate.of(2021, 2, 5), "DELIVERED", Set.of(p1, t1));
        Order o2 = new Order(2L, LocalDate.of(2021, 2, 10), LocalDate.of(2021, 2, 15), "SHIPPED", Set.of(p2, p4));
        Order o3 = new Order(3L, LocalDate.of(2021, 2, 20), LocalDate.of(2021, 2, 25), "PAID", Set.of(t2, t4));
        Order o4 = new Order(4L, LocalDate.of(2021, 3, 1), LocalDate.of(2021, 3, 6), "NEW", Set.of(p3));
        Order o5 = new Order(5L, LocalDate.of(2021, 3, 14), LocalDate.of(2021, 3, 18), "DELIVERED", Set.of(p4, t3));
        Order o6 = new Order(6L, LocalDate.of(2021, 3, 15), LocalDate.of(2021, 3, 20), "CANCELLED", Set.of(t5));
        Order o7 = new Order(7L, LocalDate.of(2021, 3, 25), LocalDate.of(2021, 3, 30), "PAID", Set.of(p1, p2, p3));
        Order o8 = new Order(8L, LocalDate.of(2021, 4, 1), LocalDate.of(2021, 4, 6), "SHIPPED", Set.of(t1, t2, t4));
        Order o9 = new Order(9L, LocalDate.of(2021, 4, 5), LocalDate.of(2021, 4, 10), "NEW", Set.of(p4, t3));
        Order o10 = new Order(10L, LocalDate.of(2021, 4, 10), LocalDate.of(2021, 4, 15), "DELIVERED", Set.of(p4, t5));

//      5 клиентов
        Customer c1 = new Customer(1L, "John", 1L, Set.of(o1, o2, o3, o4, o5));
        Customer c2 = new Customer(2L, "Alice", 2L, Set.of(o2, o3, o6, o7, o8));
        Customer c3 = new Customer(3L, "Bob", 1L, Set.of(o1, o5, o7, o9, o10));
        Customer c4 = new Customer(4L, "Emma", 3L, Set.of(o3, o4, o8, o9, o10));
        Customer c5 = new Customer(5L, "Michael", 2L, Set.of(o1, o2, o6, o9, o10));

        List<Customer> customers = List.of(c1, c2, c3, c4, c5);


//      1. Получите список продуктов из категории "Books" с ценой более 100.
        List<Product> booksOver100 = customers.stream()
                .flatMap(c -> c.getOrders().stream())
                .flatMap(o -> o.getProducts().stream())
                .filter(p -> "Books".equals(p.getCategory()))
                .filter(p -> p.getPrice().compareTo(BigDecimal.valueOf(100)) > 0)
                .distinct()
                .toList();

        System.out.println("1) Книги дороже 100р: ");
        booksOver100.forEach(System.out::println);

//      2. Получите список заказов с продуктами из категории "Children's products".
        List<Order> childrenOrders = customers.stream()
                .flatMap(c -> c.getOrders().stream())
                .filter(o -> o.getProducts().stream()
                        .anyMatch(p -> "Children's products".equals(p.getCategory())))
                .distinct()
                .toList();

        System.out.println("\n2) Заказы с продуктами из категории \"Children's products\": ");
        if (childrenOrders.isEmpty()) {
            System.out.println("Категория Children's products пуста.");
        } else {
            childrenOrders.forEach(System.out::println);
        }

//      3. Получите список продуктов из категории "Toys" и примените скидку 10% и получите сумму всех продуктов.
        BigDecimal toysSumWithDiscount = customers.stream()
                .flatMap(c -> c.getOrders().stream())
                .flatMap(o -> o.getProducts().stream())
                .filter(p -> "Toys".equals(p.getCategory()))
                .map(p -> p.getPrice().multiply(BigDecimal.valueOf(0.9))) // -10%
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        System.out.println("\n3) Сумма категории \"Toys\" со скидкой 10%: ");
        System.out.println(toysSumWithDiscount);

//      4. Получите список продуктов, заказанных клиентом второго уровня между 01-фев-2021 и 01-апр-2021.
        LocalDate from = LocalDate.of(2021, 2, 1);
        LocalDate to   = LocalDate.of(2021, 4, 1);

        List<Product> level2ProductsInRange = customers.stream()
                .filter(c -> c.getLevel() == 2L)
                .flatMap(c -> c.getOrders().stream())
                .filter(o -> !o.getOrderDate().isBefore(from) && !o.getOrderDate().isAfter(to))
                .flatMap(o -> o.getProducts().stream())
                .distinct()
                .toList();

        System.out.println("\n4) Список продуктов, заказанных клиентом второго уровня между 01-фев-2021 и 01-апр-2021:");
        level2ProductsInRange.forEach(System.out::println);

//      5. Получите топ 2 самые дешевые продукты из категории "Books".
        List<Product> cheapest2Books = customers.stream()
                .flatMap(c -> c.getOrders().stream())
                .flatMap(o -> o.getProducts().stream())
                .filter(p -> "Books".equals(p.getCategory()))
                .distinct()
                .sorted(Comparator.comparing(Product::getPrice))
                .limit(2)
                .toList();

        System.out.println("\n5) Топ 2 самые дешевые продукты из категории \"Books\":");
        cheapest2Books.forEach(System.out::println);

//      6. Получите 3 самых последних сделанных заказа.
        List<Order> last3Orders = customers.stream()
                .flatMap(c -> c.getOrders().stream())
                .distinct()
                .sorted(Comparator.comparing(Order::getOrderDate).reversed())
                .limit(3)
                .toList();

        System.out.println("\n6) 3 самых последних сделанных заказа:");
        last3Orders.forEach(System.out::println);

//      7. Получите список заказов, сделанных 15-марта-2021, выведите id заказов в консоль и затем верните список их продуктов.
        List<Product> productsFromOrdersOnDate = customers.stream()
                .flatMap(c -> c.getOrders().stream())
                .filter(o -> o.getOrderDate().equals(LocalDate.of(2021,3,15)))
                .peek(o -> System.out.println(o.getId()))
                .flatMap(o -> o.getProducts().stream())
                .distinct()
                .toList();

        System.out.println("\n7) Список заказов, сделанных 15-марта-2021, id заказа и список продуктов:");
        productsFromOrdersOnDate.forEach(System.out::println);

//      8. Рассчитайте общую сумму всех заказов, сделанных в феврале 2021.
        BigDecimal feb2021Total = customers.stream()
                .flatMap(c -> c.getOrders().stream())
                .filter(o -> o.getOrderDate().getYear() == 2021 && o.getOrderDate().getMonth() == Month.FEBRUARY)
                .map(o -> o.getProducts().stream()
                        .map(Product::getPrice)
                        .reduce(BigDecimal.ZERO, BigDecimal::add))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        System.out.println("\n8) Общая сумма всех заказов, сделанных в феврале 2021:");
        System.out.println(feb2021Total);

//      9. Рассчитайте средний платеж по заказам, сделанным 14-марта-2021.
        BigDecimal avgPayment = customers.stream()
                .flatMap(c -> c.getOrders().stream())
                .filter(o -> o.getOrderDate().equals(LocalDate.of(2021, 3, 14)))
                .map(o -> o.getProducts().stream()
                        .map(Product::getPrice)
                        .reduce(BigDecimal.ZERO, BigDecimal::add))
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(),
                        totals -> {
                            if (totals.isEmpty()) return BigDecimal.ZERO;
                            BigDecimal sum = totals.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
                            return sum.divide(BigDecimal.valueOf(totals.size()), 2, RoundingMode.HALF_UP);
                        }
                ));
        System.out.println("\n9) Средний платеж по заказам, сделанный 14-марта-2021:");
        System.out.println(avgPayment);

//      10. Получите набор статистических данных (сумма, среднее, максимум, минимум, количество) для всех продуктов категории "Книги".
        DoubleSummaryStatistics stats = customers.stream()
                .flatMap(c -> c.getOrders().stream())
                .flatMap(o -> o.getProducts().stream())
                .filter(p -> "Books".equals(p.getCategory()))
                .map(Product::getPrice)
                .mapToDouble(BigDecimal::doubleValue)
                .summaryStatistics();

        System.out.println("\n10) Статистика для категории \"Книги\":");
        System.out.println("кол-во: " + stats.getCount());
        System.out.println("сумма: " + stats.getSum());
        System.out.println("среднее: " + stats.getAverage());
        System.out.println("минимум: " + stats.getMin());
        System.out.println("максимум: " + stats.getMax());

//      11. Получите данные Map<Long, Integer> key - id заказа, value - кол-во товаров в заказе
        Map<Long, Integer> orderIdToCount = customers.stream()
                .flatMap(c -> c.getOrders().stream())
                .distinct()
                .collect(Collectors.toMap(
                        Order::getId,
                        o -> o.getProducts().size()
                ));

        System.out.println("\n11) Данные о заказах:");
        orderIdToCount.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(e -> System.out.println("id заказа: " + e.getKey() + ", кол-во товаров: " + e.getValue()));


//      12. Создайте Map<Customer, List<Order>> key - покупатель, value - список его заказов
        Map<Customer, List<Order>> customerOrders = customers.stream()
                .collect(Collectors.toMap(
                        Function.identity(),
                        c -> new ArrayList<>(c.getOrders())
                ));

        System.out.println("\n12) Список заказов по покупателям:");
        customerOrders.forEach((customer, orders) -> {
            System.out.println("Покуатель: " + customer.getName());
            orders.forEach(o -> System.out.println(" " + o));
        });

//      13. Создайте Map<Order, Double> key - заказ, value - общая сумма продуктов заказа.
        Map<Order, Double> orderToTotal = customers.stream()
                .flatMap(c -> c.getOrders().stream())
                .distinct()
                .collect(Collectors.toMap(
                        Function.identity(),
                        o -> o.getProducts().stream()
                                .map(Product::getPrice)
                                .mapToDouble(BigDecimal::doubleValue)
                                .sum()
                ));

        System.out.println("\n13) Заказ, общая сумма заказов:");
        orderToTotal.entrySet().stream()
                .sorted(Comparator.comparing(e -> e.getKey().getId()))
                .forEach(e -> System.out.println("Id: " + e.getKey().getId() + ", сумма: " + e.getValue()));


//      14. Получите Map<String, List<String>> key - категория, value - список названий товаров в категории
        Map<String, List<String>> categoryToNames = customers.stream()
                .flatMap(c -> c.getOrders().stream())
                .flatMap(o -> o.getProducts().stream())
                .distinct()
                .collect(Collectors.groupingBy(
                        Product::getCategory,
                        Collectors.mapping(Product::getName, Collectors.toList())
                ));

        System.out.println("\n14) Map<Category, List<ProductNames>>:");
        categoryToNames.forEach((category, names) -> System.out.println(category + ": " + names));


//      15. Получите Map<String, Product> самый дорогой продукт по каждой категории.
        Map<String, Product> mostExpensiveByCategory = customers.stream()
                .flatMap(c -> c.getOrders().stream())
                .flatMap(o -> o.getProducts().stream())
                .distinct()
                .collect(Collectors.groupingBy(
                        Product::getCategory,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparing(Product::getPrice)),
                                Optional::get
                        )
                ));
        System.out.println("\n15) Самый дорогой продукт по каждой категории:");
        mostExpensiveByCategory.forEach((category, product) ->
                System.out.println(category + " -> " + product));
    }
}
