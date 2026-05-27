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
            ArrayList<FinanceAccount> accounts = financeAccountManager.getAccounts();

            System.out.println("Accounts:");
            System.out.println("");

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
                FinanceAccount account = accounts.get(choice + 1);
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
}
