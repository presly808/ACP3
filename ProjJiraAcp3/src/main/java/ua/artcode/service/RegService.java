package ua.artcode.service;

import ua.artcode.dao.PassportDaoEntity;
import ua.artcode.exception.LoginException;
import ua.artcode.exception.PasswordException;
import ua.artcode.model.Passport;
import ua.artcode.model.User;

/**
 * Created by Yaroslav on 23.12.2014.
 */
public class RegService {
    PassportDaoEntity passportDaoEntity = new PassportDaoEntity();
    Passport passport = null;
    User user = null;
    public User autofication(String login, String password) throws PasswordException, LoginException {
        passport = passportDaoEntity.isLogin(login);
        if (passport != null) {
            if (password.equals(passport.getPass())) {
                user = passport.getUser();
            } else {
                throw new PasswordException("pass");
            }
        } else {
            throw new LoginException();
        }
        return user;
    }

    public User registerNewUser(String login, String password, String name, String email) throws LoginException {
        if (passportDaoEntity.isLogin(login) == null) {
            user = new User(name, email);
            passport = new Passport(login, password, user);
            passportDaoEntity.AddPassport(passport);
            return user;
        } else {
            throw new LoginException();
        }

    }
}
