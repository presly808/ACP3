package listener;

import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Arrays;

/**
 * Created by mountin on 28/12/2014.
 */
public class InitListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //sce.setAttribute("users", Arrays.asList("Kolya", "Vasya", "Nokilay"));
        sce.getServletContext().setAttribute("users", Arrays.asList("Kolya", "Vasya", "Nokilay"));
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        sce.getServletContext().removeAttribute("users");
    }


}
