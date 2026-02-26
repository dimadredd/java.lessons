package school.sorokin.javacore.MultiThreading.Task2;

public class VolatileCounter implements Counter{
    private volatile int value;

    @Override
    public void increment() {
        value++;
    }

    @Override
    public int getValue() {
        return value;
    }
}