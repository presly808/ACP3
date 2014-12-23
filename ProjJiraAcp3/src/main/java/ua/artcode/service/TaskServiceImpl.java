package ua.artcode.service;

import ua.artcode.dao.TaskDaoEntity;
import ua.artcode.dao.UserDaoEntity;
import ua.artcode.model.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by admin on 07.12.2014.
 */
public class TaskServiceImpl implements ITaskService {


    private TaskDaoEntity taskDaoEntity;
    private UserDaoEntity userDaoEntity;

    public TaskServiceImpl() {

    }

    public TaskServiceImpl(TaskDaoEntity taskDaoEntity, UserDaoEntity userDaoEntity) {
        this.taskDaoEntity = taskDaoEntity;
        this.userDaoEntity = userDaoEntity;
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
    public void readTask(int id) {
        Task task = taskDaoEntity.read(id);
        System.out.println(task);
    }

    @Override
    public void showTasks(Date begin, Date end) {
        List<Task> list = new ArrayList<>();
        list = taskDaoEntity.showTasks(begin, end);
        for (Task t : list) {
            System.out.println(t);
        }
    }
}
