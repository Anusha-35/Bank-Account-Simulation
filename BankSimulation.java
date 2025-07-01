import java.util.*;

class Account {
    private String accountHolder;
    private String password;
    private double balance;
    private List<String> transactions;

    public Account(String accountHolder, String password, double initialBalance) {
        this.accountHolder = accountHolder;
        this.password = password;
        this.balance = initialBalance;
        this.transactions = new ArrayList<>();
        transactions.add("Account created for " + accountHolder + " with initial balance: " + initialBalance);
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public boolean checkPassword(String enteredPassword) {
        return this.password.equals(enteredPassword);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactions.add("Deposited: " + amount + " | New Balance: " + balance);
            System.out.println("Deposit successful. New balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactions.add("Withdrew: " + amount + " | New Balance: " + balance);
            System.out.println("Withdrawal successful. New balance: " + balance);
        } else {
            System.out.println("Insufficient balance or invalid amount!");
        }
    }

    public void printTransactionHistory() {
        System.out.println("\nTransaction History for " + accountHolder + ":");
        for (String t : transactions) {
            System.out.println(t);
        }
    }
}

public class BankSimulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Account> accounts = new HashMap<>();

        boolean mainRunning = true;
        while (mainRunning) {
            System.out.println("\n===== Welcome to the Bank System =====");
            System.out.println("1. Create Account");
            System.out.println("2. Login to Existing Account");
            System.out.println("3. Exit");
            System.out.print("Your choice: ");

            int mainChoice = scanner.nextInt();
            scanner.nextLine();  // consume newline

            switch (mainChoice) {
                case 1:
                    System.out.print("Enter new account holder name: ");
                    String newName = scanner.nextLine();
                    if (accounts.containsKey(newName)) {
                        System.out.println("Account with name '" + newName + "' already exists!");
                    } else {
                        System.out.print("Set a password for the account: ");
                        String password = scanner.nextLine();
                        System.out.print("Enter initial balance: ");
                        double initialBalance = scanner.nextDouble();
                        scanner.nextLine(); // consume newline
                        accounts.put(newName, new Account(newName, password, initialBalance));
                        System.out.println("Account created successfully for " + newName + "!");
                    }
                    break;
                case 2:
                    System.out.print("Enter account holder name: ");
                    String existingName = scanner.nextLine();
                    if (!accounts.containsKey(existingName)) {
                        System.out.println("No account found with name '" + existingName + "'.");
                    } else {
                        System.out.print("Enter password: ");
                        String enteredPassword = scanner.nextLine();
                        Account account = accounts.get(existingName);
                        if (!account.checkPassword(enteredPassword)) {
                            System.out.println("Incorrect password! Access denied.");
                        } else {
                            System.out.println("Logged in as " + existingName + ".");
                            boolean accountRunning = true;
                            while (accountRunning) {
                                System.out.println("\n1. Deposit");
                                System.out.println("2. Withdraw");
                                System.out.println("3. Show Transaction History");
                                System.out.println("4. Logout");
                                System.out.print("Your choice: ");

                                int accChoice = scanner.nextInt();
                                switch (accChoice) {
                                    case 1:
                                        System.out.print("Enter deposit amount: ");
                                        double depositAmount = scanner.nextDouble();
                                        account.deposit(depositAmount);
                                        break;
                                    case 2:
                                        System.out.print("Enter withdrawal amount: ");
                                        double withdrawAmount = scanner.nextDouble();
                                        account.withdraw(withdrawAmount);
                                        break;
                                    case 3:
                                        account.printTransactionHistory();
                                        break;
                                    case 4:
                                        System.out.println("Logging out of " + existingName + "'s account...");
                                        accountRunning = false;
                                        break;
                                    default:
                                        System.out.println("Invalid choice! Please enter 1-4.");
                                }
                            }
                        }
                    }
                    break;
                case 3:
                    System.out.println("Thank you for using the Bank System. Goodbye!");
                    mainRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice! Please enter 1-3.");
            }
        }

        scanner.close();
    }
}
