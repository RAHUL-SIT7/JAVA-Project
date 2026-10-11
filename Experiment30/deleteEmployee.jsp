<%@ page import="java.sql.*" %>

<%

String id = request.getParameter("id");

try {

    Class.forName("com.mysql.cj.jdbc.Driver");

    Connection con = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/java",
        "root",
        "Rahul@123"
    );

    PreparedStatement ps = con.prepareStatement(
        "DELETE FROM employee WHERE id=?"
    );

    ps.setInt(1, Integer.parseInt(id));

    ps.executeUpdate();

    con.close();

    response.sendRedirect("employee.jsp");

} catch (Exception e) {

    out.println("Error: " + e);
}

%>