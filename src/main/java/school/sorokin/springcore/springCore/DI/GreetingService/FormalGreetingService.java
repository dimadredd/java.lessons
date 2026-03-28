package school.sorokin.springcore.springCore.DI.GreetingService;

import org.springframework.stereotype.Component;

@Component
public class FormalGreetingService implements GreetingService {

    @Override
    public String greet(String name) {
        return "Формальное приветствие " + name;
    }
}
