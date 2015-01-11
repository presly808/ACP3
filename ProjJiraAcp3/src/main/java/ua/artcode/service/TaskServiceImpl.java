package ua.artcode.service;

import ua.artcode.dao.ITaskDao;
import ua.artcode.model.*;

import java.util.*;

/**
 * Created by admin on 07.12.2014.
 */
public class TaskServiceImpl implements ITaskService {


    private ITaskDao taskDao;

    public TaskServiceImpl() {

    }

    public TaskServiceImpl(ITaskDao taskDao) {
        this.taskDao= taskDao;
    }


    @Override
    public void redirect(Integer taskId, User executor) {
        Task task = taskDao.read(taskId);
        task.setExecutor(executor);
        taskDao.update(task);
    }

    @Override
    public void changeTaskState(Integer taskId, TaskState state) {
        Task task = taskDao.read(taskId);
        task.setState(state);
        taskDao.update(task);
    }

    @Override
    public void addNew(String description, TaskState state, TaskPriority priority,
                       User author, User executor, Date createDate, Date endDate,
                       int planingHours, int executingHours) {

        Task task = new Task(description, state, priority, author, executor,
                 createDate, endDate, planingHours, executingHours);

        taskDao.create(task);

    }

    @Override
    public Task readTask(int id) {

        return taskDao.read(id);
    }



    @Override
    public void taskUpdate(Task task) {
        taskDao.update(task);
    }

    @Override
    public Set <Task> showAllTasks() {
        Set<Task> list = new LinkedHashSet<Task>();
        list = taskDao.showTasks("SELECT t FROM Task as t");
        for (Task t : list) {
            System.out.println(t);
        }
        return list;
    }

    @Override
    public Set<Task> showMyExecTasks(int id) {
        Set<Task> list = new LinkedHashSet<Task>();
        list = taskDao.showTasks("SELECT t FROM Task as t where t.executor.id = " + id);
        for (Task t : list) {
            System.out.println(t);
        }
        return list;
    }

    @Override
    public Set<Task> showMyCreatedTasks(int id) {
        Set<Task> list = new LinkedHashSet<Task>();
        list = taskDao.showTasks("SELECT t FROM Task as t where t.author.id = " + id);
        for (Task t : list) {
            System.out.println(t);
        }
        return list;
    }
}
