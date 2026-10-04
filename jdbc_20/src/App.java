import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class App {

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

            System.out.println("Database connected successfully!");

            // ==========================================
            // 1. INSERT OPERATION
            // ==========================================

            String insertQuery =
                    "INSERT INTO students (roll_no, name, course, marks) " +
                    "VALUES (?, ?, ?, ?)";

            PreparedStatement insertStatement =
                    con.prepareStatement(insertQuery);

            insertStatement.setInt(1, 105);
            insertStatement.setString(2, "Vivek");
            insertStatement.setString(3, "B.Tech AIML");
            insertStatement.setDouble(4, 88.5);

            int insertedRows =
                    insertStatement.executeUpdate();

            if (insertedRows > 0) {
                System.out.println("Student inserted successfully!");
            }

            // ==========================================
            // 2. UPDATE OPERATION
            // ==========================================

            String updateQuery =
                    "UPDATE students SET marks = ? WHERE roll_no = ?";

            PreparedStatement updateStatement =
                    con.prepareStatement(updateQuery);

            updateStatement.setDouble(1, 92.0);
            updateStatement.setInt(2, 105);

            int updatedRows =
                    updateStatement.executeUpdate();

            if (updatedRows > 0) {
                System.out.println("Student updated successfully!");
            }

            // ==========================================
            // 3. DELETE OPERATION
            // ==========================================

            String deleteQuery =
                    "DELETE FROM students WHERE roll_no = ?";

            PreparedStatement deleteStatement =
                    con.prepareStatement(deleteQuery);

            deleteStatement.setInt(1, 105);

            int deletedRows =
                    deleteStatement.executeUpdate();

            if (deletedRows > 0) {
                System.out.println("Student deleted successfully!");
            }

            // Close resources
            insertStatement.close();
            updateStatement.close();
            deleteStatement.close();
            con.close();

            System.out.println("Database connection closed.");

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}