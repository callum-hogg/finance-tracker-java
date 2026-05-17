package financemanager.model;

import financemanager.enums.TransactionType;

import java.time.LocalDate;

public class Transaction {

    //Declare required fields
    private static int nextId = 1;
    private double amount;
    private String category;
    private LocalDate date;
    private TransactionType type;
    private int id;

    //Constructor for Transactions
    public Transaction(double amount, String category, LocalDate date, TransactionType type) {
        this.amount = amount;
        this.category = category;
        this.date = date;
        this.type = type;
        this.id = nextId++;
    }

    //Getters for financemanager.model.Transaction fields
    public double getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }

    public LocalDate getDate() {
        return date;
    }

    public TransactionType getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
