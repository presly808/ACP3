package ua.artcode.dao;

import ua.artcode.model.Task;

import java.util.List;
import java.util.Set;

/**
 * CRUD  (Create, Read ,Update, delete)
 */
public interface ITaskDao {

    void create(Task task);

    Task read(Integer id);

    boolean update(Task changed);

    void delete(Integer id);

    Set<Task> showTasks(String queryString);

}
