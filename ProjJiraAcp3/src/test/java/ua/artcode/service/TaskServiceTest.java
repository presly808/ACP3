package ua.artcode.service;

import org.junit.Before;
import org.junit.Test;
import ua.artcode.dao.TaskDaoEntity;
import ua.artcode.dao.UserDaoEntity;
import ua.artcode.model.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
        User author = new User("Slava", "byaroslav@bk.ru");
        User executor = new User("Oleg", "oleg@bk.ru");
        Task task = new Task("Opisanie", TaskState.New, TaskPriority.High, author, executor, new Date(), new Date(), 3, 0);
        taskService.addNew("Opisanie", TaskState.New, TaskPriority.High, author, executor, new Date(), new Date(), 3, 0);

    }

    @Test
    public void testReadTask(){
        taskService.readTask(1);
    }

    @Test
    public void testChangeTaskState() {
        taskService.changeTaskState(2,TaskState.Close);
        taskService.readTask(2);
    }

    @Test
    public void testRedirect() {
        User executor = new User("xxx", "log@bk.ru");
        taskService.redirect(1,executor);

    }

    @Test
    public void TestShowTask() {
        Date b = null;
        Date e = null;
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
        try {
            b = ft.parse("2014-01-01");
            e = ft.parse("2014-12-23");
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        taskService.showTasks(b, e);
    }

}
