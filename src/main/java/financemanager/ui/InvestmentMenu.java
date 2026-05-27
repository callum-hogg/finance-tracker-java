package financemanager.ui;

import financemanager.service.FinanceAccountManager;
import financemanager.service.InvestmentAccountManager;

import java.util.Scanner;

public class InvestmentMenu extends Menu {

    private InvestmentAccountManager investmentAccountManager;

    public InvestmentMenu(Scanner scanner, InvestmentAccountManager investmentAccountManager) {
        super(scanner);
        this.investmentAccountManager = investmentAccountManager;
    }

    public void start() {
        System.out.println("Accounts:");
        System.out.println("");
    }
}
