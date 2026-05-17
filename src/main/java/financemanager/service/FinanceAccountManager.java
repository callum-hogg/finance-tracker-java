package financemanager.service;

import financemanager.model.FinanceAccount;

import java.util.ArrayList;
import java.util.List;

public class FinanceAccountManager {

    private final List<FinanceAccount> accounts = new ArrayList<>();

    public FinanceAccountManager() {
    }

    public void addAccount(FinanceAccount account) {
        accounts.add(account);
    }

    public boolean removeAccount(int id) {
        return accounts.removeIf(account -> account.getId() == id);
    }

    public ArrayList<FinanceAccount> getAccounts() {
        return new ArrayList<>(accounts);
    }

    public double getTotalBalance() {
        double totalBalance = 0;
        for (FinanceAccount account : accounts) {
            totalBalance += account.getBalance();
        }
        return totalBalance;
    }

}
