<%@ page import="model.User" %>
<%@ page import="model.Course" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Criteria" %>
<%@ page import="model.Assessment" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<%
    User user = (User) session.getAttribute("user");
    ArrayList<Course> courses = (ArrayList<Course>) session.getAttribute("courses");
    ArrayList<Criteria> criteria = (ArrayList<Criteria>) session.getAttribute("criteria");
    ArrayList<Assessment> assessments = (ArrayList<Assessment>) session.getAttribute("assessments");
%>

<div id="container">
    <table class="table">
        <thead>
        <tr>
            <th scope="col" class="align-top">Course Code</th>
            <th scope="col" class="align-top">Course Name</th>
            <th scope="col" class="align-top">Criteria ID</th>
        </tr>
        </thead>
        <tbody>
        <%
            for (Course course : courses) {
                if (course.getInstructorId() == user.getUserId()) {
                    out.print("<tr>\n" +
                            "<th scope=\"row\">" + course.getCourseCode() + "</th>\n" +
                            "<td>" + course.getCourseName()+ "</td>\n" +
                            "<td>" + course.getAssessmentId() + "</td>\n" +
                            "<td>\n" +
                            "</tr>");
                }
            }
        %>
        </tbody>
    </table>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Course ID</th>
            <th scope="col" class="align-top">Assessment Criteria ID</th>
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
            for (Criteria criterion : criteria) {
                for (Course course : courses) {
                    if (criterion.getCourseCode() == course.getCourseCode() &&
                            course.getInstructorId() == user.getUserId()) {
                        int total = criterion.getQuiz1() + criterion.getQuiz2() + criterion.getQuiz3()
                                + criterion.getQuiz4() + criterion.getQuiz5()
                                + criterion.getAssignment1() + criterion.getAssignment2() + criterion.getAssignment3()
                                + criterion.getMidExam() + criterion.getFinalExam();
                        out.print("<tr>\n" +
                                "<th scope=\"row\">" + criterion.getCourseCode() + "</th>\n" +
                                "<td>" + criterion.getCriteriaId() + "</td>\n" +
                                "<td>" + criterion.getQuiz1() + "</td>\n" +
                                "<td>" + criterion.getQuiz2() + "</td>\n" +
                                "<td>" + criterion.getQuiz3() + "</td>\n" +
                                "<td>" + criterion.getQuiz4() + "</td>\n" +
                                "<td>" + criterion.getQuiz5() + "</td>\n" +
                                "<td>" + criterion.getAssignment1() + "</td>\n" +
                                "<td>" + criterion.getAssignment2() + "</td>\n" +
                                "<td>" + criterion.getAssignment3() + "</td>\n" +
                                "<td>" + criterion.getMidExam() + "%</td>\n" +
                                "<td>" + criterion.getFinalExam() + "%</td>\n" +
                                "<td>" + total + "%</td>" +
                                "<td>\n" +
                                "</tr>");
                    }
                }
            }
        %>
        </tbody>
    </table>
    <table class="table>
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
                            course.getInstructorId() == user.getUserId()) {
                        int total = assessment.getQuiz1() + assessment.getQuiz2() + singleAssessment.getQuiz3()
                                + assessment.getQuiz4() + assessment.getQuiz5()
                                + assessment.getAssignment1() + assessment.getAssignment2() + singleAssessment.getAssignment3()
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
                                "<td>\n" +
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
