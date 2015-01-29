package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by mountin on 28/12/2014.
 */
@WebServlet(name = "asdf", value = "/count")
public class CountServer  extends HttpServlet {
    public Integer asd = 0;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[]  cookies = req.getCookies();

    for(Cookie cookie: cookies){
        if(cookie.getName().equals("count")){
            //String asdf = cookie.getValue();
            //cookie.getValue();
            System.out.println(cookie.getValue());
            cookie.setValue(String.valueOf(1+Integer.valueOf(cookie.getValue())));
            resp.addCookie(cookie);
            this.asd = Integer.valueOf(cookie.getValue());
            System.out.println("count="+cookie.getValue());

        }
    }
        if( this.asd == 0) {
            resp.addCookie(new Cookie("count", "0"));
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);

        //getServletContext().setAttribute();
    }



}
