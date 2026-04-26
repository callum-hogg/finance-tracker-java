import java.util.Scanner;

public class UI {
    private FinanceManager manager;
    private Scanner scanner;

    public UI() {
        scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Welcome to the Finance Tracker!");
        System.out.print("Please enter the starting balance: ");
        double startingBalance = getDoubleInput();
        manager = new FinanceManager(startingBalance);
        runMenu();
    }

    public void runMenu() {
        while(true) {
            System.out.println("Please choose one of the following options: ");
            System.out.println("1. View Balance");
            System.out.println("2. Add Transaction");
            System.out.println("3. Remove Transaction");
            System.out.println("4. View Transactions");
            System.out.println("5. View Total Income");
            System.out.println("6. View Total Expense");
            System.out.println("7. Exit");

            int choice = getIntInput();

            switch (choice) {
                case 1 -> displayBalance();
                case 2 -> addTransaction();
                case 3 -> removeTransaction();
                case 4 -> displayTransactions();
                case 5 -> displayTotalIncome();
                case 6 -> displayTotalExpense();
                case 7 -> exit();
                default -> System.out.println("Please choose a valid option.");
            }
        }
    }

    public int getIntInput() {
        int input;
        while(true) {
            try {
                input = Integer.parseInt(scanner.nextLine());
                return input;
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    public double getDoubleInput() {
        while(true) {
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
}
