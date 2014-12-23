package ua.artcode.view;

import ua.artcode.model.User;
import ua.artcode.service.Registration;

import java.util.Scanner;






public class Authorization {

    private Scanner scanner = new Scanner(System.in);
    private User user = null;
    private Registration registration = new Registration();


    public void mainMenu(){
        System.out.println("Добрый день!");
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
        user = registration.RegisterNewUser(login, pass, name, email);


    }

    private void enterMenu() {
        System.out.println("Введите логин:");
        String login = scanner.next();
        System.out.println("Введите пароль:");
        String pass = scanner.next();
        user =  registration.Autofication(login, pass);
    }

}

