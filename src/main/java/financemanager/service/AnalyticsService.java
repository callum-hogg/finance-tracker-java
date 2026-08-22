package financemanager.service;

import java.time.LocalDate;

import financemanager.enums.TransactionType;
import financemanager.model.Transaction;
import financemanager.model.FinanceAccount;

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

    public double getTotalFinanceAccountValue() {
        return financeAccountManager.getTotalBalance();
    }

    public double getTotalInvestmentValue() {
        return investmentAccountManager.getTotalValue();
    }

    public double getTotalAssetValue() {
        return assetLiabilityManager.getTotalAssetValue();
    }

    public double getTotalLiabilityValue() {
        return assetLiabilityManager.getTotalLiabilityValue();
    }

    public double getMonthlySpend(LocalDate month) {
        double total = 0;

        for (FinanceAccount financeAccount : financeAccountManager.getAccounts()) {

            for (Transaction transaction : financeAccount.getTransactions()) {

                if (transaction.getType() == TransactionType.EXPENSE && transaction.getDate().getMonth() == month.getMonth() && transaction.getDate().getYear() == month.getYear()) {
                    total += total;
                }
            }
        }
        return total;
    }


}
