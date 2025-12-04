package school.sorokin.javacore.OOP.AbstractClassesAndInterfaces;

public class Main {
    public static void main(String[] args) {
        Account ac1 = new SavingAccount(200);
        Account ac2 = new CreditAccount(1500);
        Printable p1 = (Printable) ac1;
        Printable p2 = (Printable) ac2;

        p1.printInfo();
        ac1.deposit(250);
        p1.printInfo();
        ac1.withdraw(500);
        ac1.withdraw(100);
        p1.printInfo();

        p2.printInfo();
        ac2.withdraw(1000);
        p2.printInfo();
    }
}
