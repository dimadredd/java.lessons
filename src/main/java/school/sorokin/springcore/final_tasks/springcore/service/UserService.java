package school.sorokin.springcore.final_tasks.springcore.service;

import org.springframework.stereotype.Component;
import school.sorokin.springcore.final_tasks.springcore.model.User;

import java.util.*;

@Component
public class UserService {

    private Map<Integer, User> users = new HashMap<>();
    private int counter;


    public void createUser(String login) {
        int id = ++counter;
        User user = new User(id, login, new ArrayList<>());
        users.put(id, user);
        System.out.println("User created: " + user);
    }

    public List<User> showAllUsers() {
        return new ArrayList<User>(users.values());
    }

    public Optional<User> getUserById(int id) {
        var result = users.get(id);
        return Optional.ofNullable(result);
    }
}
