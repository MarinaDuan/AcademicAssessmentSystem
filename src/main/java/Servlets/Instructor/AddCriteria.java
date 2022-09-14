package Servlets.Instructor;

import DAO.CriteriaDAO;
import model.Criteria;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AddCriteria extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        CriteriaDAO criteriaDAO=new CriteriaDAO();
        int criteriaId=Integer.parseInt(req.getParameter("criteriaId"));
        Criteria criterion=criteriaDAO.selectCriterion(criteriaId);
        session.setAttribute("criterion",criterion);
        resp.sendRedirect(req.getContextPath()+"/AddCriteria.jsp");
    }
}
