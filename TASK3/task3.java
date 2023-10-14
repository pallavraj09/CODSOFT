import java.util.Scanner;

public class task3 {
    public static void main(String[] args) {
        BankAcc newAcc = new BankAcc(2000);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an action:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Display Balance");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    newAcc.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter the amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    newAcc.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.println("Fetching balance...");
                                        System.out.println("Current Balance: " + newAcc.getBalance());
                    break;
                case 4:
                    System.out.println("Thank YOU ! Visit Again ");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please select a valid action.");
            }
        }
    }
}

class BankAcc {
    private double balance;

    public BankAcc(double initialBalance) {
        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. New balance is " + balance);
        } else {
            System.out.println("Invalid deposit amount. Please enter a positive amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance is : " + balance);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance.");
        }
    }
}
