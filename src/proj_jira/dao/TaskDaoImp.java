package proj_jira.dao;

import proj_jira.data.DataHolder;
import proj_jira.model.Task;

/**
 * Created by admin on 07.12.2014.
 */
public class TaskDaoImp implements TaskDao {

    private DataHolder dataHolder;

    @Override
    public void create(Task task) {
        dataHolder.data.add(task);
    }

    @Override
    public Task read(Integer id) {
        return null;
    }

    @Override
    public boolean update(Integer id, Task changed) {
        return false;
    }

    @Override
    public void delete(Integer id) {

    }
}
