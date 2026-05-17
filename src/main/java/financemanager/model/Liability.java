package financemanager.model;

import financemanager.enums.LiabilityType;

public class Liability {
    private static int nextId = 1;
    private int id;
    private LiabilityType type;
    private String description;
    private double initialValue;
    private double remainingValue;
    private double interest;
    private double monthlyPayments;
    private int monthsLeft;

    public Liability(LiabilityType type, String description, double initialValue, double remainingValue, double interest, double monthlyPayments, int monthsLeft) {
        this.id = nextId++;
        this.type = type;
        this.description = description;
        this.initialValue = initialValue;
        this.remainingValue = remainingValue;
        this.interest = interest;
        this.monthlyPayments = monthlyPayments;
        this.monthsLeft = monthsLeft;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public double getMonthlyPayments() {
        return monthlyPayments;
    }

    public void setMonthlyPayments(double monthlyPayments) {
        this.monthlyPayments = monthlyPayments;
    }

    public int getMonthsLeft() {
        return monthsLeft;
    }

    public void setMonthsLeft(int monthsLeft) {
        this.monthsLeft = monthsLeft;
    }

    public LiabilityType getType() {
        return type;
    }

    public void setType(LiabilityType type) {
        this.type = type;
    }

    public double getInitialValue() {
        return initialValue;
    }

    public void setInitialValue(double initialValue) {
        this.initialValue = initialValue;
    }

    public double getRemainingValue() {
        return remainingValue;
    }

    public void setRemainingValue(double remainingValue) {
        this.remainingValue = remainingValue;
    }
}
