package ua.artcode.db;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by Yaroslav on 22.12.2014.
 */
public class EntityFactoryJira {
    private  static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("Jira");
    private static final EntityManager INSTANCE = factory.createEntityManager();

    public static EntityManager  getInstance(){
        return INSTANCE;
    }
}
