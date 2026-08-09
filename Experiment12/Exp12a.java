import java.util.Scanner;
import student.Student;
import faculty.Faculty;

public class Exp12a {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Student Name: ");
        String studentName = sc.nextLine();

        System.out.print("Enter Student Roll No: ");
        int rollNo = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Faculty Name: ");
        String facultyName = sc.nextLine();

        System.out.print("Enter Faculty Department: ");
        String department = sc.nextLine();

        Student s = new Student(studentName, rollNo);
        Faculty f = new Faculty(facultyName, department);

        System.out.println();

        s.display();

        System.out.println();

        f.display();

        sc.close();
    }
}