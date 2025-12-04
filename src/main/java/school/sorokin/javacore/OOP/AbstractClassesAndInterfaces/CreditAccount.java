package school.sorokin.javacore.OOP.AbstractClassesAndInterfaces;

public class CreditAccount extends Account implements Printable{

    public CreditAccount(double balance){
        super(balance);
    }

    @Override
    public void withdraw(double amount){
        if(balance < amount){
            System.out.println("Снятие средств $" + amount + " недоступно. Недостаточно средств на счете.");
        }else {
            balance -= amount;
            System.out.println("Вы успешно сняли: $" + amount);
        }
    }

    @Override
    public void printInfo(){
        System.out.println("Баланс кредитного счета: $" + balance);
    }
}

