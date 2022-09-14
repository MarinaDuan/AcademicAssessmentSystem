package Servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import DAO.UserDAO;
import model.User;

import java.io.IOException;

public class UserLogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
    //insert user
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        UserDAO userDao = new UserDAO();

        int userId= Integer.parseInt(req.getParameter("userId"));
        String password=req.getParameter("password");

        User user=userDao.userAuthentication(userId,password);

        session.setAttribute("user",user);

        if(user.getUserRole().equals("HOD")){
            RequestDispatcher dispatcher = req.getRequestDispatcher("HODDashboard");
            dispatcher.forward(req, resp);
        } else if(user.getUserRole().equals("instructor")){
            RequestDispatcher dispatcher = req.getRequestDispatcher("InstructorDashboard");
            dispatcher.forward(req, resp);
        }else if(user.getUserRole().equals("student")){
            RequestDispatcher dispatcher = req.getRequestDispatcher("StudentDashboard");
            dispatcher.forward(req, resp);
        }else{
            resp.sendRedirect(req.getContextPath() + "/index.jsp");
        }

    }
}
