package financemanager.ui;

import financemanager.service.AssetLiabilityManager;
import financemanager.service.FinanceAccountManager;
import financemanager.service.InvestmentAccountManager;

import java.util.Scanner;

public class MainMenu extends Menu {
    private final TransactionMenu transactionMenu;
    private final InvestmentMenu investmentMenu;
    private final AssetLiabilityMenu assetLiabilityMenu;
    private final AnalyticsMenu analyticsMenu;


    public MainMenu(Scanner scanner, FinanceAccountManager financeManager, InvestmentAccountManager investmentManager, AssetLiabilityManager assetManager) {
        super(scanner);

        this.transactionMenu = new TransactionMenu(scanner, financeManager);
        this.investmentMenu = new InvestmentMenu(scanner, investmentManager);
        this.assetLiabilityMenu = new AssetLiabilityMenu(scanner, assetManager);
        this.analyticsMenu = new AnalyticsMenu(scanner, financeManager, investmentManager, assetManager);
    }

    public void start() {
        boolean running = true;

        while (running) {
            System.out.println("Main Menu");
            System.out.println("1. Finance Accounts");
            System.out.println("2. Investment Accounts");
            System.out.println("3. Assets and Liabilities");
            System.out.println("4. Analytics");
            System.out.println("9. Exit");

            int input = getIntInput();

            switch(input) {

                case 1 -> transactionMenu.start();
                case 2 -> investmentMenu.start();
                case 3 -> assetLiabilityMenu.start();
                case 4 -> analyticsMenu.start();
                case 9 -> {
                    running = false;
                    System.out.println("Goodbye.");
                }
                default -> System.out.println("Please select a valid option.");

            }
        }
    }
}
