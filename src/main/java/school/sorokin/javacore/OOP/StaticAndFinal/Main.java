package school.sorokin.javacore.OOP.StaticAndFinal;

public class Main {
    public static void main(String[] args) {

        Player p1 = new Player("A", 105);
        Player p2 = new Player("B", 50);

        System.out.println("Общие очки игры: " + GameScore.totalScore);
        System.out.println("Имя: " + p1.name + ", персональные очки: " + p1.personalScore);
        System.out.println("Имя: " + p2.name + ", персональные очки: " + p2.personalScore);

    }
}
