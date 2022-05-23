package T06DifiningClasses.Lab.P03BankAccount;

public class BankAccount {
    private int id;
    private double balance;
    private static double interestRate = 0.02;

    private static int acoountCounter = 0;

    public int getId() {
        return id;
    }

    public static int getAcoountCounter() {
        return acoountCounter;
    }

    public double getInterestRate(int years) {
        return years * interestRate * this.balance;
    }

    public static double getInterestRate() {
        return interestRate;
    }

    public static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;
    }

    public BankAccount() {
        acoountCounter++;
        this.id = acoountCounter;
    }

    public void deposit (double money) {
        this.balance += money;
    }
}
