package ua.artcode.service;

import org.junit.Before;
import org.junit.Test;
import ua.artcode.dao.TaskDaoEntity;
import ua.artcode.dao.UserDaoEntity;
import ua.artcode.model.*;

import java.util.Date;

/**
 * Created by admin on 13.12.2014.
 */
public class TaskServiceTest {

    private ITaskService taskService;

    @Before
    public void init() {
        taskService = new TaskServiceImpl(new TaskDaoEntity(),new UserDaoEntity());
    }

    @Test
    public void testAddNewTask() {
        String logAuthor = String.valueOf(Math.random() * 100);
        String logExec = String.valueOf(Math.random() * 100);
        User author = new User("Slava", logAuthor, "byaroslav@bk.ru");
        User executor = new User("Oleg", logExec, "oleg@bk.ru");
        Task task = new Task("Opisanie", TaskState.New, TaskPriority.High, author, executor, new Date(), new Date(), 3, 0);
        taskService.addNew("Opisanie", TaskState.New, TaskPriority.High, author, executor, new Date(), new Date(), 3, 0);

    }

    @Test
    public void testReadTask(){
        taskService.readTask(1);
    }



}
