package school.sorokin.springcore.springCore.springAOP;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import school.sorokin.springcore.springCore.springAOP.Config.AppConfig;
import school.sorokin.springcore.springCore.springAOP.Service.EmailService;
import school.sorokin.springcore.springCore.springAOP.Service.UserService;

public class App {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);
        EmailService emailService = context.getBean(EmailService.class);

        System.out.println("=== Корректные аргументы ===");
        userService.updateName(1L,"Dima");
        emailService.send("user@user.ru","test");

        System.out.println("\n=== Null аргумент ===");

        try{
            emailService.send(null,"Hello!");
        } catch (IllegalArgumentException e) {
            System.out.println("Caught: " + e.getMessage());
        }

        try {
            userService.updateName(10L, null);
        } catch (IllegalArgumentException e){
            System.out.println("Caught: " + e.getMessage());
        }

        context.close();
    }
}
