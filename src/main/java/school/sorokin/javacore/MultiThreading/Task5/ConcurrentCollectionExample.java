package school.sorokin.javacore.MultiThreading.Task5;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConcurrentCollectionExample {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> list = new CopyOnWriteArrayList<>();

        Thread writer = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                list.add(i);
            }
        });

        Thread reader = new Thread(() -> {
            for (Integer i : list) {
                System.out.println("Reader: " + i);
            }
        });

        writer.start();
        reader.start();

        writer.join();
        reader.join();

        System.out.println("List size: " + list.size());
    }
}
