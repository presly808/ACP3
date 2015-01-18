package ua.artcode.week8;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Yaroslav on 18.01.2015.
 */
public class TestFirstService {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("application-contex.xml");
        Service service1 = (Service) context.getBean("service1");
        Service service2 = (Service) context.getBean("service2");
        System.out.println(service1);
        System.out.println(service2);
    }
}
