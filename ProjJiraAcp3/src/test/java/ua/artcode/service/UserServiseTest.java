package ua.artcode.service;

import org.junit.Before;
import org.junit.Test;
import ua.artcode.dao.TaskDaoEntity;
import ua.artcode.dao.UserDaoEntity;

/**
 * Created by Yaroslav on 22.12.2014.
 */
public class UserServiseTest {
    private IUserService userService;

    @Before
    public void init() {
        userService = new UserServiceImpl(new UserDaoEntity());
    }

    @Test
    public void addUserTest(){

    }

    @Test
    public void readUserTest(){
        userService.read(1);
    }
}
