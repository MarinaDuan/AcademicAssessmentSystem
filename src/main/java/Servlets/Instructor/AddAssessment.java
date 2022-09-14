package Servlets.Instructor;

import DAO.AssessmentDAO;
import DAO.CourseDAO;
import model.Assessment;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class AddAssessment extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session= req.getSession();
        AssessmentDAO assessmentDAO=new AssessmentDAO();
        int studentId = Integer.parseInt(req.getParameter("studentId"));
        String courseCode = req.getParameter("courseCode");
        int quiz1 = Integer.parseInt(req.getParameter("quiz1"));
        int quiz2 = Integer.parseInt(req.getParameter("quiz2"));
        int quiz3 = Integer.parseInt(req.getParameter("quiz3"));
        int quiz4 = Integer.parseInt(req.getParameter("quiz4"));
        int quiz5 = Integer.parseInt(req.getParameter("quiz5"));
        int assignment1 = Integer.parseInt(req.getParameter("assignment1"));
        int assignment2 = Integer.parseInt(req.getParameter("assignment2"));
        int assignment3 = Integer.parseInt(req.getParameter("assignment3"));
        int midExam= Integer.parseInt(req.getParameter("midExam"));
        int finalExam = Integer.parseInt(req.getParameter("finalExam"));

        Assessment assessment=new Assessment(studentId, courseCode, quiz1, quiz2, quiz3, quiz4, quiz5, assignment1,
                assignment2, assignment3, midExam, finalExam);

        try {
            assessmentDAO.insertAssessment(assessment);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resp.sendRedirect(req.getContextPath()+"/InstructorDashboard.jsp");
    }
}
