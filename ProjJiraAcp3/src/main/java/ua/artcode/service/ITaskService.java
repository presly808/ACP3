package ua.artcode.service;

import ua.artcode.model.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 *
 */
public interface ITaskService {


    public void redirect(Integer taskId, User executor);
    public void changeTaskState(Integer taskId, TaskState state);

    public void addNew(String description, TaskState state, TaskPriority priority,
                       User author, User executor, Date createDate, Date endDate,
                       int planingHours, int executingHours);

    public Task readTask(int id);

    public void taskUpdate(Task task);
    public Set<Task> showAllTasks();
    public Set<Task> showMyExecTasks(int id);
    public Set<Task> showMyCreatedTasks(int id);



}
