package school.sorokin.springcore.final_tasks.springcore;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import school.sorokin.springcore.final_tasks.springcore.config.AppConfig;
import school.sorokin.springcore.final_tasks.springcore.console.ConsoleListener;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class );
        ConsoleListener console = context.getBean(ConsoleListener.class);
        console.start();
    }
}
