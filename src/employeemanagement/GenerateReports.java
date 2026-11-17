
import java.sql.*;
import java.time.LocalDate;
import java.util.Scanner;

public class GenerateReports {
    public static void payByJobTitle(
            Connection conn, int year, int month) {

        String sql =
            "SELECT j.job_title, " +
            "SUM(p.earnings) AS total_pay " +
            "FROM payroll p " +
            "JOIN employees e ON p.empID = e.empID " +
            "JOIN employee_job_titles ej ON e.empID = ej.empID " +
            "JOIN job_titles j ON ej.job_titleID = j.job_titleID " +
            "WHERE p.pay_date >= ? AND p.pay_date < ? " +
            "GROUP BY j.job_title " +
            "ORDER BY j.job_title";

        printReport(conn, sql, year, month,
                    "job_title", "JOB TITLE");
    }

    public static void payByDivision(
            Connection conn, int year, int month) {

        String sql =
            "SELECT d.Name AS division_name, " +
            "SUM(p.earnings) AS total_pay " +
            "FROM payroll p " +
            "JOIN employees e ON p.empID = e.empID " +
            "JOIN employee_division ed ON e.empID = ed.empID " +
            "JOIN division d ON ed.divID = d.divID " +
            "WHERE p.pay_date >= ? AND p.pay_date < ? " +
            "GROUP BY d.divID, d.Name " +
            "ORDER BY d.Name";

        printReport(conn, sql, year, month,
                    "division_name", "DIVISION");
    }

       private static void printReport(
            Connection conn, String sql,
            int year, int month,
            String column, String heading) {

        LocalDate start = LocalDate.of(year, month, 1);
        LocalDate end = start.plusMonths(1);

        try (PreparedStatement stmt =
                 conn.prepareStatement(sql)) {

            stmt.setDate(1, Date.valueOf(start));
            stmt.setDate(2, Date.valueOf(end));

            try (ResultSet rs = stmt.executeQuery()) {

                System.out.println(
                    "\nMONTHLY PAYROLL REPORT");
                System.out.println(
                    "Month: " + year + "-" + month);
                System.out.printf(
                    "%-30s %15s%n", heading, "TOTAL PAY");
                System.out.println(
                    "-----------------------------------------------");

                boolean found = false;

                while (rs.next()) {
                    found = true;

                    String name = rs.getString(column);
                    double total = rs.getDouble("total_pay");

                    System.out.printf(
                        "%-30s $%,14.2f%n",
                        name, total);
                }

                if (!found) {
                    System.out.println(
                        "No payroll records found.");
                }
            }

        } catch (SQLException e) {
            System.out.println(
                "Error generating report: " + e.getMessage());
        }
    }
    
public static void payHistory(Connection conn, int empID) {

    String sql =
        "SELECT pay_date, earnings, fed_tax, " +
        "fed_med, fed_SS, state_tax, " +
        "retire_401k, health_care " +
        "FROM payroll " +
        "WHERE empID = ? " +
        "ORDER BY pay_date DESC";

    try (PreparedStatement stmt =
             conn.prepareStatement(sql)) {

        stmt.setInt(1, empID);

        try (ResultSet rs = stmt.executeQuery()) {

            System.out.println(
                "\n=== EMPLOYEE PAY HISTORY ===");
            System.out.println("Employee ID: " + empID);

            boolean found = false;

            while (rs.next()) {
                found = true;

                double earnings = rs.getDouble("earnings");

                double deductions =
                    rs.getDouble("fed_tax") +
                    rs.getDouble("fed_med") +
                    rs.getDouble("fed_SS") +
                    rs.getDouble("state_tax") +
                    rs.getDouble("retire_401k") +
                    rs.getDouble("health_care");

                double netPay = earnings - deductions;

                System.out.println("-------------------------");
                System.out.println(
                    "Pay Date: " + rs.getDate("pay_date"));
                System.out.printf(
                    "Gross Pay: $%.2f%n", earnings);
                System.out.printf(
                    "Deductions: $%.2f%n", deductions);
                System.out.printf(
                    "Net Pay: $%.2f%n", netPay);
            }

            if (!found) {
                System.out.println(
                    "No payroll records found for this employee.");
            }
        }

    } catch (SQLException e) {
        System.out.println(
            "Error generating pay history: " + e.getMessage());
    }
}

}
