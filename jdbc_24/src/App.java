import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {

        // Load MySQL Driver
        Class.forName("com.mysql.cj.jdbc.Driver");// Connect to database
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/symbiosis",
                "root",
                "Rahul@123"
        );

        System.out.println("Connection established successfully!");

        Scanner sc = new Scanner(System.in);

        // Create table automatically
        createTable(con);

        while (true) {

            System.out.println("\n===== STUDENT DATABASE =====");
            System.out.println("1. Insert Student");
            System.out.println("2. Update Student");
            System.out.println("3. Delete Student");
            System.out.println("4. View Students");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    insertStudent(con, sc);
                    break;

                case 2:
                    updateStudent(con, sc);
                    break;

                case 3:
                    deleteStudent(con, sc);
                    break;

                case 4:
                    viewStudents(con);
                    break;

                case 5:
                    con.close();
                    sc.close();

                    System.out.println("Connection closed successfully!");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // ================= CREATE TABLE =================

    static void createTable(Connection con) throws Exception {

    String createSQL = """
            CREATE TABLE IF NOT EXISTS students (
                id INT PRIMARY KEY AUTO_INCREMENT,
                name VARCHAR(100),
                age INT,
                course VARCHAR(100)
            )
            """;

    Statement stmt = con.createStatement();

    stmt.executeUpdate(createSQL);

    // Add phone column if it doesn't already exist
    try {
        stmt.executeUpdate(
            "ALTER TABLE students ADD COLUMN phone VARCHAR(15)"
        );

        System.out.println("Phone column added successfully!");

    } catch (Exception e) {

        // If phone already exists, do nothing
        if (!e.getMessage().contains("Duplicate column")) {
            throw e;
        }
    }

    System.out.println("Students table is ready!");
}

    // ================= INSERT =================

    static void insertStudent(Connection con, Scanner sc) throws Exception {

        sc.nextLine();

        System.out.print("Enter student name: ");
        String name = sc.nextLine();

        System.out.print("Enter age: ");
        int age = sc.nextInt();

        sc.nextLine();

        System.out.print("Enter course: ");
        String course = sc.nextLine();

        System.out.print("Enter phone: ");
        String phone = sc.nextLine();

        String sql = """
                INSERT INTO students
                (name, age, course, phone)
                VALUES (?, ?, ?, ?)
                """;

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, name);
        ps.setInt(2, age);
        ps.setString(3, course);
        ps.setString(4, phone);

        ps.executeUpdate();

        System.out.println("Student inserted successfully!");

        ps.close();
    }

    // ================= UPDATE =================

    static void updateStudent(Connection con, Scanner sc) throws Exception {

        System.out.print("Enter student ID: ");
        int id = sc.nextInt();

        sc.nextLine();

        System.out.print("Enter new name: ");
        String name = sc.nextLine();

        System.out.print("Enter new age: ");
        int age = sc.nextInt();

        sc.nextLine();

        System.out.print("Enter new course: ");
        String course = sc.nextLine();

        System.out.print("Enter new phone: ");
        String phone = sc.nextLine();

        String sql = """
                UPDATE students
                SET name = ?, age = ?, course = ?, phone = ?
                WHERE id = ?
                """;

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, name);
        ps.setInt(2, age);
        ps.setString(3, course);
        ps.setString(4, phone);
        ps.setInt(5, id);

        int rows = ps.executeUpdate();

        if (rows > 0) {
            System.out.println("Student updated successfully!");
        } else {
            System.out.println("Student ID not found!");
        }

        ps.close();
    }

    // ================= DELETE =================

    static void deleteStudent(Connection con, Scanner sc) throws Exception {

        System.out.print("Enter student ID: ");
        int id = sc.nextInt();

        String sql = "DELETE FROM students WHERE id = ?";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, id);

        int rows = ps.executeUpdate();

        if (rows > 0) {
            System.out.println("Student deleted successfully!");
        } else {
            System.out.println("Student ID not found!");
        }

        ps.close();
    }

    // ================= VIEW =================

    static void viewStudents(Connection con) throws Exception {

        String sql = "SELECT * FROM students";

        Statement stmt = con.createStatement();

        ResultSet rs = stmt.executeQuery(sql);

        System.out.println("\n---------------------------------------------");
        System.out.println("ID   | NAME   | AGE      | COURSE   | PHONE       |");
        System.out.println("---------------------------------------------");

        while (rs.next()) {

            int id = rs.getInt("id");
            String name = rs.getString("name");
            int age = rs.getInt("age");
            String course = rs.getString("course");
            String phone = rs.getString("phone");

            System.out.println(  
                    id + " | " +
                    name + " | " +
                    age + " | " +
                    course + " | " +
                    phone
            );
        }

        rs.close();
        stmt.close();
    }
} 