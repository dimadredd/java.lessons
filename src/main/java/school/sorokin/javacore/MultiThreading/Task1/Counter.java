package school.sorokin.javacore.MultiThreading.Task1;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Counter {

    private int value;

    public void increment() {
        value++;
    }
}
