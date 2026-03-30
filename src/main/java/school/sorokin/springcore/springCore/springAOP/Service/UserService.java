package school.sorokin.springcore.springCore.springAOP.Service;

import org.springframework.stereotype.Component;
import school.sorokin.springcore.springCore.springAOP.NotNullArgs;

@Component
public class UserService {


    @NotNullArgs
    public void updateName(Long id, String name) {
        System.out.printf("ID: %s, обновилось имя: %s\n", id, name);
    }
}
