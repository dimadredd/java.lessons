package school.sorokin.springcore.DI.GreetingPrinter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import school.sorokin.springcore.DI.GreetingService.GreetingService;

@Component
public class GreetingPrinterField {

    @Autowired
    @Qualifier("formalGreetingService")
    private GreetingService greetingService;

    public void printMessage(String name) {
        System.out.println(greetingService.greet(name));
    }
}
