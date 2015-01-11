package ua.artcode.controller;

import ua.artcode.model.*;
import ua.artcode.service.ITaskService;
import ua.artcode.service.IUserService;
import ua.artcode.service.TaskServiceImpl;
import ua.artcode.service.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * Created by Yaroslav on 28.12.2014.
 */
@WebServlet(value = "/app/addComment")
public class addCommentController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // req.setCharacterEncoding("UTF-8");
        ITaskService taskService = (TaskServiceImpl) getServletContext().getAttribute("taskService");
        IUserService userService = (UserServiceImpl) getServletContext().getAttribute("userService");
        Task task = taskService.readTask(Integer.parseInt(req.getParameter("id")));
        String message = (String) req.getParameter("comment");
        User client = (User) req.getSession().getAttribute("client");
        Comment comment = new Comment();
        comment.setAuthor(client);
        comment.setMessage(message);
        comment.setCreateDate(new Date());
        comment.setTask(task);
        task.getComments().add(comment);
        taskService.taskUpdate(task);
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/pages/show_task.jsp");
        req.setAttribute("task",task);
        rd.forward(req, resp);


    }

    private TaskState getTaskState(int id) {

        TaskState state = null;
        switch (id) {
            case 1: {
                state = TaskState.New;
                break;
            }
            case 2: {
                state = TaskState.Pressed;
                break;
            }
            case 3: {
                state = TaskState.Close;
                break;
            }
            case 4: {
                state = TaskState.Reopening;
                break;
            }

        }
        return state;
    }
    private TaskPriority getTaskPriority(int id) {

        TaskPriority prority = null;
        switch (id) {
            case 1: {
                prority = TaskPriority.Critical;
                break;
            }
            case 2: {
                prority = TaskPriority.High;
                break;
            }
            case 3: {
                prority = TaskPriority.Medium;
                break;
            }
            case 4: {
                prority = TaskPriority.Low;
                break;
            }

        }
        return prority;
    }

}
