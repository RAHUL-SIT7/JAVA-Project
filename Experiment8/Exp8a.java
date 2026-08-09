class Employee {

    String name;
    int salary;

    Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    void displayEmployee() {
        System.out.println("----- Employee Details -----");
        System.out.println("Employee Name: " + name);
        System.out.println("Employee Salary: " + salary);
    }
}

class Manager extends Employee {

    String department;

    Manager(String name, int salary, String department) {
        super(name, salary);
        this.department = department;
    }

    void displayManager() {
        System.out.println("----- Manager Details -----");
        System.out.println("Manager Name: " + super.name);
        System.out.println("Manager Salary: " + super.salary);
        System.out.println("Department: " + department);
    }
}

public class Exp8a {

    public static void main(String[] args) {

        Manager m = new Manager("Rahul", 60000, "IT");

        m.displayEmployee();
        System.out.println();

        m.displayManager();
    }
}