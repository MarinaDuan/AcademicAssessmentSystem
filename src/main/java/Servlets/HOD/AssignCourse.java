package Servlets.HOD;

import DAO.CourseDAO;
import model.Course;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class AssignCourse extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CourseDAO courseDAO=new CourseDAO();
        HttpSession session = req.getSession();
        String courseCode = req.getParameter("courseCode");
        String courseName = req.getParameter("courseName");
        int instructorId = Integer.parseInt(req.getParameter("instructorId"));
        int assessmentId = Integer.parseInt(req.getParameter("assessmentId"));
        Course course=new Course(courseCode,courseName,instructorId,assessmentId);
        try {
            courseDAO.insertCourse(course);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        session.setAttribute("course",courseDAO.selectAllCourses());
        resp.sendRedirect(req.getContextPath()+"/HODDashboard.jsp");

    }
}
