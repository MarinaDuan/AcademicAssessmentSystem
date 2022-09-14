<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Connection" %><%--
  Created by IntelliJ IDEA.
  User: Marina
  Date: 2022/4/3
  Time: 23:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Assessment Criterion</title>
</head>
<body>
    <div id="container">
        <table id="class"  >
            <tr>
                <th>Student Name</th>
                <td><%=sName%></td>
            </tr>
            <tr>
                <th>Student ID</th>
                <td><%=StdNo%></td>
            </tr>

            <tr>
                <th>Subject</th>
                <td><%=subject%></td>
            </tr>
            <tr>
                <th>Subject ID</th>
                <td><%=subjectID%></td>
            </tr>
            <tr>
                <th>Exam Type</th>
                <td><%=exam%></td>
            </tr>
            <tr>
                <th>Score</th>
                <td><%=score%></td>
            </tr>
            <tr>
                <th>Weight</th>
                <td><%=weight%></td>
            </tr>
            <tr>
                <th>Overall Score</th>
                <td><%=overallScore%></td>
            </tr>


        </table>
        <%
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/root/");
        int subjectid=Integer.parseInt(request.getParameter("SubId"));

                %>



