package com.MortgageCalculator;

import java.text.NumberFormat;

public class MortgageReport {
    private MortgageCalculator calculator;
    private NumberFormat currencyInstance;

    public MortgageReport(MortgageCalculator calculator) {
        this.calculator = calculator;
        currencyInstance = NumberFormat.getCurrencyInstance();
    }

    public void printPaymentSchedule() {
        System.out.println("PAYMENT SCHEDULE \n----------------");
        for (double balance : calculator.getRemainingBalances()){
            currencyInstance = NumberFormat.getCurrencyInstance();
            System.out.println(currencyInstance.format(balance));
        }
    }

    public void printMortgage() {
        double mortgage = calculator.calculateMortgage();
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        System.out.println("MORTGAGE: " + " \n--------- \n " +
                "Monthly Payments: " + currency.format(mortgage));
    }
}
