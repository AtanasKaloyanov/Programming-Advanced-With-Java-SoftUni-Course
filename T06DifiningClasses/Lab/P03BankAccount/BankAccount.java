package T06DifiningClasses.Lab.P03BankAccount;

public class BankAccount {
    private int id;
    private double balance;
    private static double interestRate = 0.02;

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public static void setInterestRate(double interest) {
        BankAccount.interestRate = interest;
    }

    public double getInterest(int years) {
        double addedSumForYear = this.balance * interestRate;
        return addedSumForYear * years;
    }

    public void deposit(double amount) {
        double oldSum = this.getBalance();
        double newSum = oldSum + amount;
        this.setBalance(newSum);
    }
}
