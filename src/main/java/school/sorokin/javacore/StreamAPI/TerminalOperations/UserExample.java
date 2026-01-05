package school.sorokin.javacore.StreamAPI.TerminalOperations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserExample {
    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User("Karina", 26),
                new User("Dima", 36),
                new User("Egor", 76),
                new User("Karina", 26),
                new User("Paul", 23),
                new User("Georg", 29),
                new User("Charley", 32),
                new User("Egor", 76),
                new User("Georg", 29)
        );

        List<String> result = users.stream()
                .filter(user -> user.getAge() > 25)
                .map(User::getName)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Отсортированный список: " + result);

        int totalAge = users.stream()
                .map(User::getAge)
                .reduce(0, (a, b) -> a + b);
        System.out.println("Общий возраст: " + totalAge);

        Optional<Integer> minAge = users.stream()
                .map(User::getAge)
                .reduce(Integer::min);
        minAge.ifPresent(age -> System.out.println("Минимальный возраст: " + age));
    }
}
