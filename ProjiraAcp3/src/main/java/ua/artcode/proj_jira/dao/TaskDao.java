package proj_jira.dao;

import proj_jira.model.Task;

/**
 * CRUD  (Create, Read ,Update, delete)
 */
public interface TaskDao {

    void create(Task task);

    Task read(Integer id);

    boolean update(Integer id, Task changed);

    void delete(Integer id);

}
