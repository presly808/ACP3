package ua.artcode.dao;

import ua.artcode.data.DataHolder;
import ua.artcode.model.Task;

/**
 * Created by admin on 07.12.2014.
 */
public class TaskDaoImp implements TaskDao {

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
    public boolean update(Integer id, Task changed) {
        return false;
    }

    @Override
    public void delete(Integer id) {

    }
}
