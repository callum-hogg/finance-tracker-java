package financemanager.ui;

import financemanager.model.FinanceAccount;
import financemanager.service.AnalyticsService;
import financemanager.service.AssetLiabilityManager;
import financemanager.service.FinanceAccountManager;
import financemanager.service.InvestmentAccountManager;

import java.util.Scanner;

public class AnalyticsMenu extends Menu {

    private AnalyticsService analyticsService;

    public AnalyticsMenu(Scanner scanner, AnalyticsService analyticsService) {
        super(scanner);
        this.analyticsService = analyticsService;
    }

    public void start() {
        boolean running = true;

        while (running) {
            System.out.println("Analytics");
            System.out.println("1: Finance Account Analytics");
            System.out.println("2: Investment Account Analytics");
            System.out.println("3: Net Worth Analytics");
            System.out.println("9: Back");
            System.out.print("Enter choice: ");

            int input = getIntInput();

            switch(input) {

                case 1 -> FinanceAccountAnalytics();
                case 2 -> InvestmentAccountAnalytics();
                case 3 -> NetWorthAnalytics();
                case 9 -> {
                    running = false;
                    System.out.println("Goodbye.");
                }
                default -> System.out.println("Please select a valid option.");
            }
        }
    }

    public void FinanceAccountAnalytics() {

    }

    public void InvestmentAccountAnalytics() {

    }

    public void NetWorthAnalytics() {
        boolean running = true;
        while (running) {
            System.out.println("Net Worth Analytics");
            System.out.println("1: View Net Worth");
            System.out.println("2: Net Worth Breakdown");
            System.out.println("9: Back");
            System.out.print("Enter choice: ");

            int input = getIntInput();

            switch (input) {
                case 1 -> displayNetWorth();
                case 2 -> displayNetWorthBreakdown();
                case 9 -> running = false;
                default -> System.out.println("Please select a valid option.");
            }
        }
    }

    public void displayNetWorth() {
        System.out.print("Current Net Worth is: £");
        System.out.println(analyticsService.calculateNetWorth());
    }

    public void displayNetWorthBreakdown() {
        System.out.println("Net Worth Breakdown: ");
        System.out.println();
        System.out.println("     Finance Accounts : £" + analyticsService.getTotalFinanceAccountValue());
        System.out.println("     Investments: £" + analyticsService.getTotalInvestmentValue());
        System.out.println("     Assets: £" + analyticsService.getTotalAssetValue());
        System.out.println("     Liabilities: -£" + analyticsService.getTotalLiabilityValue());
    }
}
