package school.sorokin.springcore.springCore.beanScope;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Scope("prototype")
public class TaskContent {

    private final String id = UUID.randomUUID().toString();

    public String id() {
        return id;
    }
}
