package controller;

import model.User;
import org.hibernate.Session;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by mountin on 29/1/2015.
 */
public class UserController extends HttpServlet {
    public HttpSession session;
    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("Hello work");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("this is GET");

        if(req.getParameter("logout") != null){
            this.logOutUser();
        }

        req.getServletContext();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = req.getParameter("user");
        String pass = req.getParameter("password");
        System.out.println(user);

        PrintWriter pw = resp.getWriter();
        User user2 = new User();
        if(user.equals(user2.name) && pass.equals(user2.password)){
            this.loggingUser(req, resp, user);
            RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/pages/tasks.jsp");
            rd.forward(req, resp);
        }else{
            pw.printf("<p>THIS is login %s or password is not correct, please try again</p>", user);
            pw.flush();
        }

        req.getServletContext();

    }

    public boolean loggingUser(HttpServletRequest req, HttpServletResponse resp, String user){

        this.session = req.getSession();

        if(this.session.isNew()){
            System.out.println("session is New");
            this.session.setAttribute("UserLogged", user);
            return  true;

        }else{
            System.out.println("session Olreadey used, please logout");
            return false;
        }

    }

    public void logOutUser(){
        this.session.removeAttribute("UserLogged");
        System.out.println("logged Out!");
    }

}
