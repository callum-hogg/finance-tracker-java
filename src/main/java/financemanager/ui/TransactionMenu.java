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
        System.out.println("Accounts:");
        System.out.println("");
    }

    public FinanceAccount selectAccount() {
        ArrayList<FinanceAccount> accounts = financeAccountManager.getAccounts();

        if (accounts.isEmpty()) {
            System.out.println("No accounts found.");
            return null;
        }

        for (int i = 0; i < accounts.size(); i++) {
            System.out.println((i + 1) + ". " + accounts.get(i).getName());
        }

        System.out.println((accounts.size() + 1) + ". Add Account");
        System.out.println((accounts.size() + 2) + ". Back");

        int choice = getIntInput();

        if ((choice == accounts.size() + 1) || (choice == accounts.size() + 2)) {
            return null;
        }

        return accounts.get(choice - 1);
    }




}
