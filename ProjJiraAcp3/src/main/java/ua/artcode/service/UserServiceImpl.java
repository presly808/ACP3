package ua.artcode.service;

import ua.artcode.dao.UserDaoEntity;
import ua.artcode.model.Task;
import ua.artcode.model.User;

import java.util.List;

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
    public User read(int id) {
        return  userDaoEntity.find(id);
    }

    @Override
    public void showAllUsers() {
        List<User> users = userDaoEntity.showUsers("SELECT u FROM User as u");
        for (User u : users) {
            System.out.println(u);
        }

    }
}
