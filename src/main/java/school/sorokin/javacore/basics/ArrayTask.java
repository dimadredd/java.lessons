package school.sorokin.javacore.basics;

import java.util.Scanner;

public class ArrayTask {
    public static void main(String[] args) {

        //Создаёт массив из 10 целых чисел (заполните их случайными значениями или вводом с клавиатуры).
        Scanner console = new Scanner(System.in);
        int[] arr = new int[10];

        System.out.println("Введите 10 целых чисел");

        for (int i = 0; i < arr.length; i++){
            int count = i + 1;
            System.out.println("Введите " + count + " число:");
            arr[i] = console.nextInt();
        }

        //Выводит все элементы массива на экран.

        System.out.print("Отлично, ваш массив: ");
        for(int num: arr){
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.println();

        //Определяет и выводит индекс минимального и максимального элемента (или сами эти элементы).

        int min = arr[0];
        int max = arr[0];
        int minIndex = 0;
        int maxIndex = 0;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] < min){
                min = arr[i];
                minIndex = i;
            }
            if (arr[i] > max){
                max = arr[i];
                maxIndex = i;
            }
        }
        System.out.println("Минимум: " + min + " (index: " + minIndex + ").");
        System.out.println("Максимум: " + max + " (index: " + maxIndex + ").");
        System.out.println();

        //Сортирует массив по возрастанию (можно любым способом, например, «пузырьком») и выводит результат.
        for(int i = 0; i < arr.length - 1; i++){
            for(int j = 0; j < arr.length - 1 - i; j++){
                if (arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1 ] = temp;
                }
            }
        }

        System.out.print("Отсортированный массив: ");
        for (int num:arr){
            System.out.print(num + " ");
        }
        System.out.println();

        //(Опционально) Создаёт двумерный массив размером 2×5, заполняет его и выводит на экран в виде таблицы.
        int[][] matrix = new int[2][5];
        int value = 1;

        for(int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                matrix[i][j] = value;
                value++;
            }
        }

        System.out.println("Двухмерный массив: ");
        System.out.println();

        for(int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
