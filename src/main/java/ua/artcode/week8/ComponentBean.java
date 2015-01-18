package ua.artcode.week8;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

/**
 * Created by Yaroslav on 18.01.2015.
 */
@Repository
public class ComponentBean { //componentBean

    @Autowired
    @Qualifier(value = "service1")
    private Service service;

    public ComponentBean() {
    }

    public ComponentBean(Service service) {
        this.service = service;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
}
