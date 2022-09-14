<%@ page import="model.User" %>
<%@ page import="model.Course" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>Register</title>
</head>
<body>
<%
    User user = (User) session.getAttribute("user");
    ArrayList<Course> courses = (ArrayList<Course>) session.getAttribute("studentCourses");
%>
    <div id="container">
        <h1>Hello StudentID<%= user.getUserId() %> Name <%= user.getUsername() %></h1>
        <select class="form-select" aria-label="Default select example">
            <%
                for (Course course : courses) {
                    out.print("<option value=\"" + course.getCourseCode() + "\">" + course.getCourseName() + "</option>");
                }
            %>
        </select>
    </div>

</body>
</html>
