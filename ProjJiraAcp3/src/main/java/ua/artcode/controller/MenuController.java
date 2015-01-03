package ua.artcode.controller;

import ua.artcode.model.Task;
import ua.artcode.service.TaskServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Yaroslav on 31.12.2014.
 */
@WebServlet(value = "/menu/*")
public class MenuController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = null;
        String path = req.getPathInfo();
        System.out.println(path);
        if (path == null) {
            rd = req.getRequestDispatcher("/WEB-INF/pages/main_menu.jsp");
        } else if (path.endsWith("addTask")) {
            rd = req.getRequestDispatcher("/WEB-INF/pages/add_task.jsp");
        } else if (path.endsWith("selectTasks")) {
            rd = req.getRequestDispatcher("/WEB-INF/pages/select_task.jsp");
        } else if (path.endsWith("editTask")) {
            rd = req.getRequestDispatcher("/WEB-INF/pages/edit_task.jsp");
            int id = Integer.parseInt(req.getParameter("id"));
            TaskServiceImpl taskService = (TaskServiceImpl) getServletContext().getAttribute("taskService");
            Task task = taskService.readTask(id);
            req.setAttribute("task",task);

        }

        rd.forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
