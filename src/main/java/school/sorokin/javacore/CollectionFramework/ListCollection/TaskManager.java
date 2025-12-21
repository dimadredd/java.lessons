package school.sorokin.javacore.CollectionFramework.ListCollection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TaskManager {
    public static void main(String[] args) {

        List<String> taskList = new ArrayList<>();

        taskList.add("Сделать дз");
        taskList.add("Сделать конспект");

        System.out.println(taskList);

        taskList = new LinkedList<>(taskList);

        taskList.add(1, "Сделать уборку");

        System.out.println(taskList);

        taskList.remove(1);

        System.out.println(taskList);

    }
}
