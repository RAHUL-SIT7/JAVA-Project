<%@ page import="java.sql.*" %>

<%

String name = request.getParameter("name");
int age = Integer.parseInt(request.getParameter("age"));
String disease = request.getParameter("disease");
String treatmentStatus =
    request.getParameter("treatment_status");

try {

    Class.forName("com.mysql.cj.jdbc.Driver");

    Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/java",
        "root",
        "YOUR_PASSWORD"
    );

    PreparedStatement ps = con.prepareStatement(
        "INSERT INTO patient(name,age,disease,treatment_status) VALUES(?,?,?,?)"
    );

    ps.setString(1, name);
    ps.setInt(2, age);
    ps.setString(3, disease);
    ps.setString(4, treatmentStatus);

    ps.executeUpdate();

    con.close();

    response.sendRedirect("patient.jsp");

} catch (Exception e) {

    out.println("Error: " + e);
}

%>