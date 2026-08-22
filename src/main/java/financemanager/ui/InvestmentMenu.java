package financemanager.ui;

import financemanager.enums.InvestmentAccountType;
import financemanager.enums.InvestmentType;
import financemanager.model.Investment;
import financemanager.model.InvestmentAccount;
import financemanager.service.InvestmentAccountManager;
import financemanager.utility.InputValidator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class InvestmentMenu extends Menu {

    private InvestmentAccountManager investmentAccountManager;

    public InvestmentMenu(Scanner scanner, InvestmentAccountManager investmentAccountManager) {
        super(scanner);
        this.investmentAccountManager = investmentAccountManager;
    }

    public void start() {
        boolean running = true;

        while (running) {

            ArrayList<InvestmentAccount> accounts = new ArrayList<>(investmentAccountManager.getAccounts());
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

            int input = getIntInput();

            if (input >= 1 && input <= accounts.size()) {
                InvestmentAccount account = accounts.get(input - 1);
                accountMenu(account);
            } else if (input == accounts.size() + 1) {
                addAccount();
            } else if (input == accounts.size() + 2) {
                running = false;
            } else {
                System.out.println("Please select a valid option.");
            }
        }
    }

    public void addAccount() {
        System.out.print("Enter account name: ");
        String name = getStringInput();

        InvestmentAccountType accountType = getAccountType();

        investmentAccountManager.addAccount(new InvestmentAccount(name, accountType));
    }

    public InvestmentAccountType getAccountType() {
        while(true) {
            System.out.println("1. ISA");
            System.out.println("2. Pension");
            System.out.println("3. General Investment Account");
            System.out.print("Choose account type: ");

            int input = InputValidator.getValidInt(scanner);

            switch (input) {
                case 1 -> {
                    return InvestmentAccountType.ISA;
                }
                case 2 -> {
                    return InvestmentAccountType.PENSION;
                }
                case 3 -> {
                    return InvestmentAccountType.GENERAL_INVESTMENT_ACCOUNT;
                }
                default -> System.out.println("Please choose a valid option.");
            }
        }
    }

    public void accountMenu(InvestmentAccount account) {
        boolean running = true;

        while(running) {
            System.out.println();
            System.out.println(account.getName());
            System.out.println("1. View Total Value");
            System.out.println("2. Add Investment");
            System.out.println("3. Remove Investment");
            System.out.println("4. View Investments");
            System.out.println("5. Close Account");
            System.out.println("6. Back");
            System.out.print("Enter choice: ");

            int choice = getIntInput();

            switch (choice) {
                case 1 -> displayTotalValue(account);
                case 2 -> addInvestment(account);
                case 3 -> removeInvestment(account);
                case 4 -> displayInvestments(account);
                case 5 -> {
                    removeAccount(account);
                    running = false;
                }
                case 6 -> running = false;
            }
        }
    }

    public void displayTotalValue(InvestmentAccount account) {
        System.out.println("Total Value is: £" + investmentAccountManager.getTotalValue());
    }

    public void addInvestment(InvestmentAccount account) {
        InvestmentType type = getInvestmentType();

        System.out.print("Enter name: ");
        String name = getStringInput();

        System.out.print("Enter identifier: ");
        String identifier = getStringInput();

        System.out.print("Enter number of shares: ");
        double numberOfShares = getDoubleInput();

        System.out.print("Enter purchase price: ");
        double purchasePrice = getDoubleInput();

        System.out.print("Enter current price: ");
        double currentPrice = getDoubleInput();

        System.out.println("Enter date of purchase");
        LocalDate date = getDateInput();

        account.addInvestment(new Investment(type, name, identifier, numberOfShares, purchasePrice, currentPrice, date));
    }

    public void removeInvestment(InvestmentAccount account) {
        displayInvestments(account);
        System.out.print("Please enter ID of Investment to remove: ");
        int id = getIntInput();

        boolean removed = account.removeInvestment(id);

        if (removed) {
            System.out.println("Investment removed.");
        } else {
            System.out.println("Investment not found.");
        }
    }

    public void displayInvestments(InvestmentAccount account) {
        ArrayList<Investment> investments = new ArrayList<>(account.getInvestments());

        if (investments.isEmpty()) {
            System.out.println("No investments found.");
        }

        for (Investment investment : investments) {
            System.out.println(investment.toString());
        }
    }

    public InvestmentType getInvestmentType() {
        while(true) {
            System.out.println("1. Stock");
            System.out.println("2. ETF");
            System.out.println("3. Fund");
            System.out.print("Choose investment type: ");

            int input = InputValidator.getValidInt(scanner);

            switch (input) {
                case 1 -> {
                    return InvestmentType.STOCK;
                }
                case 2 -> {
                    return InvestmentType.ETF;
                }
                case 3 -> {
                    return InvestmentType.FUND;
                }
                default -> System.out.println("Please choose a valid option.");
            }
        }
    }

    public void removeAccount(InvestmentAccount account) {
        boolean removed = investmentAccountManager.removeAccount(account.getId());

        if(removed) {
            System.out.println("Account closed.");
        } else {
            System.out.println("Could not close account.");
        }
    }
}
