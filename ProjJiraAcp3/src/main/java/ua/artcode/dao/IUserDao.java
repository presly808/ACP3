package ua.artcode.dao;

import ua.artcode.model.User;

import java.util.List;

/**
 * Created by admin on 14.12.2014.
 */
public interface IUserDao {


    User find(int id);

    void create(User user);

    List<User> showUsers(String select);

    public boolean userUpdate(User user);

}
