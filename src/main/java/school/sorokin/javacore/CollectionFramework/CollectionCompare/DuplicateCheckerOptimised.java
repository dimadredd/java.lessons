package school.sorokin.javacore.CollectionFramework.CollectionCompare;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DuplicateCheckerOptimised {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        // Заполнение списка числами от 0 до 100000 с дублированием одного значения
        for (int i = 0; i <= 100000; i++) {
            numbers.add(i);
        }
        numbers.add(50000); // Вставляем дубликат

        Set<Integer> numberSet = new HashSet<>(numbers);
        boolean hasDuplicates = numbers.size() != numberSet.size();
        System.out.println("Дубликаты найдены: " + hasDuplicates);
    }
}
