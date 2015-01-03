package ua.artcode.controller;

import ua.artcode.model.Task;
import ua.artcode.service.TaskServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Yaroslav on 31.12.2014.
 */
@WebServlet("/app/selectTasks/*")
public class SelectTaskController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TaskServiceImpl taskService = (TaskServiceImpl) getServletContext().getAttribute("taskService");
        List<Task> tasks = taskService.showAllTasks();
        req.setAttribute("Tasks",tasks);
        req.getRequestDispatcher("/WEB-INF/pages/view_tasks.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doGet(req,resp);
    }
}
