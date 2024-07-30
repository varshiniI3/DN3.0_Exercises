package ex7;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class FinancilaForecasting {
    private static Map<Integer, Double> memo = new HashMap<>();
    public static double predictFutureValue(double initialValue, double growthRate, int years) {
        if (years == 0) {
            return initialValue;
        }
        if (memo.containsKey(years)) {
            return memo.get(years);
        }
        double growthFactor = 1 + (growthRate / 100);
        double futureValue = predictFutureValue(initialValue * growthFactor, growthRate, years - 1);
        memo.put(years, futureValue);
        return futureValue;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the initial investment amount: ");
        double initialValue = sc.nextDouble();
        System.out.print("Enter the annual growth rate (percentage): ");
        double growthRate = sc.nextDouble();
        System.out.print("Enter the number of years to forecast: ");
        int years = sc.nextInt();
        double futureValue = predictFutureValue(initialValue, growthRate, years);
        System.out.println("The predicted future value is: $" +futureValue);
        sc.close();
    }
}


