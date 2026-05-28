package financemanager.ui;

import financemanager.enums.AssetType;
import financemanager.enums.LiabilityType;
import financemanager.enums.TransactionType;
import financemanager.model.Asset;
import financemanager.model.InvestmentAccount;
import financemanager.model.Liability;
import financemanager.service.AssetLiabilityManager;
import financemanager.service.FinanceAccountManager;
import financemanager.utility.InputValidator;

import java.util.ArrayList;
import java.util.Scanner;

public class AssetLiabilityMenu extends Menu {

    private AssetLiabilityManager assetLiabilityManager;

    public AssetLiabilityMenu (Scanner scanner, AssetLiabilityManager assetLiabilityManager) {
        super(scanner);
        this.assetLiabilityManager = assetLiabilityManager;
    }

    public void start() {
        boolean running = true;

        while (running) {

            ArrayList<Asset> assets = new ArrayList<>(assetLiabilityManager.getAssets());
            ArrayList<Liability> liabilities = new ArrayList<>(assetLiabilityManager.getLiabilities());
            System.out.println();
            System.out.println("Assets:");

            for (int i = 0; i < assets.size(); i++) {
                System.out.println((i + 1) + ". " + assets.get(i).getDescription() + ": " + assets.get(i).getValue());
            }

            System.out.println();
            System.out.println("Liabilities:");

            for (int i = assets.size(); i < assets.size() + liabilities.size(); i++) {
                System.out.println((i + 1) + ". " + liabilities.get(i - assets.size()).getDescription() + ": " + liabilities.get(i - assets.size()).getRemainingValue());
            }

            System.out.println();
            System.out.println(assets.size() + liabilities.size() + 1 + ". Add Asset");
            System.out.println(assets.size() + liabilities.size() + 2 + ". Add Liability");
            System.out.println(assets.size() + liabilities.size() + 3 + ". Back");

            int choice = getIntInput();

            if (choice >= 1 && choice <= assets.size()) {
                Asset asset = assets.get(choice - 1);

            } else if (choice <= assets.size() + liabilities.size()) {
                Liability liability = liabilities.get(choice - assets.size() - 1);
            } else if (choice == assets.size() + liabilities.size() + 1) {
                addAsset();
            } else if (choice == assets.size() + liabilities.size() + 2) {
                addLiability();
            } else if (choice == assets.size() + liabilities.size() + 3) {
                running = false;
            } else {
                System.out.println("Please choose a valid option.");
            }
        }
    }

    public void addAsset() {
        AssetType type = getAssetType();

        System.out.print("Enter description: ");
        String description = getStringInput();

        System.out.print("Enter asset value: ");
        double value = getDoubleInput();

        assetLiabilityManager.addAsset(new Asset(type, description, value));
    }

    public void addLiability() {
        LiabilityType type = getLiabilityType();

        System.out.print("Enter description: ");
        String description = getStringInput();

        System.out.print("Enter initial value: ");
        double initialValue = getDoubleInput();

        System.out.print("Enter remaining value: ");
        double remainingValue = getDoubleInput();

        System.out.print("Enter interest rate: ");
        double interestRate = getDoubleInput();

        System.out.print("Enter monthly payment value: ");
        double monthlyPayments = getDoubleInput();

        System.out.print("Enter number of months left: ");
        int monthsLeft = getIntInput();

        assetLiabilityManager.addLiability(new Liability(type, description, initialValue, remainingValue, interestRate, monthlyPayments, monthsLeft));
    }

    public AssetType getAssetType() {
        while(true) {
            System.out.println("1. Property");
            System.out.println("2. Vehicle");
            System.out.println("3. Other");
            System.out.print("Choose asset type: ");

            int input = InputValidator.getValidInt(scanner);

            switch (input) {
                case 1 -> {
                    return AssetType.PROPERTY;
                }
                case 2 -> {
                    return AssetType.VEHICLE;
                }
                case 3 -> {
                    return AssetType.OTHER;
                }
                default -> System.out.println("Please choose a valid option.");
            }
        }
    }

    public LiabilityType getLiabilityType() {
        while(true) {
            System.out.println("1. Loan");
            System.out.println("2. Credit Card Debt");
            System.out.print("Choose liability type: ");

            int input = InputValidator.getValidInt(scanner);

            switch (input) {
                case 1 -> {
                    return LiabilityType.LOAN;
                }
                case 2 -> {
                    return LiabilityType.CREDIT_CARD;
                }
                default -> System.out.println("Please choose a valid option.");
            }
        }
    }
}
