package school.sorokin.javacore.basics;

import java.util.Scanner;

public class ConditionalStatements {
    public static void main(String[] args) {
        //Предлагаем ввести число от 1 до 5 (1 — комедия, 2 — драма, 3 — фантастика, 4 — боевик, 5 — аниме).

        Scanner console = new Scanner(System.in);
        System.out.println("Введите число от 1 до 5 (1 — комедия, 2 — драма, 3 — фантастика, 4 — боевик, 5 — аниме)");

        int num = console.nextInt();

        //Если число не входит в диапазон 1–5, выводит сообщение: «Такого жанра не знаю».

        while (num < 1 || num > 5){
            System.out.println("Такого жанра не знаю.");
            num = console.nextInt();
        }

        //В зависимости от введённого числа предлагает несколько известных фильмов этого жанра (можно ограничиться 1–2 названиями).

        switch (num) {

            case 1:
                System.out.println("Вы выбрали комедию. ");
                System.out.println("Предлагаем вам посмотреть 1. «Мальчишник в Вегасе» или 2. «Один дома»");
                System.out.println("Введите номер фильма: ");

                int comedy = console.nextInt();

                while (comedy < 1 || comedy > 2){
                    System.out.println("Не корректно введен номер, попробуйте еще раз:");
                    comedy = console.nextInt();
                }
                if (comedy == 1){
                    System.out.println("Вы выбрали «Мальчишник в Вегасе», приятного просмотра.");
                } else {
                    System.out.println("Вы выбрали «Один дома», приятного просмотра.");
                }
                break;

            case 2:
                System.out.println("Вы выбрали драму.");
                System.out.println("Предлагаем вам посмотреть 1. «Зелёная миля» или 2. «Побег из Шоушенка»");
                System.out.println("Введите номер фильма: ");

                int drama = console.nextInt();

                while (drama< 1 || drama> 2){
                    System.out.println("Не корректно введен номер, попробуйте еще раз:");
                    drama = console.nextInt();
                }
                if (drama == 1){
                    System.out.println("Вы выбрали «Зелёная миля», приятного просмотра.");
                } else {
                    System.out.println("Вы выбрали «Побег из Шоушенка», приятного просмотра.");
                }
                break;

            case 3:
                System.out.println("Вы выбрали фантастику.");
                System.out.println("Предлагаем вам посмотреть 1. «Интерстеллар» или 2. «Матрица»");
                System.out.println("Введите номер фильма: ");

                int fantasy = console.nextInt();

                while (fantasy< 1 || fantasy> 2){
                    System.out.println("Не корректно введен номер, попробуйте еще раз:");
                    fantasy = console.nextInt();
                }
                if (fantasy == 1){
                    System.out.println("Вы выбрали «Интерстеллар», приятного просмотра.");
                } else {
                    System.out.println("Вы выбрали «Матрица», приятного просмотра.");
                }
                break;

            case 4:
                System.out.println("Вы выбрали боевик.");
                System.out.println("Предлагаем вам посмотреть 1. «Джон Уик» или 2. «Крепкий орешек»");
                System.out.println("Введите номер фильма: ");

                int action = console.nextInt();

                while (action< 1 || action> 2){
                    System.out.println("Не корректно введен номер, попробуйте еще раз:");
                    action = console.nextInt();
                }
                if (action == 1){
                    System.out.println("Вы выбрали «Джон Уик», приятного просмотра.");
                } else {
                    System.out.println("Вы выбрали «Крепкий орешек», приятного просмотра.");
                }
                break;

            case 5:
                System.out.println("Вы выбрали аниме.");
                System.out.println("Предлагаем вам посмотреть 1. «Унесённые призраками» или 2. «Тетрадь смерти»");
                System.out.println("Введите номер фильма: ");

                int anime = console.nextInt();

                while (anime< 1 || anime> 2){
                    System.out.println("Не корректно введен номер, попробуйте еще раз:");
                    anime = console.nextInt();
                }
                if (anime == 1){
                    System.out.println("Вы выбрали «Унесённые призраками», приятного просмотра.");
                } else {
                    System.out.println("Вы выбрали «Тетрадь смерти», приятного просмотра.");
                }
                break;
        }
    }
}
