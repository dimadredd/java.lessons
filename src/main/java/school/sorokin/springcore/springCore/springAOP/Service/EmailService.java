package school.sorokin.springcore.springCore.springAOP.Service;

import org.springframework.stereotype.Component;
import school.sorokin.springcore.springCore.springAOP.NotNullArgs;

@Component
public class EmailService {

    @NotNullArgs
    public void send(String to, String text) {
        System.out.println("Email was sended to: " + to + "\nEmail text: " + text);
    }
}
