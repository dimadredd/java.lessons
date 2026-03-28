package school.sorokin.springcore.springCore.beanScope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        JobRunner jobRunner = context.getBean(JobRunner.class);

        jobRunner.runOnce();
        jobRunner.runOnce();
        jobRunner.runOnce();
    }
}
