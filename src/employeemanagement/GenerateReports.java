import java.sql.*;
import java.util.Scanner;

public class GenerateReports {

    public static void showMenu(Scanner input) {

        System.out.println("\n=== GENERATE REPORTS ===");
        System.out.println("1. Total Pay by Job Title");
        System.out.println("2. Total Pay by Division");
        System.out.println("3. Employee Pay History");
        System.out.println("4. New Employee Hires");
        System.out.println("5. Employees by Job Title");
        System.out.println("0. Exit Reports");
        System.out.print("Choose a report: ");

        int choice = input.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Total Pay by Job Title");
                break;

            case 2:
                System.out.println("Total Pay by Division");
                break;

            case 3:
                System.out.println("Employee Pay History");
                break;

            case 4:
                System.out.println("New Employee Hires");
                break;

            case 5:
                System.out.println("Employees by Job Title");
                break;

            case 0:
                System.out.println("Exiting Reports");
                break;

            default:
                System.out.println("Invalid choice.");
        }
    }
}
