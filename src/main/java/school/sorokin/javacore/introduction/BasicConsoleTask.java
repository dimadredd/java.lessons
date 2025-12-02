package school.sorokin.javacore.introduction;

import java.util.Scanner;

public class BasicConsoleTask {
    public static void main(String[] args){
        String name;
        int age;

        Scanner console = new Scanner(System.in);
        System.out.println("Напиши свое имя: ");
        name = console.nextLine();

        System.out.println("Отлично! Теперь напиши свой возраст:");
        age = console.nextInt();

        System.out.println("Привет, " + name + "!");
        System.out.println("Тебе уже " + age + " лет!");
    }
}

