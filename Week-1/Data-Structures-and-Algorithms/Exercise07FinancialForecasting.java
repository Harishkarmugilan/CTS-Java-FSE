public class Exercise07FinancialForecasting {

    static double futureValue(double amount, double rate, int years) {
        if (years == 0)
            return amount;

        return futureValue(amount * (1 + rate / 100), rate, years - 1);
    }

    public static void main(String[] args) {

        double presentValue = 10000;
        double growthRate = 10;
        int years = 5;

        double result = futureValue(presentValue, growthRate, years);

        System.out.println("Present Value: " + presentValue);
        System.out.println("Growth Rate: " + growthRate + "%");
        System.out.println("Years: " + years);
        System.out.println("Future Value: " + result);
    }
}