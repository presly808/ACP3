package ua.artcode.service;

import ua.artcode.model.Project;
import ua.artcode.model.State;
import ua.artcode.model.TaskPriority;
import ua.artcode.model.User;

import java.util.Date;

/**
 *
 */
public interface ITaskService {

    public void split(Integer taskId);

    public void redirect(Integer taskId, Integer userId);

    public void changeTaskState(Integer taskId, Integer state);

    public void addNew(int id, String description, int state, int priority,
                       User author, User executor, Project project, Date createDate, Date endDate,
                       Date planingHours, Date executingHours);

    public void readTask(int id);



}
