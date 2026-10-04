import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class App {
    public static void main(String[] args) {

        // MySQL Database Details
        String url = "jdbc:mysql://localhost:3306/java";
        String username = "root";
        String password = "Rahul@123";

        try {

            // 1. Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2. Establish Database Connection
            Connection con = DriverManager.getConnection(
                    url,
                    username,
                    password
            );

            System.out.println("Database connected successfully!");

            // 3. Create Statement
            Statement stmt = con.createStatement();
            // ==================================================
            // EXERCISE 1: DISPLAY STUDENT RECORDS
            // ==================================================

            String studentQuery = "SELECT * FROM students";

            ResultSet rs = stmt.executeQuery(studentQuery);

            System.out.println("\n===== STUDENT RECORDS =====");

            while (rs.next()) {

                System.out.println("Roll No: "
                        + rs.getInt("roll_no"));

                System.out.println("Name: "
                        + rs.getString("name"));

                System.out.println("Course: "
                        + rs.getString("course"));

                System.out.println("Marks: "
                        + rs.getDouble("marks"));

                System.out.println("---------------------------");
            }

            rs.close();

            // ==================================================
            // EXERCISE 2: DISPLAY PRODUCT DETAILS
            // ==================================================

            String productQuery = "SELECT * FROM products";

            rs = stmt.executeQuery(productQuery);

            System.out.println("\n===== PRODUCT DETAILS =====");

            while (rs.next()) {

                System.out.println("Product ID: "
                        + rs.getInt("product_id"));

                System.out.println("Product Name: "
                        + rs.getString("product_name"));

                System.out.println("Quantity: "
                        + rs.getInt("quantity"));

                System.out.println("Price: "
                        + rs.getDouble("price"));

                System.out.println("---------------------------");
            }

            // Close resources
            rs.close();
            stmt.close();
            con.close();

            System.out.println("\nDatabase connection closed.");

        } catch (Exception e) {

            System.out.println("Database connection failed!");
            e.printStackTrace();
        }
    }
}