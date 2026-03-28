package school.sorokin.springcore.DI.GreetingPrinter;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import school.sorokin.springcore.DI.GreetingService.GreetingService;

@Component
public class GreetingPrinterConstructor {

    private final GreetingService greetingService;


    public GreetingPrinterConstructor(@Qualifier("formalGreetingService") GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public void printMessage(String name) {
        System.out.println(greetingService.greet(name));
    }
}
