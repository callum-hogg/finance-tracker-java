package financemanager.ui;

import financemanager.service.AssetLiabilityManager;
import financemanager.service.FinanceAccountManager;

import java.util.Scanner;

public class AssetLiabilityMenu extends Menu {

    private AssetLiabilityManager assetLiabilityManager;

    public AssetLiabilityMenu (Scanner scanner, AssetLiabilityManager assetLiabilityManager) {
        super(scanner);
        this.assetLiabilityManager = assetLiabilityManager;
    }

    public void start() {
        System.out.println("Accounts:");
        System.out.println("");
    }
}
