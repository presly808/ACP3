package ua.artcode.dao;

import ua.artcode.db.EntityFactoryJira;
import ua.artcode.model.Task;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;

/**
 * Created by Yaroslav on 22.12.2014.
 */
public class TaskDaoEntity implements ITaskDao {
    EntityManager entityManager = EntityFactoryJira.getInstance();
    @Override
    public void create(Task task) {
        entityManager.getTransaction().begin();
        entityManager.persist(task);
        entityManager.getTransaction().commit();

    }

    @Override
    public Task read(Integer id) {
        entityManager.getTransaction().begin();
        Task task = entityManager.find(Task.class, id);
        entityManager.getTransaction().commit();
        return task;
    }

    @Override
    public boolean update(Task changed) {
        entityManager.getTransaction().begin();
        entityManager.merge(changed);
        entityManager.getTransaction().commit();
        return true;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<Task> showTasks(Date begin, Date end) {
        Query query  = entityManager.createQuery("SELECT tasks FROM Task " +
                "as tasks where tasks.createDate > :begin and tasks.createDate < :end ");
        query.setParameter("begin", begin);
        query.setParameter("end", end);
        List<Task> list = query.getResultList();
        return list;

    }
}
