package school.sorokin.javacore.StreamAPI.FundamentalsAndCreate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamBasics {
    public static void main(String[] args) {

        //Из коллекции:
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        List<Integer> streamFromList = list.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("Четные числа: " + streamFromList);

        //Из массива
        String[] namesArray = {"Alice", "Paul", "Bob"};
        Stream<String> streamFromArray = Arrays.stream(namesArray)
                .map(String::toUpperCase);
        streamFromArray.forEach(System.out::println);

        //из отдельных элементов
        Stream<Integer> streamOfIntegers = Stream.of(10, 20, 60, 105, -5)
                .filter(num -> num >= 0);
        streamOfIntegers.forEach(num -> System.out.print(num + " "));
        System.out.println();

        //из генератора Stream.generate()
        Stream<Double> randomNumbers = Stream.generate(Math::random);
        randomNumbers.limit(10).forEach(num -> System.out.print(num + " "));
        System.out.println();

        //из генератора Stream.iterate()
        Stream<Integer> evenNums = Stream.iterate(10, n -> n + 2);
        evenNums.limit(10).forEach(n -> System.out.print(n + " "));

    }
}
