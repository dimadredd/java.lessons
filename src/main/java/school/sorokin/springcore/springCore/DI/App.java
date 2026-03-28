package school.sorokin.springcore.springCore.DI;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import school.sorokin.springcore.springCore.DI.GreetingPrinter.GreetingPrinterConstructor;
import school.sorokin.springcore.springCore.DI.GreetingPrinter.GreetingPrinterField;
import school.sorokin.springcore.springCore.DI.GreetingPrinter.GreetingPrinterSetter;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        GreetingPrinterConstructor printerC = context.getBean(GreetingPrinterConstructor.class);
        GreetingPrinterField printerF = context.getBean(GreetingPrinterField.class);
        GreetingPrinterSetter printerS = context.getBean(GreetingPrinterSetter.class);

        printerC.printMessage("Pasha");
        printerF.printMessage("Paul");
        printerS.printMessage("Pavel");
    }
}
