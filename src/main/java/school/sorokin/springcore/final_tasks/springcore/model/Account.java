package school.sorokin.springcore.final_tasks.springcore.model;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class Account {
    private int id;
    private int userId;
    private int moneyAmount;

}
