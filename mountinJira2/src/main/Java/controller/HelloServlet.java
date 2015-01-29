package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by mountin on 27/12/2014.
 */
public class HelloServlet extends HttpServlet{
    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("Hello work");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);

        String sad  = req.getParameter("number");
        PrintWriter pw = resp.getWriter();
        pw.println("Hello work POST param number="+sad);
        pw.println("<p>THIS is RESPONCE HTML CODE POST</p>");
        pw.flush();

        req.getServletContext();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String sad  = req.getParameter("number");
        System.out.println("doGet Hello from GET");

        PrintWriter pw = resp.getWriter();
        pw.println("<p>THIS is RESPONCE HTML CODE</p>number="+sad);
        pw.flush();
        pw.close();

        req.getServletContext();
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("Hello Servlet was destroyed");

    }
}
