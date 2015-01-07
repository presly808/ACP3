package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Yaroslav on 28.12.2014.
 */
@WebServlet(name = "CountServlet",value = "/count")
public class CountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        if (cookies.length > 0) {
            for (Cookie c : cookies) {
                if ("count".equals(c.getName())) {
                    int count = Integer.parseInt(c.getValue());
                    resp.addCookie(new Cookie("count", String.valueOf(count+1)));
                    PrintWriter pw = resp.getWriter();
                    pw.println(count);
                    pw.flush();
                    pw.close();
                }
            }
        }
        resp.addCookie(new Cookie("count", "1"));


    }
}
