import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

class EmployeeRecords {

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
                    stmt.executeQuery("SELECT * FROM employees");

            System.out.println("\n===== EMPLOYEE RECORDS =====");

            while (rs.next()) {

                System.out.println("Employee ID: " +
                        rs.getInt("employee_id"));

                System.out.println("Name: " +
                        rs.getString("name"));

                System.out.println("Department: " +
                        rs.getString("department"));

                System.out.println("Salary: " +
                        rs.getDouble("salary"));

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