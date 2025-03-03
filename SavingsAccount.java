public class SavingsAccount extends Account {

    public SavingsAccount(int accountNumber) {
        super(accountNumber);
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            double newBalance = getBalance() + amount;
            setBalance(newBalance);
            addTransaction(new Transaction("Deposit", amount));
            System.out.println("Deposit of " + amount + " successful. New balance: " + getBalance());
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && getBalance() >= amount) {
            double newBalance = getBalance() - amount;
            setBalance(newBalance);
            addTransaction(new Transaction("Withdrawal", amount));
            System.out.println("Withdrawal of " + amount + " successful. New balance: " + getBalance());
        } else {
            System.out.println("Insufficient funds or invalid withdrawal amount.");
        }
    }

    @Override
    public void checkBalance() {
        System.out.println("Account balance: " + getBalance());
    }
}
