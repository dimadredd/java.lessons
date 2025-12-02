package school.sorokin.javacore.basics;

public class Operators {
    public static void main(String[] args) {
        int grade1 = 8;
        int grade2 = 1;
        int grade3 = 5;

        //Вычислить средний балл (просто (оценка1 + оценка2 + оценка3) / 3.0 как double).

        int gradeSum = grade1+grade2+grade3;

        double avgGrade = (double) gradeSum / 3;
        System.out.println("Средний балл: " + avgGrade);

        //Проверить, все ли оценки равны 10 (== 10). Если да, то вывести особое сообщение "У студента все оценки максимальные!".

        boolean isGrade10 = grade1 == 10 && grade2 == 10 && grade3 == 10;

        if (isGrade10){
            System.out.println("У студента все оценки максимальные!");
        }

        //Проверить, есть ли хотя бы одна оценка 2 или ниже. Если да, то вывести сообщение "Встречается очень низкая оценка!".

        boolean isGradeLow2 = grade1 <= 2 || grade2 <= 2 || grade3 <= 2;

        if (isGradeLow2) {
            System.out.println("Встречается очень низкая оценка!");
        }

        //Если средний балл >= 5, вывести "У студента удовлетворительная успеваемость", иначе — "У студента неудовлетворительная успеваемость".

        if(avgGrade >= 5){
            System.out.println("У студента удовлетворительная успеваемость");
        }else{
            System.out.println("У студента неудовлетворительная успеваемость");
        }

        //Попробуйте добавить проверку: лежит ли каждая из оценок в диапазоне 0..10. Если вдруг одна из оценок меньше 0 или больше 10, вывести "Ошибка: некорректная оценка!"

        boolean invalidGrade = (grade1 < 0 || grade1 > 10) || (grade2 < 0 || grade2 > 10) || (grade3 < 0 || grade3 > 10);

        if (invalidGrade){
            System.out.println("Ошибка: некорректная оценка!");
        }
    }
}
