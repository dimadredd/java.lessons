package school.sorokin.springcore.final_tasks.springcore.service;

import org.springframework.stereotype.Component;
import school.sorokin.springcore.final_tasks.springcore.config.AccountProperties;
import school.sorokin.springcore.final_tasks.springcore.model.Account;
import school.sorokin.springcore.final_tasks.springcore.model.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class AccountService {
    private Map<Integer, Account> accounts = new HashMap<>();
    private final AccountProperties properties;
    private final UserService userService;
    private int counter;

    public AccountService(AccountProperties properties, UserService userService) {
        this.properties = properties;
        this.userService = userService;
    }


    public void createAccount(int userId) {
        Optional<User> userOptional = userService.getUserById(userId);
        userOptional.ifPresentOrElse(user -> {
            int accountId = ++counter;
            int bonusAmount = user.getAccountList().isEmpty() ? (int) properties.getDefaultAmount() : 0;
            Account account = new Account(accountId, userId, bonusAmount);
            accounts.put(accountId, account);
            user.getAccountList().add(account);
            System.out.println("Account created: " + account);

        }, () -> System.out.println("User not found"));
    }

    public void deposit(int accountId, int amount) {
        Optional<Account> accountOptional = getAccountById(accountId);
        accountOptional.ifPresentOrElse(account -> {
            account.setMoneyAmount(account.getMoneyAmount() + amount);
            System.out.printf("Deposited %d to account %d. New balance: %d",
                    amount, accountId, account.getMoneyAmount());

        }, () -> System.out.println("Account not found"));
    }

    public void withdraw(int accountId, int amount) {
        Optional<Account> accountOptional = getAccountById(accountId);
        accountOptional.ifPresentOrElse(account -> {
            var moneyAmount = account.getMoneyAmount();
            if (moneyAmount >= amount) {
                account.setMoneyAmount(moneyAmount - amount);
                System.out.printf("Withdrawn %d from account %d. New balance %d",
                        amount, accountId, account.getMoneyAmount());
            } else {
                System.out.printf("Error insufficient funds on account id%d, moneyAmount%d, attempted withdraw%d",
                        accountId, moneyAmount, amount);
            }
        }, () -> System.out.println("Account not found"));
    }

    public void transfer(int sourceID, int targetId, int amount) {
        Optional<Account> sourceAccOpt = getAccountById(sourceID);
        Optional<Account> targetAccOpt = getAccountById(targetId);
        if (sourceAccOpt.isEmpty() || targetAccOpt.isEmpty()) {
            System.out.println("Account not found");
            return;
        }
        Account source = sourceAccOpt.get();
        Account target = targetAccOpt.get();

        if (source.getMoneyAmount() < amount) {
            System.out.printf("Error insufficient funds on account id%d, moneyAmount%d, attempted withdraw%d",
                    source.getId(), source.getMoneyAmount(), amount);
            return;
        }

        double commission = source.getUserId() == target.getUserId() ? 0 : amount * properties.getTransferCommission();
        double received = amount - commission;

        source.setMoneyAmount(source.getMoneyAmount() - amount);
        target.setMoneyAmount((int) (target.getMoneyAmount() + received));

        System.out.printf("Transfer completed from %d to %d. Amount %d, commission %.2f, recipient received %.0f%n",
                source.getId(), target.getId(), amount, commission, received);
    }

    public void closeAccount(int accountId) {
        Optional<Account> accountOpt = getAccountById(accountId);
        accountOpt.ifPresentOrElse(account -> {
            int remaining = account.getMoneyAmount();

            if (remaining > 0) {
                Optional<User> userOpt = userService.getUserById(account.getUserId());
                userOpt.ifPresent(user -> {

                    if (user.getAccountList().get(0).getId() == accountId) {
                        System.out.printf("Cannot close first account %d with balance %d%n",
                                accountId, remaining);
                        return;
                    }


                    Account firstAccount = user.getAccountList().get(0);
                    firstAccount.setMoneyAmount(firstAccount.getMoneyAmount() + remaining);


                    accounts.remove(accountId);
                    user.getAccountList().remove(account);

                    System.out.printf("Account %d closed. Remaining %d transferred to %d%n",
                            accountId, remaining, firstAccount.getId());
                });
            } else {

                accounts.remove(accountId);
                userService.getUserById(account.getUserId())
                        .ifPresent(user -> user.getAccountList().remove(account));
                System.out.printf("Account %d closed.%n", accountId);
            }
        }, () -> System.out.println("Account not found"));
    }

    public Optional<Account> getAccountById(int id) {
        return Optional.ofNullable(accounts.get(id));
    }
}
