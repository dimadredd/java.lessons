package school.sorokin.javacore.MultiThreading.Task2;

public class SynchronizedCounter implements Counter{
    private int value;

    @Override
    public synchronized void increment() {
        value++;
    }

    @Override
    public int getValue() {
        return value;
    }
}
