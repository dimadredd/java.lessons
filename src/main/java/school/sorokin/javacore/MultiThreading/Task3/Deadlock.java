package school.sorokin.javacore.MultiThreading.Task3;


public class Deadlock {
    public static final int TRIES = 10;

    public static void main(String[] args) throws InterruptedException {
       Object lockA = new Object();
       Object lockB = new Object();

       Thread firstThread = new Thread(() -> {
           for (int i = 0; i < TRIES; i++) {
               synchronized (lockA) {
                   System.out.println("первый поток захватывает lockA");
                   try {
                       Thread.sleep(50);
                   } catch (InterruptedException e) {
                       throw new RuntimeException(e);
                   }
                   synchronized (lockB) {
                       System.out.println("первый поток захватывает lockB");
                   }
               }
           }
       });

       Thread secondThread = new Thread(() -> {
           for (int i = 0; i < TRIES; i++) {
               synchronized (lockA) {
                   System.out.println("второй поток захватывает lockA");
                   try {
                       Thread.sleep(50);
                   } catch (InterruptedException e) {
                       throw new RuntimeException(e);
                   }
                   synchronized (lockB) {
                       System.out.println("второй поток захватывает lockB");
                   }
               }
           }
       });
       firstThread.start();
       secondThread.start();
    }
}
