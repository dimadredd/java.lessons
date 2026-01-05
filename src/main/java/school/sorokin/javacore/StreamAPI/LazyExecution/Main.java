package school.sorokin.javacore.StreamAPI.LazyExecution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(new Integer[20]);

        for (int i = 0; i < numbers.size(); i++){
            numbers.set(i, i + 1);
        }

        System.out.println(numbers);

        //Фильруем только четные числа и возводим в квадрат + замеряем время stream vs цикл.
        long startStream = System.nanoTime();
        List<Integer> result = numbers.stream()
                .filter(num -> num % 2 == 0)
                .map(n -> n * n)
                .collect(Collectors.toList());
        long endStream = System.nanoTime();

        System.out.print("Четные числа в квадрате: ");
        result.forEach(n -> System.out.print(n + " "));

        List<Integer> loopList = new ArrayList<>();
        long startLoop = System.nanoTime();
        for (Integer num : numbers){
            if (num % 2 == 0){
                loopList.add(num * num);
            }
        }
        long endLoop = System.nanoTime();

        System.out.println(("\nStream, квадрат чётных за: " + (endStream - startStream) + " нс"));
        System.out.println(("\nЦикл for, квадрат чётных за: " + (endLoop - startLoop) + " нс"));

        //Демонстрация ошибки второго использования стрима
        System.out.print("\nНаш лист: ");
        Stream<Integer> stream = numbers.stream()
                        .filter(n -> n % 2 == 0)
                        .map(n -> n * n);
        stream.forEach(n -> System.out.print(n + " "));

        try {
            stream.forEach(n -> System.out.println(n + " "));
        }catch (IllegalStateException e){
            System.out.println("\nОшибка: " + e.getMessage());
        }
    }
}