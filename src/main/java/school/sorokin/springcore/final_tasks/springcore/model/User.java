package school.sorokin.springcore.final_tasks.springcore.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;


@Data
@AllArgsConstructor
public class User {
    private int id;
    private String login;
    List<Account> accountList;

}
