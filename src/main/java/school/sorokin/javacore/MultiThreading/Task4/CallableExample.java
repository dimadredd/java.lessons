package school.sorokin.javacore.MultiThreading.Task4;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class CallableExample {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(3);

        List<Callable<String>> tasks = Arrays.asList(
                () -> {Thread.sleep(500); return "Result 1" + Thread.currentThread().getName();},
                () -> {Thread.sleep(500); return "Result 2" + Thread.currentThread().getName();},
                () -> {Thread.sleep(500); return "Result 3" + Thread.currentThread().getName();}
        );

        try {
            List<Future<String>> futures = service.invokeAll(tasks);

            for (Future<String> f : futures) {
                System.out.println("Result: " + f.get());
            }

        }catch (InterruptedException | ExecutionException e){
            e.printStackTrace();
        } finally {
            service.shutdown();
        }
    }
}
