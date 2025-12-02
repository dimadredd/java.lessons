package school.sorokin.javacore.basics;

public class VariablesPrimitiveDataTypes {
    public static void main(String[] args) {

        //Объявляет переменные типов byte, short, int, long, float, double, boolean и char.
        byte age = 18;
        short numberOfStudents = 1200;
        int population = 1_200_000;
        long userID = 8_345_567_235L;
        float itemPrice = 9.99f;
        double bankAccountBalance = 6_987_524.28;
        boolean isOnline = true;
        char currencySymbol = '$';

        //Выводит каждую переменную на консоль вместе с описанием.

        System.out.println("Ваш возраст: " + age);
        System.out.println("В заведении учится: " + numberOfStudents + " студентов.");
        System.out.println("Население города: " + population + " человек.");
        System.out.println("Ваш ID: " + userID);
        System.out.println("Стоимость товара: " + currencySymbol + "" + itemPrice);
        System.out.println("Баланс кошелька: " + bankAccountBalance + "" + currencySymbol);
        System.out.println("Пользователь #: " + userID + ", Статус онлайн: " + isOnline);
        System.out.println("Валюта США: " + currencySymbol);
        System.out.println();

        //Создаёт вторую переменную типа int и присваивает ей значение из long переменной с явным приведением. Проверьте, не будет ли потеря данных.

        int anotherUserId = (int) userID;
        System.out.println("Будет потеря данных, т.к число выходит за рамки значения int. Было ID: " + userID + ". Стало ID: " + anotherUserId);
        System.out.println();

        //(Дополнительно) С помощью char и математических операций попробуйте вывести в консоль несколько последовательных символов. Например, взяв 'A' и увеличивая код на 1, 2, 3.

        char symbol = (char) (currencySymbol + 1);
        char symbol2 = (char) (symbol + 2);
        char symbol3 = (char) (symbol2 + 3);
        int uniCodeNumber1 = (int) symbol;
        int uniCodeNumber2 = (int) symbol2;
        int uniCodeNumber3 = (int) symbol3;
        System.out.println("Первый символ: " + symbol + ", с номером UniCODE: " + uniCodeNumber1 + ", " +
                            "второй символ: " + symbol2 +  ", с номером UniCODE: " + uniCodeNumber2 + ", " +
                            "третий символ: " + symbol3 + ", с номером UniCODE: " + uniCodeNumber3 );
        System.out.println();



    }
}
