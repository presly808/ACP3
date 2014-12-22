/*
package ua.artcode.view;

import ua.artcode.dao.IUserDao;
import ua.artcode.dao.UserDaoDB;
import ua.artcode.model.User;

import java.util.Scanner;

*/
/**
 * Created by Yaroslav on 14.12.2014.
 *//*

public class Authorization {

    private Scanner scanner = new Scanner(System.in);
    private IUserDao dao = new UserDaoDB();
    private User user;

    public User mainMenu(){
        System.out.println("Добрый день!");
        System.out.println("Для входа введите       - 1.");
        System.out.println("Для регистрации введите - 2.");
        System.out.println("Для выхода -            - 0.");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1: {
                user = enterMenu();
                break;
            }
            case 2:{
                user = registerMenu();
                break;
            }
            case 0:{
                System.exit(0);
            }
        }

        return user;

    }

    private User registerMenu() {
        System.out.println("Введите имя:");
        String name = scanner.next();
        System.out.println("Введите логин:");
        String login = scanner.next();
        System.out.println("Введите пароль:");
        String pass = scanner.next();
        System.out.println("Введите e-mail:");
        String email = scanner.next();
        User tmpUser = new User(0, name, login, pass, email);
        dao.create(tmpUser);
        return dao.find(login, pass);
    }

    private User enterMenu() {
        System.out.println("Введите логин:");
        String login = scanner.next();
        System.out.println("Введите пароль:");
        String pass = scanner.next();
        return dao.find(login, pass);
    }

}
*/
