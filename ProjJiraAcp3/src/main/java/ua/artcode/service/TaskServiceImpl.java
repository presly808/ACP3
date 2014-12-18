package ua.artcode.service;

import ua.artcode.dao.TaskDao;
import ua.artcode.dao.TaskDaoDB;
import ua.artcode.dao.TaskDaoImp;
import ua.artcode.model.*;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by admin on 07.12.2014.
 */
public class TaskServiceImpl implements ITaskService {

    private TaskDaoDB taskDaoDB;

    public TaskServiceImpl() {
    }

    public TaskServiceImpl(TaskDaoDB taskDaoDB
    ) {
        this.taskDaoDB = taskDaoDB;
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
    public void addNew(int id, String description, int state, int priority,
                       User author, User executor, Project project, Date createDate, Date endDate,
                       Date planingHours, Date executingHours) {





        Task task = new Task(id, description, state, priority, author.getId(), executor.getId(), 0,
                project.getId(), createDate, endDate, planingHours, executingHours, 0);

        taskDaoDB.create(task);

    }
}
