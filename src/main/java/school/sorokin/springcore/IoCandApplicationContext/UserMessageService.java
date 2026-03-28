package school.sorokin.springcore.IoCandApplicationContext;

import org.springframework.stereotype.Component;

@Component
public class UserMessageService {
    public String createMessage(String name) {
        return "Привет, " + name + ", добро пожаловать!";
    }
}
