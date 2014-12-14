package ua.artcode.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import proj_jira.data.DataHolder;
import proj_jira.service.ITaskService;
import ua.artcode.proj_jira.service.ITaskServiceImpl;
import proj_jira.dao.TaskDaoImp;

/**
 * Created by mountin on 13/12/2014.
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