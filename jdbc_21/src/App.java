import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class App {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/java";
        String username = "root";
        String password = "Rahul@123";

        try {

            // ==========================================
            // 1. DRIVER MANAGER
            // ==========================================

            Class.forName("com.mysql.cj.jdbc.Driver");

            System.out.println("MySQL JDBC Driver loaded successfully!");

            // ==========================================
            // 2. CONNECTION
            // ==========================================

            Connection con = DriverManager.getConnection(
                    url,
                    username,
                    password
            );

            System.out.println("Student database connected successfully!");

            // ==========================================
            // 3. STATEMENT
            // ==========================================

            Statement stmt = con.createStatement();

            System.out.println("Statement object created successfully!");

            // Test SQL query
            String query = "SELECT COUNT(*) FROM students";

            stmt.executeQuery(query);

            System.out.println("SQL statement executed successfully!");

            // Close resources
            stmt.close();
            con.close();

            System.out.println("Database connection closed successfully!");

        } catch (Exception e) {

            System.out.println("Database connection failed!");
            e.printStackTrace();
        }
    }
}