package school.sorokin.javacore.CollectionFramework.SetCollection;

import java.util.*;

public class RemoveDuplicates {
    public static void main(String[] args) {
        /** Создаем список фруктов
         * Преобразуем список в Set, удаляя дубликаты
         * Преобразуем список в отсортированный список в порядке добавления
         */
        List<String> list = new ArrayList<>();

        list.add("Яблоко");
        list.add("Апельсин");
        list.add("Манго");
        list.add("Апельсин");
        list.add("Манго");
        list.add("Киви");
        list.add("Виноград");

        System.out.println("Список фруктов: " + list);

        Set<String> sortedList = new HashSet<>(list);
        System.out.println("Множество без дубликатов (порядок не гарантирован): " + sortedList);

        Set<String> linkedHashSet = new LinkedHashSet<>(list);
        System.out.println("Список без дубликатов (порядок добавления сохранён): " + linkedHashSet);
    }
}
