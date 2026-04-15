import java.time.LocalDate;

public class Transaction {
    //Declare required fields
    private double amount;
    private String category;
    private LocalDate date;
    private TransactionType type;

    //Constructor for Transactions
    public Transaction(double amount, String category, LocalDate date, TransactionType type) {
        this.amount = amount;
        this.category = category;
        this.date = date;
        this.type = type;
    }

    //Getters for Transaction fields
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
}
