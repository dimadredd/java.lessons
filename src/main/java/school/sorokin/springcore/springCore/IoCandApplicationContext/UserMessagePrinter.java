package school.sorokin.springcore.springCore.IoCandApplicationContext;

import org.springframework.stereotype.Component;

@Component
public class UserMessagePrinter {
    private final UserMessageService userMessageService;

    public UserMessagePrinter(UserMessageService userMessageService) {
        this.userMessageService = userMessageService;
    }

    public void printMessage(String name) {
        String text = userMessageService.createMessage(name);
        System.out.println(text);
    }
}
