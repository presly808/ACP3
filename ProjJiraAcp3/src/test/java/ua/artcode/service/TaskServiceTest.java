package ua.artcode.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ua.artcode.dao.TaskDaoDB;
import ua.artcode.dao.UserDaoDB;
import ua.artcode.data.DataHolder;
import ua.artcode.model.Project;
import ua.artcode.model.User;

import java.util.Date;

/**
 * Created by admin on 13.12.2014.
 */
public class TaskServiceTest {

    private ITaskService taskService;
    private UserDaoDB userDaoDB;

    @Before
    public void init() {
        taskService = new TaskServiceImpl(new TaskDaoDB(),new UserDaoDB());
        userDaoDB = new UserDaoDB();
    }

    @Test
    public void testAddNewTask() {
        User author = userDaoDB.find(1);
        User executor = userDaoDB.find(2);

        taskService.addNew(1, "Opisanie", 1,1, author, executor, new Project(1, "Test"), new Date(), new Date(),
                new Date(), new Date());

    }

    @Test
    public void testReadTask(){
        taskService.readTask(1);
    }



}
