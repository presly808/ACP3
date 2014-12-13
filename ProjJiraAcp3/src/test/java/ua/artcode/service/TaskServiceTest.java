package ua.artcode.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ua.artcode.dao.TaskDaoImp;
import ua.artcode.data.DataHolder;

/**
 * Created by admin on 13.12.2014.
 */
public class TaskServiceTest {

    private ITaskService taskService;
    private DataHolder dataHolder;

    @Before
    public void init(){
        dataHolder = new DataHolder();
        taskService = new ITaskServiceImpl(new TaskDaoImp(dataHolder));
    }

    @Test
    public void testAddNewTask() {
        taskService.addNew(1, "new", 3, 4, 3, 1);
        Assert.assertTrue("list is empty",dataHolder.data.size() > 0);
    }


}
