<%@ page import="java.sql.*" %>

<%

String id = request.getParameter("id");

Class.forName("com.mysql.cj.jdbc.Driver");

Connection con = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/java",
    "root",
    "Rahul@123"
);

if (request.getParameter("update") == null) {

    PreparedStatement ps = con.prepareStatement(
        "SELECT * FROM employee WHERE id=?"
    );

    ps.setInt(1, Integer.parseInt(id));

    ResultSet rs = ps.executeQuery();

    if (rs.next()) {

%>

<h2>Update Employee</h2>

<form method="post">

    <input type="hidden" name="id"
           value="<%=rs.getInt("id")%>">

    Name:
    <input type="text" name="name"
           value="<%=rs.getString("name")%>">
    <br><br>

    Email:
    <input type="email" name="email"
           value="<%=rs.getString("email")%>">
    <br><br>

    Department:
    <input type="text" name="department"
           value="<%=rs.getString("department")%>">
    <br><br>

    Salary:
    <input type="number" name="salary"
           value="<%=rs.getDouble("salary")%>">
    <br><br>

    <input type="submit"
           name="update"
           value="Update Employee">

</form>

<%

    }

} else {

    String name = request.getParameter("name");
    String email = request.getParameter("email");
    String department = request.getParameter("department");

    double salary = Double.parseDouble(
        request.getParameter("salary")
    );

    PreparedStatement ps = con.prepareStatement(
        "UPDATE employee SET name=?, email=?, department=?, salary=? WHERE id=?"
    );

    ps.setString(1, name);
    ps.setString(2, email);
    ps.setString(3, department);
    ps.setDouble(4, salary);
    ps.setInt(5, Integer.parseInt(id));

    ps.executeUpdate();

    response.sendRedirect("employee.jsp");
}

con.close();

%>