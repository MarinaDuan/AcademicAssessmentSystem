
<%@ page import="model.User" %>
<%@ page import="model.Course" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Assessment" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<%
    User user = (User) session.getAttribute("user");
    ArrayList<Course> courses = (ArrayList<Course>) session.getAttribute("courses");

    ArrayList<Assessment> assessments = (ArrayList<Assessment>) session.getAttribute("studentAssessments");
%>


    <div class="container">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Course Code</th>
                <th scope="col">Course Name</th>
                <th scope="col">Instructor ID</th>
            </tr>
            </thead>
            <tbody>
            <%
                for (Course c: courses) {
                    if (c.getStudentId() == user.getUserId()) {
                        out.print("<tr>\n" +
                                "<th scope=\"row\">" + c.getCourseCode() + "</th>\n" +
                                "<td>" + c.getCourseName() + "</td>\n" +
                                "<td>" + c.getInstructorId() + "</td>\n" +
                                "</tr>");
                    }
                }
            %>
            </tbody>
        </table>
        <table class="table">
            <thead>
            <tr>
                <th scope="col">Course Code</th>
                <th scope="col">Student ID</th>
                <th scope="col" colspan="5">Quizzes</th>
                <th scope="col" colspan="3">Assignments</th>
                <th scope="col">Midterm Exam</th>
                <th scope="col">Final Exam</th>
                <th scope="col">Total</th>
            </tr>
            <tr>
                <td></td>
                <td></td>
                <td>Q1</td>
                <td>Q2</td>
                <td>Q3</td>
                <td>Q4</td>
                <td>Q5</td>
                <td>A1</td>
                <td>A2</td>
                <td>A3</td>
                <td></td>
                <td></td>
                <td></td>
            </tr>
            </thead>
            <tbody>
            <%
                for (Assessment assessment : assessments) {
                    for (Course course : courses) {
                        if (assessment.getCourseCode() == course.getCourseCode() &&
                                assessment.getStudentId() == user.getUserId()) {
                            int total = assessment.getQuiz1() + assessment.getQuiz2() + assessment.getQuiz3()
                                    + assessment.getQuiz4() + assessment.getQuiz5()+ assessment.getAssignment1()
                                    + assessment.getAssignment2() + assessment.getAssignment3()
                                    + assessment.getMidExam() + assessment.getFinalExam();
                            out.print("<tr>\n" +
                                    "<th scope=\"row\">" + assessment.getCourseCode() + "</th>\n" +
                                    "<td>" + assessment.getStudentId() + "</td>\n" +
                                    "<td>" + assessment.getQuiz1() + "</td>\n" +
                                    "<td>" + assessment.getQuiz2() + "</td>\n" +
                                    "<td>" + assessment.getQuiz3() + "</td>\n" +
                                    "<td>" + assessment.getQuiz4() + "</td>\n" +
                                    "<td>" + assessment.getQuiz5() + "</td>\n" +
                                    "<td>" + assessment.getAssignment1() + "</td>\n" +
                                    "<td>" + assessment.getAssignment2() + "</td>\n" +
                                    "<td>" + assessment.getAssignment3() + "</td>\n" +
                                    "<td>" + assessment.getMidExam() + "</td>\n" +
                                    "<td>" + assessment.getFinalExam() + "</td>\n" +
                                    "<td>" + total + "</td>" +
                                    "</tr>");
                        }
                    }
                }
            %>
            </tbody>
        </table>
    </div>
</body>
</html>
