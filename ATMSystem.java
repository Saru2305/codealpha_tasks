import java.util.Scanner;

// Class to represent User's Bank Account
class BankAccount {
    private double balance;

    // Constructor
    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. Amount: ₹" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful. Amount: ₹" + amount);
        }
    }

    // Check balance method
    public double getBalance() {
        return balance;
    }
}

// Class to represent ATM Machine
class ATM {
    private BankAccount account;
    private Scanner sc = new Scanner(System.in);

    // Constructor to connect ATM with BankAccount
    public ATM(BankAccount account) {
        this.account = account;
    }

    // ATM User Interface
    public void start() {
        int choice;

        do {
            System.out.println("\n----- ATM MENU -----");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = sc.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;

                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = sc.nextDouble();
                    account.deposit(depositAmount);
                    break;

                case 3:
                    System.out.println("Current Balance: ₹" + account.getBalance());
                    break;

                case 4:
                    System.out.println("Thank you for using ATM!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 4);
    }
}

// Main Class
public class ATMSystem {
    public static void main(String[] args) {

        // Create BankAccount object
        BankAccount userAccount = new BankAccount(5000); // Initial balance

        // Create ATM object and connect with account
        ATM atm = new ATM(userAccount);

        // Start ATM
        atm.start();
    }
}
