<%@ page import="java.sql.*" %>

<%

String id = request.getParameter("id");

try {

    Class.forName("com.mysql.cj.jdbc.Driver");

    Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/java",
        "root",
        "YOUR_PASSWORD"
    );

    PreparedStatement ps = con.prepareStatement(
        "DELETE FROM patient WHERE patient_id=?"
    );

    ps.setInt(1, Integer.parseInt(id));

    ps.executeUpdate();

    con.close();

    response.sendRedirect("patient.jsp");

} catch (Exception e) {

    out.println("Error: " + e);
}

%>