package financemanager.ui;

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
        System.out.println("Accounts:");
        System.out.println("");
    }
}
