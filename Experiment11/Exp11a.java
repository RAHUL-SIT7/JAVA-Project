import java.util.Scanner;

interface Printable {

    void printDetails();
}

class Student implements Printable {

    String name;
    int rollNo;

    Student(String name, int rollNo) {
        this.name = name;
        this.rollNo = rollNo;
    }

    public void printDetails() {
        System.out.println("----- Student Details -----");
        System.out.println("Student Name: " + name);
        System.out.println("Roll No: " + rollNo);
    }
}

class Employee implements Printable {

    String name;
    int employeeId;

    Employee(String name, int employeeId) {
        this.name = name;
        this.employeeId = employeeId;
    }

    public void printDetails() {
        System.out.println("----- Employee Details -----");
        System.out.println("Employee Name: " + name);
        System.out.println("Employee ID: " + employeeId);
    }
}

public class Exp11a {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Student Name: ");
        String studentName = sc.nextLine();

        System.out.print("Enter Student Roll No: ");
        int rollNo = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Employee Name: ");
        String employeeName = sc.nextLine();

        System.out.print("Enter Employee ID: ");
        int employeeId = sc.nextInt();

        Printable student = new Student(studentName, rollNo);
        Printable employee = new Employee(employeeName, employeeId);

        System.out.println();

        student.printDetails();

        System.out.println();

        employee.printDetails();

        sc.close();
    }
}