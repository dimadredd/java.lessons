package school.sorokin.springcore.springCore.property;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        PlannerService service = context.getBean(PlannerService.class);
        service.printConfig();
    }
}
