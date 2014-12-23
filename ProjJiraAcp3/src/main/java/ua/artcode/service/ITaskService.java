package ua.artcode.service;

import ua.artcode.model.Project;
import ua.artcode.model.TaskPriority;
import ua.artcode.model.TaskState;
import ua.artcode.model.User;

import java.util.Date;

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

    public void showTasks(Date begin, Date end);



}
