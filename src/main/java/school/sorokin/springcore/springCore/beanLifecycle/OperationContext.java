package school.sorokin.springcore.springCore.beanLifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class OperationContext {
    public OperationContext() {
        System.out.println("OperationContext constructor");
    }

    @PostConstruct
    public void init() {
        System.out.println("OperationContext init PostConstruct");
    }

    @PreDestroy
    public void shutdown() {
        System.out.println("OperationContext preDestroy");
    }

    public void process() {
        System.out.println("OperationContext processed");
    }
}
