package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Arrays;

/**
 * Created by Yaroslav on 28.12.2014.
 */
public class InitContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext().setAttribute("users", Arrays.asList("Oleg", "Tomin", "Sergey"));
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        sce.getServletContext().removeAttribute("users");
    }
}
