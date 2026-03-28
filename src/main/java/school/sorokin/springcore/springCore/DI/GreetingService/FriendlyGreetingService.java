package school.sorokin.springcore.springCore.DI.GreetingService;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class FriendlyGreetingService implements GreetingService {

    @Override
    public String greet(String name) {
        return "Дружелюбное приветствие " + name;
    }
}
