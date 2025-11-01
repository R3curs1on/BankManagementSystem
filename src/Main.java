import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    // Initialize services as final static fields
    private static final Scanner sc = new Scanner(System.in);
    private static final AccountMap accountMap = new AccountMap();
    private static final Login login = new Login(accountMap);

    public static void main(String[] args) {
        // Main application loop
        while (true) {
            System.out.println("\n--- Welcome to the Bank ---");
            System.out.println("(1). Create Account");
            System.out.println("(2). Login");
            System.out.println("(3). Exit");
            System.out.print("Enter your choice: ");

            int choice = -1;
            try {
                choice = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
            } finally {
                sc.nextLine(); // Always consume the newline character
            }

            switch (choice) {
                case 1:
                    createAccountChoice();
                    break;
                case 2:
                    loginChoice();
                    break;
                case 3:
                    System.out.println("Exiting application. Goodbye!");
                    sc.close();
                    return; // Exit the main method
                default:
                    if (choice != -1) { // Don't print for the catch-block case
                        System.out.println("Invalid choice. Try again.");
                    }
                    break;
            }
        }
    }

    /**
     * Handles the new account creation flow.
     * It now uses the NewAccount constructor and adds the account to the AccountMap.
     */
    private static void createAccountChoice() {
        try {
            System.out.print("Enter name: ");
            String name = sc.nextLine();

            System.out.print("Enter password (min 4 characters): ");
            String password = sc.nextLine();

            System.out.print("Enter initial balance: ");
            long balance = 0;
            try {
                balance = sc.nextLong();
            } catch (InputMismatchException e) {
                System.out.println("Invalid amount. Setting balance to 0.");
            } finally {
                sc.nextLine(); // Consume newline
            }

            // Create the account using the new constructor
            // This will throw IllegalArgumentException if name/password are invalid
            NewAccount newAccount = new NewAccount(name, password, balance);

            // Add to our HashMap-based storage
            accountMap.addAccount(newAccount);

            System.out.println("Successfully created Account!");
            System.out.println("Your new Account Number is: " + newAccount.getAccountNumber());

        } catch (IllegalArgumentException e) {
            // Catches validation errors from NewAccount constructor
            System.out.println("Account creation failed: " + e.getMessage());
        }
    }

    /**
     * Handles the user login flow.
     * It now uses the Login.authenticate() method.
     */
    private static void loginChoice() {
        System.out.print("Enter Account Number: ");
        String accountNumber = sc.nextLine();

        System.out.print("Enter password: ");
        String password = sc.nextLine();

        // Use the new authentication method
        NewAccount authenticatedAccount = login.authenticate(accountNumber, password);

        if (authenticatedAccount != null) {
            System.out.println("\nLogin successful! Welcome, " + authenticatedAccount.getName());
            // Move the logged-in user to their account menu
            showAccountMenu(authenticatedAccount);
        } else {
            System.out.println("Login failed. Invalid account number or password.");
        }
    }

    /**
     * A new, separate menu for a user who is already logged in.
     * This replaces the logic that was inside your old loginChoice().
     *
     * @param account The NewAccount object of the logged-in user.
     */
    private static void showAccountMenu(NewAccount account) {
        while (true) {
            System.out.println("\n--- Account Menu ---");
            System.out.println("Account: " + account.getAccountNumber());
            System.out.println("(1). Check Balance");
            System.out.println("(2). Credit (Deposit)");
            System.out.println("(3). Debit (Withdraw)");
            System.out.println("(4). Delete Account");
            System.out.println("(5). Logout");
            System.out.print("Enter your choice: ");

            int choice = -1;
            try {
                choice = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
            } finally {
                sc.nextLine(); // Consume newline
            }

            switch (choice) {
                case 1:
                    // Use the getter from NewAccount
                    System.out.println("Your current balance is: " + account.getBalance());
                    break;
                case 2:
                    handleCredit(account);
                    break;
                case 3:
                    handleDebit(account);
                    break;
                case 4:
                    // Pass the account map to handle deletion
                    if (handleDelete(account)) {
                        return; // Exit account menu if account was deleted
                    }
                    break;
                case 5:
                    System.out.println("Logging out...");
                    return; // Exit this menu and go back to the main menu
                default:
                    if (choice != -1) {
                        System.out.println("Invalid choice. Try again.");
                    }
                    break;
            }
        }
    }

    /**
     * Helper method to manage crediting the account.
     */
    private static void handleCredit(NewAccount account) {
        try {
            System.out.print("Enter amount to credit: ");
            long amount = sc.nextLong();
            sc.nextLine(); // Consume newline

            // Use the validation logic built into your NewAccount class
            account.credit(amount);
            System.out.println("Credit successful. New balance: " + account.getBalance());

        } catch (InputMismatchException e) {
            System.out.println("Invalid amount. Please enter a number.");
            sc.nextLine(); // Clear the bad input
        } catch (IllegalArgumentException e) {
            // Catches validation errors from account.credit()
            System.out.println("Credit failed: " + e.getMessage());
        }
    }

    /**
     * Helper method to manage debiting the account.
     */
    private static void handleDebit(NewAccount account) {
        try {
            System.out.print("Enter amount to debit: ");
            long amount = sc.nextLong();
            sc.nextLine(); // Consume newline

            // Use the validation logic built into your NewAccount class
            account.debit(amount);
            System.out.println("Debit successful. New balance: " + account.getBalance());

        } catch (InputMismatchException e) {
            System.out.println("Invalid amount. Please enter a number.");
            sc.nextLine(); // Clear the bad input
        } catch (IllegalArgumentException e) {
            // Catches validation errors from account.debit() (e.g., "Insufficient balance")
            System.out.println("Debit failed: " + e.getMessage());
        }
    }

    /**
     * Helper method to manage deleting an account.
     * @return true if the account was deleted, false otherwise.
     */
    private static boolean handleDelete(NewAccount account) {
        System.out.print("Are you sure you want to delete this account? This is irreversible. (yes/no): ");
        String confirmation = sc.nextLine();

        if (confirmation.equalsIgnoreCase("yes")) {
            accountMap.removeAccount(account.getAccountNumber());
            System.out.println("Account deleted.");
            return true; // Signal to exit the account menu
        } else {
            System.out.println("Account deletion cancelled.");
            return false;
        }
    }
}