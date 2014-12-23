package ua.artcode.service;

import ua.artcode.dao.PassportDaoEntity;
import ua.artcode.model.Passport;
import ua.artcode.model.User;

/**
 * Created by Yaroslav on 23.12.2014.
 */
public class Registration {
    PassportDaoEntity passportDaoEntity = new PassportDaoEntity();
    Passport passport = null;
    User user = null;
    public User Autofication(String login, String password) {
        passport = passportDaoEntity.GetPassport(login, password);
        if (passport != null) {
            user = passport.getUser();
        }
        return user;
    }

    public User RegisterNewUser(String login, String password, String name, String email) {
        user = new User(name, email);
        passport = new Passport(login, password, user);
        passportDaoEntity.AddPassport(passport);
        return user;
    }
}
