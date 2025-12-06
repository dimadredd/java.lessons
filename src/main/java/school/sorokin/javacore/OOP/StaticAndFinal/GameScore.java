package school.sorokin.javacore.OOP.StaticAndFinal;

public class GameScore {
    public static int totalScore = 0;

    public static void addPoints(int points) {
        totalScore += points;
    }
}
