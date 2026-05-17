package financemanager.model;

import financemanager.enums.InvestmentAccountType;

import java.util.ArrayList;
import java.util.List;

public class InvestmentAccount {

    private static int nextId = 1;
    private int id;
    private String name;
    private List<Investment> investments;
    private InvestmentAccountType accountType;

    public InvestmentAccount(String name, InvestmentAccountType accountType) {
        this.id = nextId++;
        this.name = name;
        this.investments = new ArrayList<>();
        this.accountType = accountType;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getAccountValue() {
        double value = 0;
        for (Investment investment : investments) {
            value += investment.getValue();
        }
        return value;
    }

    public InvestmentAccountType getAccountType() {
        return accountType;
    }

    public ArrayList<Investment> getInvestments() {
        return new ArrayList<>(investments);
    }

    public void addInvestment(Investment investment) {
        investments.add(investment);
    }

    public boolean removeInvestment(int id) {
        return investments.removeIf(investment -> investment.getId() == id);
    }

}
