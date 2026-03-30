package school.sorokin.springcore.final_tasks.springcore.console;

import org.springframework.stereotype.Component;
import school.sorokin.springcore.final_tasks.springcore.service.AccountService;
import school.sorokin.springcore.final_tasks.springcore.service.UserService;

import java.util.Scanner;

@Component
public class ConsoleListener {
    private final Scanner scanner = new Scanner(System.in);
    private final UserService userService;
    private final AccountService accountService;


    public ConsoleListener(UserService userService, AccountService accountService) {
        this.userService = userService;
        this.accountService = accountService;
    }

    public void start() {
        System.out.println("MiniBank started. Type EXIT to stop.");
        while (true) {
            System.out.println("\nAvailable commands: " +
                    "\nUSER_CREATE" +
                    "\nSHOW_ALL_USERS" +
                    "\nACCOUNT_CREATE" +
                    "\nACCOUNT_DEPOSIT" +
                    "\nACCOUNT_WITHDRAW" +
                    "\nACCOUNT_TRANSFER" +
                    "\nACCOUNT_CLOSE" +
                    "\nEXIT\n" +
                    "\nEnter command:  ");
            String choice = scanner.nextLine().trim().toUpperCase();
            if ("EXIT".equals(choice)) {
                System.out.println("MiniBank stopped.");
                break;
            }
            switch (choice) {
                case "USER_CREATE":
                    System.out.println("Enter login: ");
                    String login = scanner.nextLine().trim();
                    userService.createUser(login);
                    break;

                case "SHOW_ALL_USERS":
                    userService.showAllUsers()
                            .forEach(System.out::println);
                    break;
                case "ACCOUNT_CREATE":
                    int userId = readInt("Enter user id: ");
                    accountService.createAccount(userId);
                    break;
                case "ACCOUNT_DEPOSIT":
                    int accountId = readInt("Enter account id:");
                    int amount = readInt("Enter amount:");
                    accountService.deposit(accountId, amount);
                    break;
                case "ACCOUNT_WITHDRAW":
                    int accId = readInt("Enter account id:");
                    int amountWithdraw = readInt("Enter amount:");
                    accountService.withdraw(accId, amountWithdraw);
                    break;
                case "ACCOUNT_TRANSFER":
                    int source = readInt("Enter source account id:");
                    int target = readInt("Enter target account id:");
                    int transferAmount = readInt("Enter amount:");
                    accountService.transfer(source,target,transferAmount);
                    break;
                case "ACCOUNT_CLOSE":
                    int id = readInt("Enter account id to close:");
                    accountService.closeAccount(id);
                    break;
            }
        }
    }

    private int readInt(String text) {
        System.out.println(text);
        while(true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e){
                System.out.println("Неверное число! Введите цифры:");
            }
        }
    }
}
