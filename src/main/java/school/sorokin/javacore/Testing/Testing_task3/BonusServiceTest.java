package school.sorokin.javacore.Testing.Testing_task3;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BonusServiceTest {
    private BonusService bonus;

    @BeforeAll
    static void initAll() {
        System.out.println("Start testing...");
    }

    @BeforeEach
    void init() {
        bonus = new BonusService();
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("Tests are Completed!");
    }

    @Test
    void shouldReturn0percentBonus() {
        double result = bonus.bonusCalculator(400);
        assertEquals(0, result);
    }

    @Test
    void shouldReturn5percentBonus() {
        double result = bonus.bonusCalculator(600);
        assertEquals(30, result);
    }

    @Test
    void shouldReturn10percentBonus() {
        double result = bonus.bonusCalculator(1100);
        assertEquals(110 ,result);
    }

    @Test
    void shouldReturn15percentBonus() {
        double result = bonus.bonusCalculator(5200);
        assertEquals(780, result);
    }

    @Test
    void shouldReturn0percentFromAmount500() {
        double result = bonus.bonusCalculator(500);
        assertEquals(0, result);
    }
    @Test
    void shouldReturn5percentFromAmount501() {
        double result = bonus.bonusCalculator(501);
        assertEquals(25, result);
    }
}
