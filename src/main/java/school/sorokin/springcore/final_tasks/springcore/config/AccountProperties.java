package school.sorokin.springcore.final_tasks.springcore.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class AccountProperties {
    private double defaultAmount;
    private double transferCommission;

    public AccountProperties(
            @Value("${account.default-amount}") double defaultAmount,
            @Value("${account.transfer-commission}") double transferCommission) {
        this.defaultAmount = defaultAmount;
        this.transferCommission = transferCommission;
    }
}
