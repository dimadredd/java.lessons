package school.sorokin.javacore.MultiThreading.Example.IncDecThreadsSynchronized;

public class ThreadsSynchronized {
    private static final int N = 100_000_000;
    private static int x = 0;

    public static void main(String[] args) throws InterruptedException {
        Object monitor = new Object();

        Thread firstThread = new Thread(() -> {
            for (int i = 0; i < N; i++) {
                synchronized (monitor) {
                    x++;
                }
            }
        });

        Thread secondThread = new Thread(() -> {
            for (int i = 0; i < N; i++) {
                synchronized (monitor) {
                    x--;
                }
            }
        });

        firstThread.start();
        secondThread.start();

        firstThread.join();
        secondThread.join();

        System.out.println("x = " + x);
    }
}
