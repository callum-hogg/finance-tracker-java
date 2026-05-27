package financemanager.utility;

import java.time.LocalDate;
import java.util.Scanner;

public class InputValidator {


    public static int getValidInt(Scanner scanner) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Please enter a valid number: ");
            }
        }
    }

    public static double getValidDouble(Scanner scanner) {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Please enter a valid number: ");
            }
        }
    }

    public static LocalDate getValidDate(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Please enter date (YYYY-MM-DD): ");
                return LocalDate.parse(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid date.");
            }
        }
    }

    public static String getValidString(Scanner scanner) {
        while (true) {
            String input = scanner.nextLine();
            if (input.isEmpty()) {
                System.out.println("Input cannot be empty.");
            } else {
                return input.trim();
            }
        }
    }
}
