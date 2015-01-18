package ua.artcode.controller;

import org.apache.log4j.Logger;
import ua.artcode.exception.LoginException;
import ua.artcode.exception.PasswordException;
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
//   vasia
//1235
@WebServlet("/app/login")
public class AuthorizationController extends HttpServlet {
    private static final Logger logger = Logger.getLogger("ua.artcode.controller.Authorization");
    public static final String CLIENT = "client";

    public AuthorizationController() {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RegService regService = new RegService();
        User user = null;
        try {
            user = regService.autofication(req.getParameter("login").trim(), req.getParameter("pass").trim());
        } catch (LoginException e) {
            PrintWriter pw = resp.getWriter();
            //TODO redirect to error page
            String message = "Login " + req.getParameter("login") + " is bad!";
            pw.println(message);
            pw.close();
            logger.warn(message);

        } catch (PasswordException e) {
            PrintWriter pw = resp.getWriter();
            pw.println("Password is bad!");
            pw.close();
            logger.warn("Password is bad! For login:" + req.getParameter("login"));
        }
        if (user != null) {
            HttpSession session = req.getSession(true);
            session.setAttribute(CLIENT, user);
            RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/pages/home.jsp");
            rd.forward(req, resp);
            logger.info("User " + req.getParameter("login")+ " authorized");
        }
    }
}
