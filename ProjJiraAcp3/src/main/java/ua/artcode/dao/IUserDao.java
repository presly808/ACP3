package ua.artcode.dao;

import ua.artcode.model.User;

/**
 * Created by admin on 14.12.2014.
 */
public interface IUserDao {


    User find(String login, String pass);

    void create(User user);


}
