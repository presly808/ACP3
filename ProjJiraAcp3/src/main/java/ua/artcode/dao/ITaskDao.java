package ua.artcode.dao;

import ua.artcode.model.Task;

import java.util.List;

/**
 * CRUD  (Create, Read ,Update, delete)
 */
public interface ITaskDao {

    void create(Task task);

    Task read(Integer id);

    boolean update(Task changed);

    void delete(Integer id);

    List<Task> showTasks(String queryString);

}
