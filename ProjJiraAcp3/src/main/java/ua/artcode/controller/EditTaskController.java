package ua.artcode.controller;

import org.apache.log4j.Logger;
import ua.artcode.model.Task;
import ua.artcode.model.TaskPriority;
import ua.artcode.model.TaskState;
import ua.artcode.model.User;
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
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

/**
 * Created by Yaroslav on 28.12.2014.
 */
@WebServlet(value = "/app/editTaskController")
public class EditTaskController extends HttpServlet {
    private static final Logger logger = Logger.getLogger("ua.artcode.controller.AddTaskController");
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        ITaskService taskService = (TaskServiceImpl) getServletContext().getAttribute("taskService");
        IUserService userService = (UserServiceImpl) getServletContext().getAttribute("userService");
        Task task = taskService.readTask(Integer.parseInt(req.getParameter("id")));
        String desc = (String) req.getParameter("desc");
        Integer prorityID = Integer.parseInt((String) req.getParameter("taskPriority"));
        Integer stateID = Integer.parseInt((String) req.getParameter("taskState"));
        TaskPriority prority = getTaskPriority(prorityID);
        TaskState state = getTaskState(stateID);
        Integer execID = Integer.parseInt((String) req.getParameter("executor"));
        User exec = userService.read(execID);
        User client = (User) req.getSession().getAttribute("client");
        String spH = (String) req.getParameter("pHours");
        String seH = (String) req.getParameter("eHours");
        Integer pH = 0;
        Integer eH = 0;

        if (spH != null && spH.length()>0) {
            pH = Integer.parseInt(spH);
        }
        if (seH != null && seH.length()>0) {
            eH = Integer.parseInt(seH);
        }

        task.setDescription(desc);
        task.setState(state);
        task.setPriority(prority);
        task.setExecutor(exec);
        task.setPlaningHours(pH);
        task.setExecutingHours(eH);
        taskService.taskUpdate(task);
        RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/pages/show_task.jsp");
        req.setAttribute("task",task);
        rd.forward(req, resp);
        logger.info(client.getName() + " edit task id:" + task.getId());


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
