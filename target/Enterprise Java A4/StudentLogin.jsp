<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Connection" %>
<html>
    <div id="container">
        <div class="form-group">
            <label for="sName" class="mar">Username</label>
            <input type="text"
                   class="mar form-control" id="sName" name="sName"
                   placeholder="Enter username" required>
        </div>

        <div class="form-group">
            <label for="email" class="mar">Email</label>
            <input type="text"
                   class="mar form-control" id="email" name="email"
                   placeholder="Enter Email" required>
        </div>

        <div class="form-group">
            <label for="stdNo" class="mar">Student Number</label>
            <input type="text"
                   class="mar form-control" id="stdNo" name="stdNo"
                   placeholder="Enter Student Number" required>
        </div>

        <div class="form-group">
            <label for="Password" class="mar">Password</label> <input
            type="password" class="mar form-control" id="password" name="pass"
            placeholder="Enter Password" required>
        </div>
            <%
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:8080/root/");
            PreparedStatement statement=connection.prepareStatement("Insert into Student (Sname,email,StdNo,password) values(?,?,?,?,?,?)");

            statement.setString(1,request.getParameter("sName"));
            statement.setString(2,request.getParameter("email"));
            statement.setString(3,request.getParameter("StdNo"));
            statement.setString(4,request.getParameter("password"));

            statement.executeUpdate();
               %>
        }
    </div>

</html>
