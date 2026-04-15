import java.util.ArrayList;
import java.util.List;

public class FinanceManager {
    //Declare required fields
    private List<Transaction> transactions;
    private double balance;

    //Constructor for FinanceManager
    public FinanceManager(double startingBalance) {
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
    public double getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return new ArrayList<>(transactions);
    }
}
