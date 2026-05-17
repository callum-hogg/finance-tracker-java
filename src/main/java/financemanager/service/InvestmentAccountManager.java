package financemanager.service;

import financemanager.model.InvestmentAccount;

import java.util.ArrayList;
import java.util.List;

public class InvestmentAccountManager {

    private List<InvestmentAccount> accounts;

    public InvestmentAccountManager() {
        this.accounts = new ArrayList<>();
    }

    public void addAccount(InvestmentAccount account) {
        accounts.add(account);
    }

    public boolean removeAccount(int id) {
        return accounts.removeIf(account -> account.getId() == id);
    }

    public ArrayList<InvestmentAccount> getAccounts() {
        return new ArrayList<>(accounts);
    }

    public double getTotalValue() {
        double total = 0;
        for (InvestmentAccount account : accounts) {
            total += account.getAccountValue();
        }
        return total;
    }
}
