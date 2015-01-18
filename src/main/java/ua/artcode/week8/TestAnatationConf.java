package ua.artcode.week8;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Yaroslav on 18.01.2015.
 */
public class TestAnatationConf {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("application-contex.xml");
        ComponentBean componentBean = context.getBean("componentBean",ComponentBean.class);
    }
}
