import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

class App {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/java";
        String username = "root";
        String password = "Rahul@123";

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con =
                    DriverManager.getConnection(url, username, password);

            System.out.println("Database connected successfully!");

            Statement stmt = con.createStatement();

            ResultSet rs =
                    stmt.executeQuery("SELECT * FROM students");

            System.out.println("\n===== STUDENT RECORDS =====");

            while (rs.next()) {

                System.out.println("Roll No: " +
                        rs.getInt("roll_no"));

                System.out.println("Name: " +
                        rs.getString("name"));

                System.out.println("Course: " +
                        rs.getString("course"));

                System.out.println("Marks: " +
                        rs.getDouble("marks"));

                System.out.println("---------------------------");
            }

            rs.close();
            stmt.close();
            con.close();

            System.out.println("Database connection closed.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}