<%@ page import="java.sql.*" %>

<%

String name = request.getParameter("name");
String email = request.getParameter("email");
String department = request.getParameter("department");
double salary = Double.parseDouble(
    request.getParameter("salary")
);

try {

    Class.forName("com.mysql.cj.jdbc.Driver");

    Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/java",
        "root",
        "Rahul@123"
    );

    PreparedStatement ps = con.prepareStatement(
        "INSERT INTO employee(name,email,department,salary) VALUES(?,?,?,?)"
    );

    ps.setString(1, name);
    ps.setString(2, email);
    ps.setString(3, department);
    ps.setDouble(4, salary);

    ps.executeUpdate();

    con.close();

    response.sendRedirect("employee.jsp");

} catch (Exception e) {

    out.println("Error: " + e);
}

%>