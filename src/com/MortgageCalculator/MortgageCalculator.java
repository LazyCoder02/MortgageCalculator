package com.MortgageCalculator;

public class MortgageCalculator {
    private final byte PERCENT = 100;
    private final byte YEAR = 12;

    private int principal;
    private float annualInterest;
    private byte period;

    public MortgageCalculator(int principal, float annualInterest, byte period) {
        this.principal = principal;
        this.annualInterest = annualInterest;
        this.period = period;
    }

    public double calculateMortgage() {

        float monthlyInterest = getMonthlyInterest();
        short numberOfPayments = getNumberOfPayments();

        double mortgage = principal *
                ((monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments)) /
                        (Math.pow(1 + monthlyInterest, numberOfPayments) - 1));

        return mortgage;
    }

    public double loanBalance(short numberOfPaymentsMade){

        float monthlyInterest = getMonthlyInterest();
        short numberOfPayments = getNumberOfPayments();

        return principal * (Math.pow(1 + monthlyInterest, numberOfPayments) -
                Math.pow(1 + monthlyInterest, numberOfPaymentsMade))/
                (Math.pow(1+monthlyInterest,numberOfPayments) - 1);
    }

    public double[] getRemainingBalances(){
        var balances = new double [getNumberOfPayments()];
        for(short month = 1; month <= balances.length; month++) {
            balances[month - 1] = loanBalance(month);
        }
        return balances;
    }
    private short getNumberOfPayments() {
        return (short) (period * (byte) 12);
    }

    private float getMonthlyInterest() {
        return (annualInterest / PERCENT) / YEAR;
    }

    public short getPeriod() {

        return period;
    }


}
