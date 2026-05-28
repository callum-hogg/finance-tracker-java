package financemanager.ui;

import financemanager.enums.FinanceAccountType;
import financemanager.enums.TransactionType;
import financemanager.service.FinanceAccountManager;
import financemanager.utility.InputValidator;
import financemanager.model.Transaction;
import financemanager.model.FinanceAccount;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class TransactionMenu extends Menu {
    private FinanceAccountManager financeAccountManager;

    public TransactionMenu(Scanner scanner, FinanceAccountManager financeAccountManager) {
        super(scanner);
        this.financeAccountManager = financeAccountManager;
    }

    public void start() {

        boolean running = true;

        while (running) {
            ArrayList<FinanceAccount> accounts = new ArrayList<>(financeAccountManager.getAccounts());

            System.out.println();
            System.out.println("Accounts:");

            if (accounts.isEmpty()) {
                System.out.println("No accounts found.");
            }

            for (int i = 0; i < accounts.size(); i++) {
                System.out.println((i + 1) + ". " + accounts.get(i).getName());
            }

            System.out.println((accounts.size() + 1) + ". Add Account");
            System.out.println((accounts.size() + 2) + ". Back");
            System.out.print("Enter choice: ");

            int choice = getIntInput();

            if (choice >= 1 && choice <= accounts.size()) {
                FinanceAccount account = accounts.get(choice - 1);
                accountMenu(account);
            } else if (choice == accounts.size() + 1) {
                addAccount();
            } else if (choice == accounts.size() + 2) {
                running = false;
            } else {
                System.out.println("Please select a valid option.");
            }
        }
    }

    public void addAccount() {
        System.out.print("Enter account name: ");
        String name = getStringInput();

        FinanceAccountType accountType = getAccountType();

        System.out.print("Enter starting balance: ");
        double balance = getDoubleInput();

        financeAccountManager.addAccount(new FinanceAccount(name, accountType, balance));
    }

    public FinanceAccountType getAccountType() {
        while(true) {
            System.out.println("1. Current Account");
            System.out.println("2. Savings Account");
            System.out.print("Choose account type: ");

            int input = InputValidator.getValidInt(scanner);

            switch (input) {
                case 1 -> {
                    return FinanceAccountType.CURRENT_ACCOUNT;
                }
                case 2 -> {
                    return FinanceAccountType.SAVINGS_ACCOUNT;
                }
                default -> System.out.println("Please choose a valid option.");
            }
        }
    }

    public void accountMenu(FinanceAccount account) {
        boolean running = true;

        while(running) {
            System.out.println();
            System.out.println(account.getName());
            System.out.println("1. View Balance");
            System.out.println("2. Add Transaction");
            System.out.println("3. Remove Transaction");
            System.out.println("4. View Transactions");
            System.out.println("5. View Total Income");
            System.out.println("6. View Total Expense");
            System.out.println("7. Close Account");
            System.out.println("8. Back");
            System.out.print("Enter choice: ");

            int choice = getIntInput();

            switch (choice) {
                case 1 -> displayBalance(account);
                case 2 -> addTransaction(account);
                case 3 -> removeTransaction(account);
                case 4 -> displayTransactions(account);
                case 5 -> displayTotalIncome(account);
                case 6 -> displayTotalExpense(account);
                case 7 -> {
                    removeAccount(account);
                    running = false;
                }
                case 8 -> running = false;
                default -> System.out.println("Please choose a valid option.");
            }
        }
    }

    public void displayBalance(FinanceAccount account) {
        System.out.println("Current balance is: £" + account.getBalance());
    }

    public void addTransaction(FinanceAccount account) {
        System.out.print("Please enter amount: ");
        double amount = getDoubleInput();

        TransactionType type = getTransactionType();

        System.out.print("Please enter a description: ");
        String description = getStringInput();

        LocalDate date = getDateInput();

        account.addTransaction(new Transaction(amount, description, date, type));
    }

    public void removeTransaction(FinanceAccount account) {
        displayTransactions(account);
        System.out.print("Please enter ID of transaction to remove: ");
        int id = getIntInput();

        boolean removed = account.removeTransaction(id);

        if (removed) {
            System.out.println("Transaction removed.");
        } else {
            System.out.println("Transaction not found.");
        }
    }

    public void displayTransactions(FinanceAccount account) {
        ArrayList<Transaction> transactions = new ArrayList<>(account.getTransactions());

        if (transactions.isEmpty()) {
            System.out.println("No transactions found.");
            return;
        }

        for (Transaction transaction : transactions) {
            System.out.println(
                    "ID: " + transaction.getId() +
                            ", Type: " + transaction.getType() +
                            ", Amount: " + transaction.getAmount() +
                            ", Description: " + transaction.getCategory() +
                            ", Date: " + transaction.getDate());
        }
    }

    public void displayTotalIncome(FinanceAccount account) {
        System.out.println("Total income: £" + account.getAccountIncome());
    }

    public void displayTotalExpense(FinanceAccount account) {
        System.out.println("Total expense: £" + account.getAccountExpense());
    }

    public TransactionType getTransactionType() {
        while(true) {
            System.out.println("1. Income");
            System.out.println("2. Expense");
            System.out.print("Choose transaction type: ");

            int input = InputValidator.getValidInt(scanner);

            switch (input) {
                case 1 -> {
                    return TransactionType.INCOME;
                }
                case 2 -> {
                    return TransactionType.EXPENSE;
                }
                default -> System.out.println("Please choose a valid option.");
            }
        }
    }

    public void removeAccount(FinanceAccount account) {
        boolean removed = financeAccountManager.removeAccount(account.getId());

        if(removed) {
            System.out.println("Account closed.");
        } else {
            System.out.println("Could not close account.");
        }
    }
}
