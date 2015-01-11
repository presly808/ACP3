package ua.artcode.service;

import ua.artcode.dao.IUserDao;
import ua.artcode.dao.UserDaoEntity;
import ua.artcode.model.User;

import java.util.List;

/**
 * Created by Yaroslav on 22.12.2014.
 */

public class UserServiceImpl implements IUserService {

    private IUserDao userDao;

    public UserServiceImpl(IUserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void addUSer(String name, String login, String email) {
        userDao.create(new User(name, email));
    }

    @Override
    public User read(int id) {
        return  userDao.find(id);
    }

    @Override
    public List<User> showAllUsers() {
        List<User> users = userDao.showUsers("SELECT u FROM User as u");
        return users;
    }

    public void userUpdate(User user) {
        userDao.userUpdate(user);
    }
}
