package school.sorokin.javacore.FinalTasks.Multithreading;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public class DataProcessor {

    private ExecutorService service;
    private AtomicInteger taskCounter = new AtomicInteger(0);
    private AtomicInteger activeTask = new AtomicInteger(0);

    private Map<String, Integer> results = new HashMap<>();
    private Object resultLock = new Object();

//    public DataProcessor() {
//        this.service = Executors.newSingleThreadExecutor();
//    }

    public DataProcessor() {
        this.service = Executors.newFixedThreadPool(10);
    }

    public String submitTask(List<Integer> numbers) {
        String taskName = "Task: " + taskCounter.incrementAndGet();
        activeTask.incrementAndGet();

        CalculateSumTask task = new CalculateSumTask(numbers, taskName);

        Future<Integer> future = service.submit(task);

        service.submit(() -> {
            try {
                Integer sum = future.get();

                synchronized (resultLock) {
                    results.put(taskName, sum);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                activeTask.decrementAndGet();
            }
        });

        return taskName;
    }

    public Optional<Integer> getResult(String taskName) {
        synchronized (resultLock) {
            return Optional.ofNullable(results.get(taskName));
        }
    }

    public int getActiveTask() {
        return activeTask.get();
    }

    public void shutdown() {
        service.shutdown();
    }
}



