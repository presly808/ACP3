package ua.artcode.service;

import ua.artcode.dao.TaskDaoDB;
import ua.artcode.dao.UserDaoDB;
import ua.artcode.model.*;

import java.util.Date;

/**
 * Created by admin on 07.12.2014.
 */
public class TaskServiceImpl implements ITaskService {

    private TaskDaoDB taskDaoDB;
    private UserDaoDB userDaoDB;

    public TaskServiceImpl() {

    }

    public TaskServiceImpl(TaskDaoDB taskDaoDB, UserDaoDB userDaoDB) {
        this.taskDaoDB = taskDaoDB;
        this.userDaoDB = userDaoDB;
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

        Task task = new Task(id, description, state, priority, author.getId(), executor.getId(),
                project.getId(), createDate, endDate, planingHours, executingHours);

        taskDaoDB.create(task);

    }

    @Override
    public void readTask(int id) {
        Task task = taskDaoDB.read(id);
        User author = userDaoDB.find(task.getAuthor_id());
        User executor = userDaoDB.find(task.getExecutor_id());
        System.out.println("Задача:" + task);
        TaskPriority tp;

        System.out.println("Автор:" + author );
        System.out.println("Исполнитель:" + executor );
    }
}
