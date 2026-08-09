import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Exp13a {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Employee ID: ");
        int employeeId = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Employee Salary: ");
        double salary = sc.nextDouble();

        try {

            FileWriter writer = new FileWriter("employee.txt");

            writer.write("Employee ID: " + employeeId + "\n");
            writer.write("Employee Name: " + name + "\n");
            writer.write("Employee Salary: " + salary + "\n");

            writer.close();

            System.out.println("Employee details written to file successfully.");

            FileReader reader = new FileReader("employee.txt");

            int ch;

            System.out.println("\n----- Employee Details from File -----");

            while ((ch = reader.read()) != -1) {
                System.out.print((char) ch);
            }

            reader.close();

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

        sc.close();
    }
}