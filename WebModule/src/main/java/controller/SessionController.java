package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Yaroslav on 28.12.2014.
 */

@WebServlet(value = "/session")
public class SessionController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.isNew()) {
            session.setAttribute("user_name", req.getParameter("name"));
            session.setAttribute("user_id", req.getParameter("id"));
            session.setAttribute("count", 0);

            System.out.println("session new");
        } else {
            session.setAttribute("count",(Integer) session.getAttribute("count") + 1);
            System.out.println("not new");
        }

        PrintWriter pw = resp.getWriter();
        pw.println(session.getAttribute("count"));
        pw.close();
    }


}
