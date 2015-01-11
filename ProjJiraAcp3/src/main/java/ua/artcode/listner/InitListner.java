package ua.artcode.listner;

import ua.artcode.dao.ITaskDao;
import ua.artcode.dao.IUserDao;
import ua.artcode.dao.TaskDaoEntity;
import ua.artcode.dao.UserDaoEntity;
import ua.artcode.model.TaskPriority;
import ua.artcode.model.TaskState;
import ua.artcode.service.ITaskService;
import ua.artcode.service.IUserService;
import ua.artcode.service.TaskServiceImpl;
import ua.artcode.service.UserServiceImpl;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Created by Yaroslav on 28.12.2014.
 */
@WebListener
public class InitListner implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ITaskDao taskDao = new TaskDaoEntity();
        ITaskService taskService = new TaskServiceImpl(taskDao);
        sce.getServletContext().setAttribute("taskService",taskService);

        IUserDao userDao = new UserDaoEntity();
        IUserService userService = new UserServiceImpl(userDao);
        sce.getServletContext().setAttribute("userService", userService);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
