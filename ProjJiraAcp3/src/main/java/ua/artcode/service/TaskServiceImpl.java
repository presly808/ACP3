package ua.artcode.service;

import ua.artcode.dao.TaskDaoEntity;
import ua.artcode.model.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by admin on 07.12.2014.
 */
public class TaskServiceImpl implements ITaskService {


    private TaskDaoEntity taskDaoEntity;

    public TaskServiceImpl() {

    }

    public TaskServiceImpl(TaskDaoEntity taskDaoEntity) {
        this.taskDaoEntity = taskDaoEntity;
    }


    @Override
    public void redirect(Integer taskId, User executor) {
        Task task = taskDaoEntity.read(taskId);
        task.setExecutor(executor);
        taskDaoEntity.update(task);
    }

    @Override
    public void changeTaskState(Integer taskId, TaskState state) {
        Task task = taskDaoEntity.read(taskId);
        task.setState(state);
        taskDaoEntity.update(task);
    }

    @Override
    public void addNew(String description, TaskState state, TaskPriority priority,
                       User author, User executor, Date createDate, Date endDate,
                       int planingHours, int executingHours) {

        Task task = new Task(description, state, priority, author, executor,
                 createDate, endDate, planingHours, executingHours);

        taskDaoEntity.create(task);

    }

    @Override
    public Task readTask(int id) {

        return taskDaoEntity.read(id);
    }

    @Override
    public List<Task> showAllTasks() {
        List<Task> list = new ArrayList<Task>();
        list = taskDaoEntity.showTasks("SELECT t FROM Task as t");
        for (Task t : list) {
            System.out.println(t);
        }
        return list;
    }

    @Override
    public void taskUpdate(Task task) {
        taskDaoEntity.update(task);
    }
}
