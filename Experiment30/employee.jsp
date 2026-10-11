<%@ page import="java.sql.*" %>

<!DOCTYPE html>
<html>
<head>
    <title>Employee Management</title>
</head>

<body>

<h2>Employee Management System</h2>

<h3>Add Employee</h3>

<form action="addEmployee.jsp" method="post">

    Name:
    <input type="text" name="name" required>
    <br><br>

    Email:
    <input type="email" name="email" required>
    <br><br>

    Department:
    <input type="text" name="department" required>
    <br><br>

    Salary:
    <input type="number" name="salary" required>
    <br><br>

    <input type="submit" value="Add Employee">

</form>

<hr>

<h3>Employee Details</h3>

<table border="1" cellpadding="10">

<tr>
    <th>ID</th>
    <th>Name</th>
    <th>Email</th>
    <th>Department</th>
    <th>Salary</th>
    <th>Action</th>
</tr>

<%

try {

    Class.forName("com.mysql.cj.jdbc.Driver");

    Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/java",
        "root",
        "Rahul@123"
    );

    Statement stmt = con.createStatement();

    ResultSet rs = stmt.executeQuery(
        "SELECT * FROM employee"
    );

    while (rs.next()) {

%>

<tr>

<td><%= rs.getInt("id") %></td>

<td><%= rs.getString("name") %></td>

<td><%= rs.getString("email") %></td>

<td><%= rs.getString("department") %></td>

<td><%= rs.getDouble("salary") %></td>

<td>

<a href="updateEmployee.jsp?id=<%=rs.getInt("id")%>">
    Update
</a>

&nbsp;

<a href="deleteEmployee.jsp?id=<%=rs.getInt("id")%>">
    Delete
</a>

</td>

</tr>

<%

    }

    con.close();

} catch (Exception e) {

    out.println("Error: " + e);

}

%>

</table>

</body>
</html>