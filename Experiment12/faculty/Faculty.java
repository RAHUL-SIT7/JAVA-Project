package faculty;

public class Faculty {

    String name;
    String department;

    public Faculty(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public void display() {
        System.out.println("----- Faculty Details -----");
        System.out.println("Faculty Name: " + name);
        System.out.println("Department: " + department);
    }
}