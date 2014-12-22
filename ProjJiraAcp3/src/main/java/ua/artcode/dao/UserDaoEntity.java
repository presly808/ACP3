package ua.artcode.dao;

import ua.artcode.db.EntityFactoryJira;
import ua.artcode.model.User;

import javax.persistence.EntityManager;

/**
 * Created by Yaroslav on 22.12.2014.
 */
public class UserDaoEntity implements IUserDao {
    private EntityManager entityManager = EntityFactoryJira.getInstance();

    @Override
    public User find(int id) {
        entityManager.getTransaction().begin();
        User user = entityManager.find(User.class,id);
        entityManager.getTransaction().commit();
        return user;
    }

    @Override
    public void create(User user) {
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
    }
}
