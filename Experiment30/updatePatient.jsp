<%@ page import="java.sql.*" %>

<%

String id = request.getParameter("id");

Class.forName("com.mysql.cj.jdbc.Driver");

Connection con = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/java",
    "root",
    "YOUR_PASSWORD"
);

if (request.getParameter("update") == null) {

    PreparedStatement ps = con.prepareStatement(
        "SELECT * FROM patient WHERE patient_id=?"
    );

    ps.setInt(1, Integer.parseInt(id));

    ResultSet rs = ps.executeQuery();

    if (rs.next()) {

%>

<h2>Update Patient</h2>

<form method="post">

    <input type="hidden"
           name="id"
           value="<%=rs.getInt("patient_id")%>">

    Name:
    <input type="text"
           name="name"
           value="<%=rs.getString("name")%>">
    <br><br>

    Age:
    <input type="number"
           name="age"
           value="<%=rs.getInt("age")%>">
    <br><br>

    Disease:
    <input type="text"
           name="disease"
           value="<%=rs.getString("disease")%>">
    <br><br>

    Treatment Status:
    <input type="text"
           name="treatment_status"
           value="<%=rs.getString("treatment_status")%>">
    <br><br>

    <input type="submit"
           name="update"
           value="Update Patient">

</form>

<%

    }

} else {

    String name = request.getParameter("name");

    int age = Integer.parseInt(
        request.getParameter("age")
    );

    String disease =
        request.getParameter("disease");

    String treatmentStatus =
        request.getParameter("treatment_status");

    PreparedStatement ps = con.prepareStatement(
        "UPDATE patient SET name=?, age=?, disease=?, treatment_status=? WHERE patient_id=?"
    );

    ps.setString(1, name);
    ps.setInt(2, age);
    ps.setString(3, disease);
    ps.setString(4, treatmentStatus);
    ps.setInt(5, Integer.parseInt(id));

    ps.executeUpdate();

    response.sendRedirect("patient.jsp");
}

con.close();

%>