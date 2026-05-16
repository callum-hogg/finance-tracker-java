package financemanager.ui;

import financemanager.enums.TransactionType;
import financemanager.filter.InputValidator;
import financemanager.model.Transaction;
import financemanager.service.TransactionManager;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class TransactionMenu {
    private TransactionManager manager;
    private Scanner scanner;

    public TransactionMenu() {
        scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Welcome to the Finance Tracker!");
        System.out.print("Please enter the starting balance: ");
        double startingBalance = getDoubleInput();
        manager = new TransactionManager(startingBalance);
        runMenu();
    }

    public void runMenu() {
        while(true) {
            System.out.println("Please choose one of the following options: ");
            System.out.println("1. View Balance");
            System.out.println("2. Add financemanager.model.Transaction");
            System.out.println("3. Remove financemanager.model.Transaction");
            System.out.println("4. View Transactions");
            System.out.println("5. View Total Income");
            System.out.println("6. View Total Expense");
            System.out.println("7. Exit");

            int choice = getIntInput();

            switch (choice) {
                case 1 -> displayBalance();
                case 2 -> addTransaction();
                case 3 -> removeTransaction();
                case 4 -> displayTransactions();
                case 5 -> displayTotalIncome();
                case 6 -> displayTotalExpense();
                case 7 -> exit();
                default -> System.out.println("Please choose a valid option.");
            }
        }
    }

    public void displayBalance() {
        System.out.println("Current balance is: " + manager.getBalance());
    }

    public void addTransaction() {
        System.out.print("Please enter amount: ");
        double amount = getDoubleInput();

        TransactionType type = getTransactionType();

        System.out.print("Please enter a description");
        String description = scanner.nextLine();

        LocalDate date = getDateInput();

        Transaction transaction = new Transaction(amount, description, date, type);

        manager.addTransaction(transaction);
    }

    public void removeTransaction() {
        System.out.print("Please enter ID of transaction to remove: ");
        int id = getIntInput();

        boolean removed = manager.removeTransaction(id);

        if (removed) {
            System.out.println("Transaction removed.");
        } else {
            System.out.println("Transaction not found.");
        }
    }

    public void displayTransactions() {
        ArrayList<Transaction> transactions = manager.getTransactions();

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

    public void displayTotalIncome() {
        System.out.println("Total income: " + manager.getTotalIncome());
    }

    public void displayTotalExpense() {
        System.out.println("Total expense: " + manager.getTotalExpense());
    }

    public void exit() {
        System.out.println("Goodbye");
        System.exit(0);
    }

    public TransactionType getTransactionType() {
        while(true) {
            System.out.println("Please choose one of the following options: ");
            System.out.println("1. Income");
            System.out.println("2. Expense");

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

    public int getIntInput() {
        return InputValidator.getValidInt(scanner);
    }

    public double getDoubleInput() {
        return InputValidator.getValidDouble(scanner);
    }

    public LocalDate getDateInput() {
        return InputValidator.getValidDate(scanner);
    }
}
