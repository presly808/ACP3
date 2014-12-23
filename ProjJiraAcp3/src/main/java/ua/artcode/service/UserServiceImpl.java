package ua.artcode.service;

import ua.artcode.dao.UserDaoEntity;
import ua.artcode.model.Task;
import ua.artcode.model.User;

/**
 * Created by Yaroslav on 22.12.2014.
 */

public class UserServiceImpl implements IUserService {

    private UserDaoEntity userDaoEntity;

    public UserServiceImpl(UserDaoEntity userDaoEntity) {
        this.userDaoEntity = userDaoEntity;
    }

    @Override
    public void addUSer(String name, String login, String email) {
        userDaoEntity.create(new User(name, email));
    }

    @Override
    public void read(int id) {
        User user = userDaoEntity.find(id);
        System.out.println(user);
        System.out.println("----------------My task--------------------");
        if(user.getMyTasks().size()>0) {
            for (Task t : user.getMyTasks()) {
                System.out.println(t);
            }
        }
        System.out.println("--------------CreatedTask------------------");
        if(user.getCreatedTasks().size()>0) {
            for (Task t : user.getCreatedTasks()) {
                System.out.println(t);
            }
        }

    }
}
