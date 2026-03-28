package school.sorokin.springcore.springCore.beanLifecycle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        System.out.println("-----context started-----");
        AppLogger appLogger = context.getBean(AppLogger.class);
        AppLogger appLogger1 = context.getBean(AppLogger.class);

        System.out.println("logger 1 == logger2?: " + (appLogger == appLogger1));

        OperationContext operationContext = context.getBean(OperationContext.class);
        OperationContext operationContext1 = context.getBean(OperationContext.class);
        OperationContext operationContext2 = context.getBean(OperationContext.class);

        System.out.println("ctx1 == ctx2?: " + (operationContext1 == operationContext2));

        System.out.println("---- closing context ----");
        context.close();

        System.out.println("---- context closed ----");

    }
}
