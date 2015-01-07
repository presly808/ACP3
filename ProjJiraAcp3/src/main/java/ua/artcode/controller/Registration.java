package ua.artcode.controller;

import ua.artcode.model.User;
import ua.artcode.service.RegService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Yaroslav on 27.12.2014.
 */
@WebServlet(value = "/app/reg")
public class Registration extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RegService regService = new RegService();
        if (req.getParameter("pass").equals(req.getParameter("pass2"))) {
            User user = regService.registerNewUser(req.getParameter("login"), req.getParameter("pass"), req.getParameter("name"),
                    req.getParameter("email"));
            if (user != null) {
                HttpSession session = req.getSession(true);
                session.setAttribute("client", user);
                RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/pages/home.jsp");
                rd.forward(req, resp);
            }else {
                RequestDispatcher rd = req.getRequestDispatcher("/err.html");
                rd.forward(req, resp);
            }



        }

    }
}
