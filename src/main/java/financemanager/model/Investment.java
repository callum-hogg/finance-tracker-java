package financemanager.model;

import financemanager.enums.InvestmentType;

import java.time.LocalDate;

public class Investment {

    private static int nextID = 1;
    private int id;
    private InvestmentType type;
    private String name;
    private String identifier;
    private double numberOfShares;
    private double purchasePrice;
    private double currentPrice;
    private LocalDate purchaseDate;

    public Investment(InvestmentType type, String name, String identifier, double numberOfShares, double purchasePrice, double currentPrice, LocalDate purchaseDate) {
        this.id = nextID++;
        this.type = type;
        this.name = name;
        this.identifier = identifier;
        this.numberOfShares = numberOfShares;
        this.purchasePrice = purchasePrice;
        this.purchaseDate = purchaseDate;
        this.currentPrice = currentPrice;
    }

    public double getNumberOfShares() {
        return numberOfShares;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public InvestmentType getType() {
        return type;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public int getId() {
        return id;
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getName() {
        return name;
    }

    public double getValue() {
        return numberOfShares * currentPrice;
    }

    public void setNumberOfShares(double numberOfShares) {
        this.numberOfShares = numberOfShares;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public void setType(InvestmentType type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }
}
