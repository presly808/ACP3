package ua.artcode.service;

import ua.artcode.model.User;

import java.util.List;

/**
 * Created by Yaroslav on 22.12.2014.
 */
public interface IUserService {
    public void addUSer (String name,String login,String email);
    public User read(int id);
    public List<User> showAllUsers();
}
