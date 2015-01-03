package ua.artcode.listner;

import ua.artcode.dao.TaskDaoEntity;
import ua.artcode.dao.UserDaoEntity;
import ua.artcode.model.TaskPriority;
import ua.artcode.model.TaskState;
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
        sce.getServletContext().setAttribute("taskService",new TaskServiceImpl(new TaskDaoEntity()));
        sce.getServletContext().setAttribute("userService",new UserServiceImpl(new UserDaoEntity()));
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
