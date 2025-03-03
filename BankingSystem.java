import java.util.Scanner;

public class BankingSystem {

    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Advanced Banking System!");
        System.out.print("Enter your name: ");
        String userName = scanner.nextLine();

        System.out.println("Enter account type:");
        System.out.println("1. Savings");
        System.out.println("2. Checking");
        System.out.print("Enter your choice: ");
        int accountTypeChoice = scanner.nextInt();
        System.out.print("\033[H\033[2J");
        scanner.nextLine(); // Consume newline

        Account account = null;
        int accountNumber = 12345; // Generate a unique account number
        if (accountTypeChoice == 1) {
            account = new SavingsAccount(accountNumber);
        } else if (accountTypeChoice == 2) {
            account = new CheckingAccount(accountNumber);
        } else {
            System.out.println("Invalid account type.");
            return;
        }

        System.out.println("Account created successfully. Account number: " + accountNumber);

        while (true) {
            System.out.println("\nChoose an action:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. View Transaction History");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    clearConsole();
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    account.deposit(depositAmount);
                    break;
                case 2:
                    clearConsole();
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawalAmount = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    account.withdraw(withdrawalAmount);
                    break;
                case 3:
                    clearConsole();
                    account.checkBalance();
                    break;
                case 4:
                    clearConsole();
                    System.out.println("Transaction History:");
                    for (Transaction transaction : account.getTransactionHistory()) {
                        System.out.println(transaction);
                    }
                    break;
                case 5:
                    clearConsole();
                    System.out.println("Thank you for using the Advanced Banking System!");
                    return;
                default:
                    clearConsole();
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
