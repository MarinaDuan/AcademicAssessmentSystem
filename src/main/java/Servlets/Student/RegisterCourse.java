package Servlets.Student;

import DAO.CourseDAO;
import model.Course;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class RegisterCourse extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CourseDAO studentCourseDAO=new CourseDAO();
        HttpSession session = req.getSession();
        int studentId = Integer.parseInt(req.getParameter("studentId"));
        String courseCode = req.getParameter("courseCode");
        String courseName = req.getParameter("courseName");
        Course studentCourse=new Course(studentId,courseCode,courseName);
        try {
            studentCourseDAO.insertCourseForStudent(studentCourse);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        session.setAttribute("studentId",studentId);
        session.setAttribute("courseCode",courseCode);
        session.setAttribute("courseName",courseName);

        resp.sendRedirect(req.getContextPath()+"/studentDashboard.jsp");

    }
}
