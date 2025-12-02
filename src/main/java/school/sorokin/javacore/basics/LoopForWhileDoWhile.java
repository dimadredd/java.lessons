package school.sorokin.javacore.basics;

public class LoopForWhileDoWhile {
    public static void main(String[] args) {
        //С помощью цикла for выводит на экран все числа от 1 до 100, которые делятся на 3.
        for(int i = 1; i <= 100; i++){
            if(i % 3 ==0){
                System.out.print(i + ", ");
            }
        }
        System.out.println();

        //Затем с помощью цикла while выводит обратный отсчёт от 10 до 1 (10, 9, 8, ...).
        int count = 10;
        while (count >= 1){
            System.out.print(count + " ");
            count--;
        }
        System.out.println();

        //Использует вложенные циклы, чтобы вывести на экран таблицу умножения (формата 1*1=1, 1*2=2, и т. д., до 9*9=81).
        //(Дополнительно) Остановите вложенный цикл, когда произведение станет больше 30, используя break.

        for(int i = 1; i <= 9; i++){
            for(int j = 1; j <= 9; j++){
                if((i*j) > 30) {
                    break;
                }
                System.out.println(i + "*" + j + "=" + (i * j));
            }
        }
    }
}
