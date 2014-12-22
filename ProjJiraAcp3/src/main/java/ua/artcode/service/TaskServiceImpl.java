package ua.artcode.service;

import ua.artcode.dao.TaskDaoEntity;
import ua.artcode.dao.UserDaoEntity;
import ua.artcode.model.*;

import java.util.Date;

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
    public void split(Integer taskId) {

    }

    @Override
    public void redirect(Integer taskId, Integer userId) {

    }

    @Override
    public void changeTaskState(Integer taskId, Integer state) {

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
}
