package school.sorokin.javacore.MultiThreading.Example.VolatileVsAtomicInteger;

import java.util.concurrent.atomic.AtomicInteger;

public class CounterComparison {
//    рассмотрим для сравнения
//     static volatile int volatileCounter = 0;
    private static AtomicInteger atomicCounter = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        // для эксперимента можно раскомментировать volatileCounter
        // и закомментировать atomicCounter, чтобы увидеть разницу

        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                // при volatile могут возникнуть проблемы с атомарностью
                // count++ может "потерять" некоторые инкременты
                // при AtomicInteger incrementAndGet() будет атомарным

//                 volatileCounter++;
                atomicCounter.incrementAndGet();
            }).start();
        }

        // Дадим потокам время на выполнение
        Thread.sleep(2000);

//         System.out.println("Volatile counter value: " + volatileCounter);
        System.out.println("Atomic counter value: " + atomicCounter.get());
    }
}