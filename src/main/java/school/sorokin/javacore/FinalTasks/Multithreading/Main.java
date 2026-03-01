package school.sorokin.javacore.FinalTasks.Multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        DataProcessor dataProcessor = new DataProcessor();
        Random random = new Random();
        List<String> taskNames = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            List<Integer> numbers = new ArrayList<>();
            for (int j = 0; j < 50; j++) {
                numbers.add(random.nextInt(100));
            }
            String name = dataProcessor.submitTask(numbers);
            taskNames.add(name);
        }

        while (dataProcessor.getActiveTask() > 0) {
            System.out.println("Active tasks: " + dataProcessor.getActiveTask());
            Thread.sleep(100);
        }

        System.out.println("All tasks finished!");

        for (String taskName : taskNames) {
            System.out.println(taskName + " -> " + dataProcessor.getResult(taskName).orElse(null));
        }

        dataProcessor.shutdown();
    }
}
