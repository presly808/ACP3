package ua.artcode.service;

import ua.artcode.model.*;

import java.util.Date;
import java.util.List;

/**
 *
 */
public interface ITaskService {


    public void redirect(Integer taskId, User executor);

    public void changeTaskState(Integer taskId, TaskState state);

    public void addNew(String description, TaskState state, TaskPriority priority,
                       User author, User executor, Date createDate, Date endDate,
                       int planingHours, int executingHours);

    public void readTask(int id);

    public List<Task> showAllTasks();



}
