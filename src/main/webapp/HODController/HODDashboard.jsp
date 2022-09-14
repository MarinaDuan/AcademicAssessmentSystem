<%@ page import="model.User" %>
<%@ page import="model.Course" %>
<%@ page import="java.util.ArrayList" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<%
    User user = (User) session.getAttribute("user");
    ArrayList<Course> courses = (ArrayList<Course>) session.getAttribute("courses");
    ArrayList<User> users = (ArrayList<User>) session.getAttribute("users");
%>
<div id="container">
    <table class="table">
        <thead>
        <tr>
            <th scope="col" class="align-top">Course Code</th>
            <th scope="col" class="align-top">Course Name</th>
            <th scope="col" class="align-top">Instructor ID</th>
        </tr>
        </thead>
        <tbody>
        <%
            for (Course course : courses) {
                out.print("<tr>\n" +
                        "<th scope=\"row\">" + course.getCourseCode() + "</th>\n" +
                        "<td>" + course.getCourseName() + "</td>\n" +
                        "<td>" + course.getInstructorId() + "</td>\n" +
                        "<td>\n" +
                        "</tr>");
            }
        %>
        </tbody>
    </table>
</div>
</body>

</html>
