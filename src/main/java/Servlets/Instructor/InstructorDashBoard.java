package Servlets.Instructor;

import DAO.AssessmentDAO;
import DAO.CourseDAO;
import DAO.CriteriaDAO;
import model.Assessment;
import model.Course;
import model.Criteria;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class InstructorDashBoard extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session= req.getSession();
        CourseDAO courseDAO=new CourseDAO();
        AssessmentDAO assessmentDAO=new AssessmentDAO();
        CriteriaDAO criteriaDAO=new CriteriaDAO();

        ArrayList<Course> courses= (ArrayList<Course>) courseDAO.selectAllCourses();
        ArrayList<Assessment> assessments= (ArrayList<Assessment>) assessmentDAO.selectAllAssessments();
        ArrayList<Criteria> criteria= (ArrayList<Criteria>) criteriaDAO.selectAllCriteria();
        session.setAttribute("courses",courses);
        session.setAttribute("assessments",assessments);
        session.setAttribute("criteria",criteria);
        resp.sendRedirect(req.getContextPath()+"/InstructorDashboard.jsp");

    }
}
