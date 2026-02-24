package school.sorokin.javacore.MultiThreading.Task2;

public class Main {
    static final int THREADS = 10;
    static final int ITERATIONS = 100_000;

    public static void main(String[] args) throws InterruptedException {

//        Counter counter = new SynchronizedCounter();
//        Counter counter = new AtomicCounter();
//        Counter counter = new VolatileCounter();
        Counter counter = new LockCounter();

        Thread[] threads = new Thread[THREADS];

        for (int i = 0; i < THREADS; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < ITERATIONS; j++) {
                    counter.increment();
                }
            });
            threads[i].start();
        }

        for (Thread t : threads) {
            t.join();
        }

        System.out.println("Waiting: " + THREADS * ITERATIONS);
        System.out.println("Value: " + counter.getValue());
    }
}
