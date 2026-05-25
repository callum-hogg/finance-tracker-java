package financemanager.model;

import financemanager.enums.FinanceAccountType;
import financemanager.enums.TransactionType;

import java.util.ArrayList;
import java.util.List;

public class FinanceAccount {
    //Declare required fields
    private static int nextID = 1;
    private int id;
    private String name;
    private List<Transaction> transactions;
    private double startingBalance;
    private double balance;
    private FinanceAccountType accountType;

    //Constructor for FinanceManager
    public FinanceAccount(String name, FinanceAccountType accountType, double startingBalance) {
        this.id = nextID++;
        this.name = name;
        this.startingBalance = startingBalance;
        this.balance = startingBalance;
        this.transactions = new ArrayList<>();
        this.accountType = accountType;
    }

    //Getters for FinanceManager fields

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public FinanceAccountType getAccountType() {
        return accountType;
    }

    public double getBalance() {
        return (startingBalance + getAccountIncome() - getAccountExpense());
    }

    public ArrayList<Transaction> getTransactions() {
        return new ArrayList<>(transactions);
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

    public boolean removeTransaction(int id) {
        return transactions.removeIf(t -> t.getId() == id);
    }

    public double getAccountIncome() {
        double totalIncome = 0;
        for (Transaction transaction : transactions) {
            if (transaction.getType() == TransactionType.INCOME) {
                totalIncome += transaction.getAmount();
            }
        }
        return totalIncome;
    }

    public double getAccountExpense() {
        double totalExpense = 0;
        for (Transaction transaction : transactions) {
            if (transaction.getType() == TransactionType.EXPENSE) {
                totalExpense += transaction.getAmount();
            }
        }
        return totalExpense;
    }
}
