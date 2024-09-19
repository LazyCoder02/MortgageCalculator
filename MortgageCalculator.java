import java.text.NumberFormat;
import java.util.Scanner;
public class Main {
    final static byte PERCENT = 100;
    final static byte YEAR = 12;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int principal = (int) readNumber("Principal: ", 1_000, 1_000_000);
        float annualInterest = (float) readNumber("Annual Interest: ", 1, 30);
        byte period = (byte) readNumber("Period (years): ", 1, 30);

        printMortgage(principal, annualInterest, period);
        printPaymentSchedule(principal, annualInterest, period);
    }

    private static void printMortgage(int principal, float annualInterest, byte period) {
        double mortgage = calculateMortgage(principal, annualInterest, period);
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        System.out.println("MORTGAGE: " + " \n--------- \n " +
                "Monthly Payments: " +  currency.format(mortgage));
    }

    private static void printPaymentSchedule(int principal, float annualInterest, byte period) {
        System.out.println("PAYMENT SCHEDULE \n--------------");
        for(short month = 1; month <= period * YEAR; month++){
            double balance = loanBalance(principal, annualInterest, period, month);
            System.out.println( NumberFormat.getCurrencyInstance().format(balance));
        }
    }

    private static double readNumber(String prompt, int min, int max) {
        Scanner scanner = new Scanner(System.in);
        double value = 0;
        while(true) {
            System.out.print(prompt);
            value = scanner.nextDouble();
            if (value >= min && value <= max)
                break;
            System.out.println("Enter a value between " + min + " & " + max);
        }
        return value;
    }

    public static void greetUser(String name){
        System.out.println("Hello " + name);

    }

    public static double calculateMortgage(int principal,
                                           float annualInterest, byte period){
        final byte PERCENT = 100;
        final byte YEAR = 12;

        float monthlyInterest = (annualInterest / PERCENT) / YEAR;
        short numberOfPayments = (short) (period * YEAR);

        double mortgage =  principal *
                ((monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments)) /
                        (Math.pow(1 + monthlyInterest, numberOfPayments) - 1));
        return mortgage;
    }
    public static double loanBalance(int principal,
                                     float annualInterest,
                                     byte period,
                                     short numberOfPaymentsMade){

        float monthlyInterest = (annualInterest / PERCENT) / YEAR;
        short numberOfPayments = (short) (period * YEAR);

        double balance = principal * (Math.pow(1 + monthlyInterest, numberOfPayments) -
                Math.pow(1 + monthlyInterest, numberOfPaymentsMade))/
                (Math.pow(1+monthlyInterest,numberOfPayments) - 1);
        return balance;
    }

    
}