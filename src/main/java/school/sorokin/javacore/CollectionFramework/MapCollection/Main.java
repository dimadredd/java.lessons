package school.sorokin.javacore.CollectionFramework.MapCollection;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Map<String, Integer> fruitsMap = new HashMap<>();
        fruitsMap.put("Яблоко", 100);
        fruitsMap.put("Банан", 80);
        fruitsMap.put("Апельсин", 120);

        System.out.println("Начальное содержимое HashMap:");
        for (Map.Entry<String, Integer> entry : fruitsMap.entrySet()) {
            System.out.println("Фрукт: " + entry.getKey() + ", Цена: " + entry.getValue());
        }

        fruitsMap.put("Банан", 90);
        System.out.println("\nПосле обновления цены на Банан: ");
        for (Map.Entry<String, Integer> entry : fruitsMap.entrySet()) {
            System.out.println("Фрукт: " + entry.getKey() + ", Цена: " + entry.getValue());
        }

        fruitsMap.remove("Апельсин");
        System.out.println("\nПосле удаления Апельсина: ");
        for (Map.Entry<String, Integer> entry : fruitsMap.entrySet()) {
            System.out.println("Фрукт: " + entry.getKey() + ", Цена: " + entry.getValue());
        }
    }
}
