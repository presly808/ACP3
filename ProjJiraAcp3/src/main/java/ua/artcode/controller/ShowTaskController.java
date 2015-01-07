package ua.artcode.controller;

import ua.artcode.model.Task;
import ua.artcode.model.User;
import ua.artcode.service.TaskServiceImpl;
import ua.artcode.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Yaroslav on 31.12.2014.
 */
@WebServlet(value = "/app/showtask")
public class ShowTaskController extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Task task = null;
        TaskServiceImpl taskService = (TaskServiceImpl) getServletContext().getAttribute("taskService");
        UserServiceImpl userService = (UserServiceImpl) getServletContext().getAttribute("userService");

        String sid = req.getParameter("id");
        Integer id = 0;
        if (sid != null) id = Integer.parseInt(sid);
        if (id>0) task = taskService.readTask(id);
        User client = (User) (req.getSession().getAttribute("client"));

        client.getVisitTasks().add(task);
        task.getVisitors().add(client);
        taskService.taskUpdate(task);
        req.setAttribute("task", task);
        req.getRequestDispatcher("/WEB-INF/pages/show_task.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
