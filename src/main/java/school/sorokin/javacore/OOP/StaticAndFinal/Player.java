package school.sorokin.javacore.OOP.StaticAndFinal;

public class Player {

    String name;
    int personalScore;

    public Player(String name, int points) {
        this.name = name;
        this.personalScore = points;

        GameScore.addPoints(points);
    }
}
