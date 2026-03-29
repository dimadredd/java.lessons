package school.sorokin.springcore.springCore.property;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class PlannerProperties {

    private final int defaultDuration;
    private final int batchSize;

    public PlannerProperties(
            @Value("${planner.default-duration}") int defaultDuration,
            @Value("${planner.batch-size}") int batchSize
    ) {
        this.defaultDuration = defaultDuration;
        this.batchSize = batchSize;
    }
}
