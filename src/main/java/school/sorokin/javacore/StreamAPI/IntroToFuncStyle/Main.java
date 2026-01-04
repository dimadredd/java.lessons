package school.sorokin.javacore.StreamAPI.IntroToFuncStyle;

public class Main {

    public static void testCalculator(MyCalculator calc, double a, double b){
        System.out.println("Result: " + calc.calculate(a, b));
    }
    public static void main(String[] args) {

        MyCalculator lambdaCalc = (a, b) -> a + b;
        MyCalculator ananymCalc = new MyCalculator() {
            @Override
            public double calculate(double a, double b) {
                return a + b;
            }
        };

        testCalculator(ananymCalc,10,5 );
        testCalculator(lambdaCalc, 10, 5);
    }
}
