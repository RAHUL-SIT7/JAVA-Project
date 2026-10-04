import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class App {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/java";
        String username = "root";
        String password = "Rahul@123";

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    url,
                    username,
                    password
            );

            System.out.println("Database connected successfully!");

            String sql =
                    "SELECT * FROM students WHERE roll_no = ?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setInt(1, 101);

            ResultSet rs = ps.executeQuery();

            System.out.println("\n===== STUDENT DETAILS =====");

            if (rs.next()) {

                System.out.println("Roll No: "
                        + rs.getInt("roll_no"));

                System.out.println("Name: "
                        + rs.getString("name"));

                System.out.println("Course: "
                        + rs.getString("course"));

                System.out.println("Marks: "
                        + rs.getDouble("marks"));
            }

            rs.close();
            ps.close();
            con.close();

            System.out.println("\nConnection closed.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}