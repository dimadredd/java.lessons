package school.sorokin.javacore.MultiThreading.Task1;

public class ThreadTest {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Thread thread = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();

                System.out.println("Поток: 1 " + "счетчик: " + counter.getValue());
            }
        });

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();

                System.out.println("Поток: 2 " + "счетчик: " + counter.getValue());
            }
        });

        thread.start();
        thread1.start();

        thread.join();
        thread1.join();

        System.out.println("\nОжидаем: 2000\nФакт: " + counter.getValue());
    }
}
