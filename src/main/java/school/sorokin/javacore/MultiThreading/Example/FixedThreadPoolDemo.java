package school.sorokin.javacore.MultiThreading.Example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class FixedThreadPoolDemo {
    public static void main(String[] args) throws InterruptedException {
        // Генерируем список задач
        List<Runnable> tasks = new ArrayList<>();
        for (int i = 1; i <= 100_000; i++) {
            final int taskNumber = i; // нужно сохранить переменную в final для лямбды
            tasks.add(() -> System.out.println("Задача №" + taskNumber));
        }

        // Создаём пул на 10 потоков
        ExecutorService executor = Executors.newFixedThreadPool(10);

        // Передаём все задачи в очередь пула
        for (Runnable task : tasks) {
            executor.execute(task);
        }

        // Завершаем прием новых задач и ждём, когда все текущие выполнятся
        executor.shutdown();
        while (!executor.awaitTermination(1, TimeUnit.SECONDS)) {
            // Ждём окончания выполнения задач
        }

        System.out.println("Все задачи выполнены.");
    }
}
