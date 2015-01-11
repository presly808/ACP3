package ua.artcode.dao;

import ua.artcode.data.DataHolder;
import ua.artcode.model.Task;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by admin on 07.12.2014.
 */
public class TaskDaoImp implements ITaskDao {

    private DataHolder dataHolder;

    public TaskDaoImp() {
    }

    public TaskDaoImp(DataHolder dataHolder) {
        this.dataHolder = dataHolder;
    }

    @Override
    public void create(Task task) {
        dataHolder.data.add(task);
    }

    @Override
    public Task read(Integer id) {
        return null;
    }

    @Override
    public boolean update(Task changed) {
        return false;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public Set<Task> showTasks(String queryString) {
        return null;
    }


}
