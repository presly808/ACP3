package ua.artcode.service;

import ua.artcode.dao.UserDaoEntity;
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
    public List<User> showAllUsers() {
        List<User> users = userDaoEntity.showUsers("SELECT u FROM User as u");
        return users;
    }

    public void userUpdate(User user) {
        userDaoEntity.userUpdate(user);
    }
}
