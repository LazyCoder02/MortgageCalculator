package com.MortgageCalculator;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int principal = (int) Console.readNumber("Principal: ", 1000, 1_000_000);
        float annualInterest = (float) Console.readNumber("Annual Interest: ", 1, 30);
        byte period = (byte) Console.readNumber("Period (years): ", 1, 30);

        var calculator = new MortgageCalculator(principal,annualInterest,period);

        var report = new MortgageReport(calculator);
        report.printMortgage();
        report.printPaymentSchedule();
    }


}