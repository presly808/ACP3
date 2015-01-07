package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Yaroslav on 28.12.2014.
 */
@WebServlet(value = "/data")
public class TestContextServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
/*        List<String> list = (List) getServletContext().getAttribute("users");
        PrintWriter pw = resp.getWriter();
        for (String n : list) {
            pw.println(n);
        }
        pw.flush();
        pw.close();*/
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/pages/users.jsp");
        rd.forward(req,resp);
    }


}
