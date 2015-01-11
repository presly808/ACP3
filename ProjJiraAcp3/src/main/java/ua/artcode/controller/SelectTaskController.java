package ua.artcode.controller;

import ua.artcode.model.Task;
import ua.artcode.model.User;
import ua.artcode.service.TaskServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Set;

/**
 * Created by Yaroslav on 31.12.2014.
 */
@WebServlet("/app/selectTasks/*")
public class SelectTaskController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User client = (User) req.getSession().getAttribute("client");
        int clientId = client.getId();
        int menu = 0;
        menu = Integer.parseInt(req.getParameter("menu"));
        TaskServiceImpl taskService = (TaskServiceImpl) getServletContext().getAttribute("taskService");
        if (menu==1) {
            Set<Task> tasks = taskService.showAllTasks();
            req.setAttribute("Tasks", tasks);
        } else if (menu==2) {
            Set<Task> tasks = taskService.showMyCreatedTasks(clientId);
            req.setAttribute("Tasks", tasks);
        } else if (menu==3) {
            Set<Task> tasks = taskService.showMyExecTasks(clientId);
            req.setAttribute("Tasks", tasks);
        }

        req.getRequestDispatcher("/WEB-INF/pages/view_tasks.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doGet(req,resp);
    }
}
