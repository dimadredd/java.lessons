package school.sorokin.javacore.Exception.ExceptionHandling;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        logger.setUseParentHandlers(false);

        Scanner sc = new Scanner(System.in);
        String ask;
        StringBuilder history = new StringBuilder();
        int operation = 0;

        while (true) {
            double num1 = 0;
            double num2 = 0;

            try {
                System.out.print("Введите первое число: ");
                num1 = sc.nextDouble();

                System.out.print("Введите второе число: ");
                num2 = sc.nextDouble();

                operation++;

                if (num2 == 0) {
                    throw new ArithmeticException("деление на ноль.");
                }

                double demNums = num1 / num2;

                System.out.println("Результат деления: " + demNums);

                history.append(operation)
                        .append(". Деление ")
                        .append(num1).append(" / ").append(num2)
                        .append(" = ")
                        .append(demNums)
                        .append("\n");

                logger.log(Level.INFO, "Деление: " + num1 + " / " + num2 + " = " + demNums);

            } catch (InputMismatchException e) {
                logger.log(Level.SEVERE, "Введено не число", e);
                System.out.println("Ошибка: введите число.");
                continue;

            } catch (ArithmeticException e) {
                System.out.println("Ошибка: деление на ноль.");

                history.append(operation)
                        .append(". Деление ")
                        .append(num1).append(" / ").append(num2)
                        .append(" завершилось ошибкой: деление на ноль.\n");

                logger.log(Level.SEVERE, "Деление на ноль: " + num1 + " / " + num2, e);

            } finally {
                sc.nextLine();
            }

            while (true) {
                System.out.print("Хотите выполнить еще одно деление? (да/нет): ");
                ask = sc.nextLine().trim();

                if (ask.equalsIgnoreCase("да")) break;

                if (ask.equalsIgnoreCase("нет")) {
                    System.out.println("\nИстория операций:");
                    System.out.print(history);
                    System.out.println("\nСпасибо за использование программы!");
                    return;
                }

                System.out.println("Ошибка: введите только да/нет.");
            }
        }
    }
}
