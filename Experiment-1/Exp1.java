import java.util.Scanner;

class Student {

    // Instance Variables
    int rollNo;
    String name;
    String course;
    double marks;

    // Constructor
    Student(int rollNo, String name, String course, double marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.course = course;
        this.marks = marks;
    }

    // Method to display student details
    void displayDetails() {
        System.out.println("\n----- Student Details -----");
        System.out.println("Roll Number : " + rollNo);
        System.out.println("Name        : " + name);
        System.out.println("Course      : " + course);
        System.out.println("Marks       : " + marks);
    }

    // Method to calculate grade
    void calculateGrade() {
        if (marks >= 90)
            System.out.println("Grade : A+");
        else if (marks >= 80)
            System.out.println("Grade : A");
        else if (marks >= 70)
            System.out.println("Grade : B");
        else if (marks >= 60)
            System.out.println("Grade : C");
        else if (marks >= 50)
            System.out.println("Grade : D");
        else
            System.out.println("Grade : F (Fail)");
    }
}

public class Exp1{

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Taking input from user
        System.out.print("Enter Roll Number: ");
        int roll = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Course: ");
        String course = sc.nextLine();

        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();

        // Creating object using constructor
        Student student = new Student(roll, name, course, marks);

        // Calling methods
        student.displayDetails();
        student.calculateGrade();

        sc.close();
    }
}