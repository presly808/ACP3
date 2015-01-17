package proj_jira.service;

import proj_jira.model.Task;
import proj_jira.model.User;

/**
 *
 */
public interface ITaskService {

    public void split(Integer taskId);

    public void redirect(Integer taskId, Integer userId);

    public void changeTaskState(Integer taskId, Integer state);

    public void addNew(Integer id, String name, Integer desc,
                       Integer prior, Integer state, Integer toId);

}
