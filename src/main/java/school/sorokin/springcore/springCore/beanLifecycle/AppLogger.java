package school.sorokin.springcore.springCore.beanLifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class AppLogger {
    public AppLogger() {
        System.out.println("AppLogger Constructor");
    }

    @PostConstruct
    public void init() {
        System.out.println("AppLogger init PostConstruct");
    }

    @PreDestroy
    public void shutdown() {
        System.out.println("AppLogger preDestroy");
    }

    public void process() {
        System.out.println("AppLogger processed");
    }
}
