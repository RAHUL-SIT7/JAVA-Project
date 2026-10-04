import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class HospitalLogin {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/java";
        String username = "root";
        String password = "Rahul@123";

        Scanner sc = new Scanner(System.in);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    url,
                    username,
                    password
            );

            System.out.println("Database connected successfully!");

            System.out.print("Enter staff type (Doctor/Nurse): ");
            String staffType = sc.nextLine();

            System.out.print("Enter Login ID: ");
            String loginId = sc.nextLine();

            System.out.print("Enter Password: ");
            String staffPassword = sc.nextLine();

            String sql = "SELECT * FROM hospital_staff " +
                         "WHERE staff_type = ? AND login_id = ? AND password = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, staffType);
            ps.setString(2, loginId);
            ps.setString(3, staffPassword);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                System.out.println("\n===== LOGIN SUCCESSFUL =====");
                System.out.println("Welcome, " + rs.getString("name") + "!");
                System.out.println("Staff Type: " + rs.getString("staff_type"));
                System.out.println("Login ID: " + rs.getString("login_id"));
                System.out.println("Access granted.");

            } else {

                System.out.println("\n===== LOGIN FAILED =====");
                System.out.println("Invalid staff type, login ID, or password.");
                System.out.println("Access denied.");

            }

            rs.close();
            ps.close();
            con.close();
            sc.close();

            System.out.println("\nDatabase connection closed.");

        } catch (Exception e) {
            System.out.println("Database connection failed!");
            e.printStackTrace();
        }
    }
}