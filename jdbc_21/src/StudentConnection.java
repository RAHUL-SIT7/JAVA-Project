import java.sql.Connection;
import java.sql.DriverManager;

public class StudentConnection {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/java";
        String username = "root";
        String password = "Rahul@123";

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            Connection con = DriverManager.getConnection(
                    url,
                    username,
                    password
            );

            // Display connection status
            System.out.println(
                    "Student database connected successfully!"
            );

            // Close connection
            con.close();

            System.out.println(
                    "Student database connection closed successfully!"
            );

        } catch (Exception e) {

            System.out.println(
                    "Student database connection failed!"
            );

            e.printStackTrace();
        }
    }
}