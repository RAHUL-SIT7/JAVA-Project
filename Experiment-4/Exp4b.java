import java.util.Scanner;

public class Exp4b {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Employee ID: ");
        String empId = sc.nextLine();

        System.out.print("Enter Basic Salary: ");
        String basicSalary = sc.nextLine();

        System.out.print("Enter Bonus Amount: ");
        String bonus = sc.nextLine();

        // Convert String into Wrapper Objects
        Integer salary = Integer.valueOf(basicSalary);
        Integer bonusAmount = Integer.valueOf(bonus);

        // Validation
        if (salary < 0 || bonusAmount < 0) {
            System.out.println("Invalid Salary or Bonus Amount.");
        } else {
            int netSalary = salary + bonusAmount;

            System.out.println("Employee ID: " + empId);
            System.out.println("Basic Salary: " + salary);
            System.out.println("Bonus Amount: " + bonusAmount);
            System.out.println("Net Salary: " + netSalary);
        }

        sc.close();
    }
}