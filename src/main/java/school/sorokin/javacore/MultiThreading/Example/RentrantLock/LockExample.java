package school.sorokin.javacore.MultiThreading.Example.RentrantLock;

import java.util.concurrent.locks.ReentrantLock;

public class LockExample {
    private static int counter = 0;
    private static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            for (int i = 0; i < 10000; i++) {
                increment();
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        // Посмотрим, что получилось
        System.out.println("Final counter value: " + counter);
    }

    private static void increment() {
        lock.lock(); // захватываем блокировку
        try {
            counter++; // критическая секция
        } finally {
            lock.unlock(); // освобождаем блокировку
        }
    }
}