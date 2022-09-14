package Servlets.HOD;

import DAO.CourseDAO;
import DAO.UserDAO;
import model.Course;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class HODDashboard extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        CourseDAO courseDAO=new CourseDAO();
        //prepopulate instructor with some entries
        UserDAO userDAO=new UserDAO();
        int userId= Integer.parseInt(req.getParameter("instructorId"));
        User user=userDAO.selectUser(userId);

        ArrayList<Course> courses= (ArrayList<Course>) courseDAO.selectAllCourses();
        session.setAttribute("courses",courses);
        session.setAttribute("HODInstructorId",userId);
        resp.sendRedirect(req.getContextPath()+"/HODDashboard.jsp");
    }
}
