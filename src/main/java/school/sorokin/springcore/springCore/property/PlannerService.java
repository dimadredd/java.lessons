package school.sorokin.springcore.springCore.property;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PlannerService {

    private final boolean enable;
    private final PlannerProperties properties;

    public PlannerService(
            @Value("${planner.enabled:false}") boolean enable,
            PlannerProperties properties
    ) {
        this.enable = enable;
        this.properties = properties;
    }

    public void printConfig() {
        System.out.println("enabled=" + enable);
        System.out.println("duration=" + properties.getDefaultDuration());
        System.out.println("batchSize=" + properties.getBatchSize());
    }
}
