package school.sorokin.javacore;


public class App {

    static double price = 595.44;
    static double couponePrice = 70.8;
    static int sheets = (int) ((int) 100000 / price);
    static double money = 10000;
    static int time = 5;
    static double investTime = money * 52;


    public static void main(String[] args) {
        for(int i = 1; i <= time; i++) {

            //Пополнение на 60 000
            sheets += investTime / price;

            //Купонный доход
            double couponRevenue = sheets * couponePrice;

            //Реинвест
            double reinvest = couponRevenue / price;
            sheets += reinvest;

            double totalMoney = sheets * 1000;

            System.out.println("Итерация " + i);
            System.out.println("Активов: " + sheets);
            System.out.println("Денег: " + totalMoney);
            System.out.println("----------------------------");
        }
    }
}
