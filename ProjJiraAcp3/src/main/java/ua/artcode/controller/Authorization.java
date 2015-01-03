package ua.artcode.controller;

import ua.artcode.model.User;
import ua.artcode.service.RegService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Yaroslav on 27.12.2014.
 */
@WebServlet("/app/login")
public class Authorization extends HttpServlet {
    public Authorization() {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RegService regService = new RegService();
        User user = regService.autofication(req.getParameter("login"), req.getParameter("pass"));

        if (user!=null) {
            HttpSession session = req.getSession(true);
            System.out.println(user);
            session.setAttribute("client", user);
            RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/pages/home.jsp");
            rd.forward(req,resp);


        }

        PrintWriter pw = resp.getWriter();
        pw.println("Не верный логин или пароль");
        pw.flush();
        pw.close();

    }


}
