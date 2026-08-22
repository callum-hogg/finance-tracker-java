package financemanager;

import financemanager.service.AnalyticsService;
import financemanager.service.AssetLiabilityManager;
import financemanager.service.FinanceAccountManager;
import financemanager.service.InvestmentAccountManager;
import financemanager.ui.AssetLiabilityMenu;
import financemanager.ui.MainMenu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FinanceAccountManager financeManager = new FinanceAccountManager();
        InvestmentAccountManager investmentManager = new InvestmentAccountManager();
        AssetLiabilityManager assetManager = new AssetLiabilityManager();
        AnalyticsService analyticsService = new AnalyticsService(financeManager, investmentManager, assetManager);
        MainMenu mainMenu = new MainMenu(scanner, financeManager, investmentManager, assetManager, analyticsService);
        mainMenu.start();
    }
}
