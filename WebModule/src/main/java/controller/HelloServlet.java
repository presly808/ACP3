package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PipedWriter;
import java.io.PrintWriter;

/**
 * Created by Yaroslav on 27.12.2014.
 */
public class HelloServlet extends HttpServlet {
    public HelloServlet() {
        super();
        System.out.println("Hello");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet Hello");
        PrintWriter pw = resp.getWriter();

        pw.println("<html>" +
                "<body>" +
                "<h1> Hello Server </h1>  <form method=\"post\" action=\"hello\">\n" +
                "First name:<br>\n" +
                "<input type=\"text\" name=\"firstname\" value=\"Mickey\">\n" +
                "<br>\n" +
                "Last name:<br>\n" +
                "<input type=\"text\" name=\"lastname\" value=\"Mouse\">\n" +
                "<br><br>\n" +
                "<input type=\"submit\" value=\"Submit\">\n" +
                "</form> "+
                "</body>" +
                "</html>");
        pw.flush();
        pw.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String name = req.getParameter("firstname");
       String lastname = req.getParameter("lastname");
        System.out.println(name + " " + lastname);

    }
}
