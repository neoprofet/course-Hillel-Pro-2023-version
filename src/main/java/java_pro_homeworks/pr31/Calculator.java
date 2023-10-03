package java_pro_homeworks.pr31;

public class Calculator {
    public static double sumOf(double a, double b){
        return a+b;
    }
    public static double subtractionOf(double a, double b) {
        return a-b;
    }

    public static double multiplicationOf(double a, double b){
        return a*b;
    }

    public static double divisionOf(double a, double b){
        return a/b;
    }

    public static double powerOfNumberToDegree(double a, int degree){
        double number = a;
        for (int i = 0; i < degree-1; i++) {
            a = a*number;
        }
        return a;
    }

    public static boolean byThreeOrNotBy(int number) {

        return (getSumOfDigitsFromPositiveNumber(number) % 3 == 0);
    }

    private static int getSumOfDigitsFromPositiveNumber(int num) {
        num = Math.abs(num);
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
