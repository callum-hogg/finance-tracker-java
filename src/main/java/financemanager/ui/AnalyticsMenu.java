package financemanager.ui;

import financemanager.model.FinanceAccount;
import financemanager.service.AssetLiabilityManager;
import financemanager.service.FinanceAccountManager;
import financemanager.service.InvestmentAccountManager;

import java.util.Scanner;

public class AnalyticsMenu extends Menu {

    private FinanceAccountManager financeAccountManager;
    private InvestmentAccountManager investmentAccountManager;
    private AssetLiabilityManager assetLiabilityManager;

    public AnalyticsMenu(Scanner scanner, FinanceAccountManager financeAccountManager, InvestmentAccountManager investmentAccountManager, AssetLiabilityManager assetLiabilityManager) {
        super(scanner);
        this.financeAccountManager = financeAccountManager;
        this.investmentAccountManager = investmentAccountManager;
        this.assetLiabilityManager = assetLiabilityManager;
    }

    public void start() {
        boolean running = true;

        while (running) {
            System.out.println("Please select an option.");
            System.out.println("1: Finance Account Analytics");
            System.out.println("2: Investment Account Analytics");
            System.out.println("3: Asset & Liability Analytics");
            System.out.println("4: Net Worth Analytics");
            System.out.println("5: Back");

            int choice = getIntInput();

            if (choice == 1) {
                FinanceAccountAnalytics();
            } else if (choice == 2) {
                InvestmentAccountAnalytics();
            } else if (choice == 3) {
                AssetLiabilityAnalytics();
            } else if (choice == 4) {
                NetWorthAnalytics();
            } else if (choice == 5) {
                running = false;
            } else {
                System.out.println("Please choose a valid option.");
            }
        }
    }

    public void FinanceAccountAnalytics() {

    }

    public void InvestmentAccountAnalytics() {

    }

    public void AssetLiabilityAnalytics() {

    }

    public void NetWorthAnalytics() {

    }
}
