package school.sorokin.javacore.FinalTasks.Multithreading;

import java.util.List;
import java.util.concurrent.Callable;


public class CalculateSumTask implements Callable<Integer> {

    private List<Integer> numbers;
    private String taskName;

    public CalculateSumTask(List<Integer> numbers, String taskName) {
        this.numbers = numbers;
        this.taskName = taskName;
    }


    @Override
    public Integer call() throws Exception {
        System.out.println(taskName +
                " | Thread: " + Thread.currentThread().getName());

        Thread.sleep(200);

        int sum = 0;
        for (Integer num : numbers) {
            sum += num;
        }

        return sum;
    }
}
