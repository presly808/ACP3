package ua.artcode.view;

import ua.artcode.model.User;
import ua.artcode.service.RegService;

import java.util.Scanner;






public class Authorization {

    private Scanner scanner = new Scanner(System.in);
    private User user = null;
    private RegService regService = new RegService();


    public User mainMenu(){

        System.out.println("Для входа введите       - 1.");
        System.out.println("Для регистрации введите - 2.");
        System.out.println("Для выхода -            - 0.");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1: {
                enterMenu();
                break;
            }
            case 2:{
                registerMenu();
                break;
            }
            case 0:{
                System.exit(0);
            }
        }

    return user;

    }

    private void registerMenu() {
        System.out.println("Введите имя:");
        String name = scanner.next();
        System.out.println("Введите логин:");
        String login = scanner.next();
        System.out.println("Введите пароль:");
        String pass = scanner.next();
        System.out.println("Введите e-mail:");
        String email = scanner.next();
        user = regService.registerNewUser(login, pass, name, email);


    }

    private void enterMenu() {
        System.out.println("Введите логин:");
        String login = scanner.next();
        System.out.println("Введите пароль:");
        String pass = scanner.next();
        user =  regService.autofication(login, pass);
        if (user == null) {
            System.out.println("Не верный логин или пароль!!! Введит еще раз!!!");
            enterMenu();
        }
    }

}

