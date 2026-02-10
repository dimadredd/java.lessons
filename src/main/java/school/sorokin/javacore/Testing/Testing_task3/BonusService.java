package school.sorokin.javacore.Testing.Testing_task3;

public class BonusService {
    private int amount;


    public static int bonusCalculator(int amount) {
        if (amount > 500 && amount < 1000) {
            return (int) (amount * 0.05);
        } else if (amount > 1000 && amount < 5000) {
            return (int) (amount * 0.1);
        } else if (amount > 5000) {
            return (int) (amount * 0.15);
        } else {
            return 0;
        }
    }
}
