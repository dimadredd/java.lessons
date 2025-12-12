package school.sorokin.javacore.Exception.ExceptionFirstLesson;

import java.util.Scanner;

public class ExceptionFirstLesson {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите первое число:");
        int a = sc.nextInt();
        System.out.println("Введите второе число: ");
        try{
            int b = sc.nextInt();
            int c = a/b;
            System.out.println("Результат: " + c);

        }catch (ArithmeticException e){
            System.out.println("Деление на ноль! Пожалуйста, попробуйте другое число.");
        }
        System.out.println("Спасибо за использование программы");
    }
}
