package school.sorokin.javacore.CollectionFramework.EqualsAndHashCodeContract;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Map<Product, String> productInfo = new HashMap<>();

        Product prod1 = new Product(1, "Computer", 1500.00);
        Product prod2 = new Product(1, "Phone", 700.00);
        Product prod3 = new Product(2, "Laptop", 2000.00);
        Product prod4 = new Product(3, "Monitor",150.00 );

        productInfo.put(prod1, "Computer");
        productInfo.put(prod2, "Phone");
        productInfo.put(prod3, "Laptop");
        productInfo.put(prod4, "Monitor");

        System.out.println("HashMap size: " + productInfo.size());
        System.out.println("\nСодержимое HashMap: ");
        for (Map.Entry<Product, String> entry : productInfo.entrySet()){
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }
}
