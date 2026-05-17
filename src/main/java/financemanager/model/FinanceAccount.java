package financemanager.model;

import financemanager.enums.TransactionType;

import java.util.ArrayList;
import java.util.List;

public class FinanceAccount {
    //Declare required fields
    private static int nextID = 1;
    private int id;
    private List<Transaction> transactions;
    private double startingBalance;
    private double balance;

    //Constructor for FinanceManager
    public FinanceAccount(double startingBalance) {
        this.id = nextID++;
        this.startingBalance = startingBalance;
        this.balance = startingBalance;
        this.transactions = new ArrayList<>();
    }

    //Method to add a transaction
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);

        if (transaction.getType() == TransactionType.INCOME) {
            balance += transaction.getAmount();
        } else if (transaction.getType() == TransactionType.EXPENSE) {
            balance -= transaction.getAmount();
        }
    }

    //Getters for FinanceManager fields

    public int getId() {
        return id;
    }

    public double getBalance() {
        return (startingBalance + getTotalIncome() - getTotalExpense());
    }

    public ArrayList<Transaction> getTransactions() {
        return new ArrayList<>(transactions);
    }

    public boolean removeTransaction(int id) {
        return transactions.removeIf(t -> t.getId() == id);
    }

    public double getTotalIncome() {
        double totalIncome = 0;
        for (Transaction transaction : transactions) {
            if (transaction.getType() == TransactionType.INCOME) {
                totalIncome += transaction.getAmount();
            }
        }
        return totalIncome;
    }

    public double getTotalExpense() {
        double totalExpense = 0;
        for (Transaction transaction : transactions) {
            if (transaction.getType() == TransactionType.EXPENSE) {
                totalExpense += transaction.getAmount();
            }
        }
        return totalExpense;
    }
}
