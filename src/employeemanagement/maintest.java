import java.util.Scanner;

public class maintest {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        GenerateReports.showMenu(input);

        input.close();
    }
}