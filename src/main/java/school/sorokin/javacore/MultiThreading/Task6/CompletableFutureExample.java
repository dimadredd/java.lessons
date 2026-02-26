package school.sorokin.javacore.MultiThreading.Task6;

import java.util.concurrent.CompletableFuture;


public class CompletableFutureExample {

    // ШАГ 1: получаем исходные данные (имитация задержки)
    private static CompletableFuture<String> getDataAsync() {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Шаг 1: получаем данные...");
            sleep(500);
            return "10"; // исходные данные (строка)
        });
    }

    // ШАГ 2: обрабатываем данные (можем сымитировать ошибку)
    private static CompletableFuture<Integer> processDataAsync(String data) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Шаг 2: обрабатываем данные = " + data);
            sleep(500);

            // ИМИТАЦИЯ ОШИБКИ:
            // допустим, если data = "10", то кидаем исключение
            if ("10".equals(data)) {
                throw new RuntimeException("Ошибка на шаге 2: data = 10");
            }

            // если ошибки нет — преобразуем в число и умножаем
            int value = Integer.parseInt(data);
            return value * 2;
        });
    }

    // ШАГ 3: выводим результат
    private static void printResult(Integer result) {
        System.out.println("Шаг 3: результат = " + result);
    }

    private static void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {

        CompletableFuture<Void> chain =
                getDataAsync()
                        // связываем шаг 1 -> шаг 2
                        .thenCompose(data -> processDataAsync(data))

                        // связываем шаг 2 -> шаг 3
                        .thenAccept(result -> printResult(result))

                        // ОБРАБОТКА ОШИБКИ В ЦЕПОЧКЕ
                        .exceptionally(ex -> {
                            System.out.println("Поймали ошибку: " + ex.getMessage());
                            return null;
                        });

        // Важно: get() в середине цепочки не используем.
        // Просто даём времени async-задачам выполниться
        sleep(2000);
        System.out.println("main завершился");
    }
}
