package financemanager.ui;

import financemanager.utility.InputValidator;

import java.time.LocalDate;
import java.util.Scanner;

public abstract class Menu {
    protected Scanner scanner;

    public Menu(Scanner scanner) {
        this.scanner = scanner;
    }

    public int getIntInput() {
        return InputValidator.getValidInt(scanner);
    }

    public double getDoubleInput() {
        return InputValidator.getValidDouble(scanner);
    }

    public LocalDate getDateInput() {
        return InputValidator.getValidDate(scanner);
    }
}
