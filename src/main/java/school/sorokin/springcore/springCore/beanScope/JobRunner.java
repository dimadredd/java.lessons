package school.sorokin.springcore.springCore.beanScope;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Component;

@Component
public class JobRunner {

//    private final TaskContent taskContent;
//
//    public JobRunner(TaskContent taskContent) {
//        this.taskContent = taskContent;
//    }
//
//    public void runOnce() {
//        System.out.println(taskContent.id());
//    }


    private final ObjectProvider<TaskContent> taskContentProvider;


    public JobRunner(ObjectProvider<TaskContent> taskContentProvider) {
        this.taskContentProvider = taskContentProvider;
    }


    public void runOnce() {
        TaskContent taskContent = taskContentProvider.getObject();
        System.out.println(taskContent.id());
    }

}
