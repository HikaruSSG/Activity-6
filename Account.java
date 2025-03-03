import java.util.ArrayList;
import java.util.List;

public abstract class Account {
    private int accountNumber;
    private double balance;
    private List<Transaction> transactionHistory;

    public Account(int accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;
        this.transactionHistory = new ArrayList<>();
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public List<Transaction> getTransactionHistory() {
        return transactionHistory;
    }

    public abstract void deposit(double amount);

    public abstract void withdraw(double amount);

    public abstract void checkBalance();

    public void addTransaction(Transaction transaction) {
        transactionHistory.add(transaction);
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
