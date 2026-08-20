package financemanager.service;

public class AnalyticsService {
    private FinanceAccountManager financeAccountManager;
    private InvestmentAccountManager investmentAccountManager;
    private AssetLiabilityManager assetLiabilityManager;

    public AnalyticsService(FinanceAccountManager financeAccountManager, InvestmentAccountManager investmentAccountManager, AssetLiabilityManager assetLiabilityManager) {
        this.financeAccountManager = financeAccountManager;
        this.investmentAccountManager = investmentAccountManager;
        this.assetLiabilityManager = assetLiabilityManager;
    }

    public double calculateNetWorth() {
        return financeAccountManager.getTotalBalance() + investmentAccountManager.getTotalValue() + assetLiabilityManager.getTotalAssetValue() - assetLiabilityManager.getTotalLiabilityValue();
    }
}
