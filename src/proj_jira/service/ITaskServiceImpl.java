package proj_jira.service;

import proj_jira.dao.TaskDao;
import proj_jira.data.DataHolder;
import proj_jira.model.Task;

/**
 * Created by admin on 07.12.2014.
 */
public class ITaskServiceImpl implements ITaskService {

    private TaskDao taskDao;

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
    public void addNew(Integer id, String name, Integer desc, Integer prior, Integer state, Integer toId) {
        Task task = new Task();
        taskDao.create(task);
    }
}
