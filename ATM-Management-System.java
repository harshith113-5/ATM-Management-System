import java.util.Scanner;

class Account {
    private String accNumber;
    private String pin;
    private double balance;

    public Account(String accNumber, String pin, double initialBalance) {
        this.accNumber = accNumber;
        this.pin = pin;
        this.balance = initialBalance;
    }

    public boolean authenticate(String enteredPin) {
        return pin.equals(enteredPin);
    }

    public double getBalance() {
        return balance;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }
}

class ATM {
    public static void main(String[] args) {
        Account account = new Account("12345", "54321", 1000.0);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Your ATM");
        System.out.print("Enter your account number: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Enter your PIN: ");
        String pin = scanner.nextLine();

        if (!account.authenticate(pin)) {
            System.out.println("Authentication failed. Please try again.");
            return;
        }

        while (true) {
            System.out.println("\nATM Management System");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Quit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Your account balance is " + account.getBalance());
                    break;
                case 2:
                    System.out.print("Enter the deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    if (account.deposit(depositAmount)) {
                        System.out.println(depositAmount + " deposited successfully.");
                    } else {
                        System.out.println("Invalid amount for deposit.");
                    }
                    break;
                case 3:
                    System.out.print("Enter the withdrawal amount: ");
                    double withdrawalAmount = scanner.nextDouble();
                    if (account.withdraw(withdrawalAmount)) {
                        System.out.println(withdrawalAmount + " withdrawn successfully.");
                    } else {
                        System.out.println("Invalid amount for withdrawal or insufficient balance.");
                    }
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}
