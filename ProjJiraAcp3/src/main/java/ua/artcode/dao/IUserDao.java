package ua.artcode.dao;

import ua.artcode.model.User;

/**
 * Created by admin on 14.12.2014.
 */
public interface IUserDao {


    User find(int id);

    void create(User user);


}
