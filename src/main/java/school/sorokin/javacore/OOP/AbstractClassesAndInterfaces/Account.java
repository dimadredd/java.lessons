package school.sorokin.javacore.OOP.AbstractClassesAndInterfaces;

public abstract class Account {

    double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount){
        balance += amount;
        System.out.println("Вы пополнили счет на: $" + amount);
    }

    abstract void withdraw(double amount);
}
