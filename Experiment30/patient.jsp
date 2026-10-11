<%@ page import="java.sql.*" %>

<!DOCTYPE html>
<html>
<head>
    <title>Patient Management</title>
</head>

<body>

<h2>Patient Management System</h2>

<h3>Add Patient</h3>

<form action="addPatient.jsp" method="post">

    Name:
    <input type="text" name="name" required>
    <br><br>

    Age:
    <input type="number" name="age" required>
    <br><br>

    Disease:
    <input type="text" name="disease" required>
    <br><br>

    Treatment Status:
    <input type="text" name="treatment_status" required>
    <br><br>

    <input type="submit" value="Add Patient">

</form>

<hr>

<h3>Patient Records</h3>

<table border="1" cellpadding="10">

<tr>
    <th>ID</th>
    <th>Name</th>
    <th>Age</th>
    <th>Disease</th>
    <th>Treatment Status</th>
    <th>Action</th>
</tr>

<%

try {

    Class.forName("com.mysql.cj.jdbc.Driver");

    Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/java",
        "root",
        "YOUR_PASSWORD"
    );

    Statement stmt = con.createStatement();

    ResultSet rs = stmt.executeQuery(
        "SELECT * FROM patient"
    );

    while (rs.next()) {

%>

<tr>

<td><%=rs.getInt("patient_id")%></td>

<td><%=rs.getString("name")%></td>

<td><%=rs.getInt("age")%></td>

<td><%=rs.getString("disease")%></td>

<td><%=rs.getString("treatment_status")%></td>

<td>

<a href="updatePatient.jsp?id=<%=rs.getInt("patient_id")%>">
Update
</a>

&nbsp;

<a href="deletePatient.jsp?id=<%=rs.getInt("patient_id")%>">
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