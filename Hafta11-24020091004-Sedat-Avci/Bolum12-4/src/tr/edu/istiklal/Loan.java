package tr.edu.istiklal;


public class Loan {

    private double annualInterestRate;
    private int numberOfYears;
    private double loanAmount;

    public Loan(){}
    
    public Loan(double annualInterestRate, int numberOfYears, double loanAmount) {

        if (annualInterestRate <= 0)
            throw new IllegalArgumentException("Faiz orani 0 veya negatif olamaz");

        if (numberOfYears <= 0)
            throw new IllegalArgumentException("Yil sayisi 0 veya negatif olamaz");

        if (loanAmount <= 0)
            throw new IllegalArgumentException("Kredi tutari 0 veya negatif olamaz");

        this.annualInterestRate = annualInterestRate;
        this.numberOfYears = numberOfYears;
        this.loanAmount = loanAmount;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public int getNumberOfYears() {
        return numberOfYears;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    /**
     * @param annualInterestRate the annualInterestRate to set
     */
    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    /**
     * @param numberOfYears the numberOfYears to set
     */
    public void setNumberOfYears(int numberOfYears) {
        this.numberOfYears = numberOfYears;
    }

    /**
     * @param loanAmount the loanAmount to set
     */
    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }
    
    
}

