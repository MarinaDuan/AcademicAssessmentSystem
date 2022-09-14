package Servlets.Student;

import DAO.AssessmentDAO;
import DAO.CourseDAO;
import model.Assessment;
import model.Course;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class StudentDashboard extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session= req.getSession();
        CourseDAO courseDAO=new CourseDAO();
        AssessmentDAO assessmentDAO=new AssessmentDAO();
        ArrayList<Course> studentCourses= (ArrayList<Course>) courseDAO.selectAllCoursesForStudent();
        ArrayList<Assessment> studentAssessments= (ArrayList<Assessment>) assessmentDAO.selectAllAssessments();
        session.setAttribute("studentCourses",studentCourses);
        session.setAttribute("studentAssessments",studentAssessments);
        resp.sendRedirect(req.getContextPath()+"/StudentDashboard.jsp");

    }
}
