package financemanager.model;

import financemanager.enums.LiabilityType;

public class Liability {
    private LiabilityType type;
    private String description;
    private double value;
    private double interest;
    private double monthlyPayments;
    private int monthsLeft;

    public Liability(LiabilityType type, String description, double value, double interest, double monthlyPayments, int monthsLeft) {
        this.type = type;
        this.description = description;
        this.value = value;
        this.interest = interest;
        this.monthlyPayments = monthlyPayments;
        this.monthsLeft = monthsLeft;
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

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
