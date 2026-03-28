package school.sorokin.springcore.springCore.DI.GreetingPrinter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import school.sorokin.springcore.springCore.DI.GreetingService.GreetingService;

@Component
public class GreetingPrinterSetter {

    private GreetingService greetingService;

    @Autowired
    public void setGreetingService(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public void printMessage(String name) {
        System.out.println(greetingService.greet(name));
    }
}
