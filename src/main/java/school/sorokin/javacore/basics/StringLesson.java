package school.sorokin.javacore.basics;

import java.util.Scanner;

public class StringLesson {
    public static void main(String[] args) {
        //Считывает строку с клавиатуры (например, "Hello, Java World!").
        Scanner console = new Scanner(System.in);
        System.out.println("Введите текст: ");
        String st = console.nextLine();

        //Выводит длину этой строки.
        System.out.println("Длинна строки: " + st.length() + " символов.");

        //Выводит её в верхнем регистре.
        System.out.println("Строка в верхнем регистре: " + st.toUpperCase());

        //Проверяет, содержится ли в строке слово "Java". Если да — выводит индекс первого вхождения, если нет — пишет, что не найдено.
        if(st.contains("Java")){
            System.out.println("Индекс первого вхождения \"Java\": " + st.indexOf("Java"));
        }else{
            System.out.println("Не найдено слово \"Java\".");
        }

        //Делит строку на слова (разделитель — пробел) и выводит все слова по одному в консоль.
        String[] words = st.split(" ");

        for (String word : words){
            System.out.println(word);
        }
    }
}
