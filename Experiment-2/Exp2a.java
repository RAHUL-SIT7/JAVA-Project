import java.util.Scanner;
class Student{
    //variables
    float roll;
    String name;
    String course;
//Default Constructor
    Student(){
        roll=0;
        name="Not assigned";
        course="Not assigned";
    }
//Parameterized Constructor
    Student(float roll,String name,String course){
        this.roll=roll;
        this.name=name;
        this.course=course;
    }
//Copy Constructor
Student(Student s){
    this.roll=s.roll;
    this.name=s.name;
    this.course=s.course;
}
    void display(){
        System.out.println("----THE details of Student----");
        System.out.println("Student Rollno.:"+roll);
        System.out.println("Student Name:"+name);
        System.out.println("Course Pursuing:"+course);


    }
}
public class Exp2a{

    public static void main(String[] args)
    {
        Scanner  sc =new Scanner(System.in);
        //Default constructor 
        Student s1 = new Student();
        //Parameterized Constructor
        System.out.print("Enter your rollNo:");
        float roll=sc.nextFloat();
        sc.nextLine();

        System.out.print("Enter your Name:");
        String name=sc.nextLine();
        

        System.out.print("Enter your Course:");
        String course=sc.nextLine();

        Student s2 =new Student(roll,name,course);

        //Copy Constructor
        Student s3= new Student(s2);
        //Display details
        System.out.println("Displaying Details using default constructor:");
        s1.display();

        System.out.println("Displaying Details using Parameterized constructor:");
        s2.display();
        
        System.out.println("Displaying Details using Copy constructor:");
        s3.display();
        sc.close();
    }
}