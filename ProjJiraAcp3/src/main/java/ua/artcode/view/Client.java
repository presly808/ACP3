package ua.artcode.view;

import ua.artcode.model.TaskPriority;
import ua.artcode.model.TaskState;
import ua.artcode.model.User;
import ua.artcode.network.*;

import java.io.*;
import java.net.Socket;
import java.util.Date;

/**
 * Created by Yaroslav on 24.12.2014.
 */
public class Client {
    public static void main(String args[]) throws Exception
    {
        System.out.println("Client Started");
        Socket soc = new Socket("127.0.0.1",5217);
        transferClient t=new transferClient(soc);
        t.loginMenu();

    }
}
class transferClient extends Thread{
    Socket socket;
    ObjectInputStream ois;
    ObjectOutputStream oos;
    BufferedReader br;
    MyPackage pack;
    int client = 0;
    String clientName = "";

    transferClient(Socket soc){
        socket = soc;
        try {
            ois = new ObjectInputStream(soc.getInputStream());
            oos = new ObjectOutputStream(soc.getOutputStream());
            br = new BufferedReader(new InputStreamReader(System.in));


        } catch (IOException e) {
            e.printStackTrace();
        }
        pack = new MyPackage();
        System.out.println("Client Started 2");
    }

    public void loginMenu() throws Exception
    {
            pack.setCommand("");
            pack.getArgs().clear();
            System.out.println("Вход в систему!");
            System.out.println("1. Авторизироваться");
            System.out.println("2. Зарегистророваться");
            System.out.println("3. Выйти");
            System.out.print("\nВведите выбор :");
            int choice;
            choice=Integer.parseInt(br.readLine());
            if(choice==1)
            {
                authorisation();
            }
            else if(choice==2) {
                register();
            }
            else
            {
                System.exit(1);
            }

        mainMenu();
    }

    private void register() throws IOException, ClassNotFoundException {
        System.out.println("Введите логин:");
        String login = br.readLine();
        System.out.println("Введите пароль:");
        String pass = br.readLine();
        System.out.println("Введите имя:");
        String name = br.readLine();
        System.out.println("Введите e-mail:");
        String email = br.readLine();
        pack.setCommand("REG");
        pack.getArgs().add(login);
        pack.getArgs().add(pass);
        pack.getArgs().add(name);
        pack.getArgs().add(email);
        oos.writeObject(pack);
        pack = (MyPackage)ois.readObject();
        if ("REG-YES".equals(pack.getCommand())) {
            client = pack.getUser();
            System.out.println(client);
            clientName = pack.getArgs().get(4);
        } else {
            System.out.println("Ой... не правильные логин или пароль!");
        }


    }

    private void authorisation() throws IOException, ClassNotFoundException {
        System.out.println("Введите логин:");
        String login = br.readLine();
        System.out.println("Введите пароль:");
        String pass = br.readLine();
        pack.setCommand("AUTHORISATION");
        pack.getArgs().add(login);
        pack.getArgs().add(pass);
        oos.writeObject(pack);
        pack = (MyPackage)ois.readObject();
        if ("AUTHORISATION-YES".equals(pack.getCommand())) {
            client = pack.getUser();
            System.out.println(client);
            clientName = pack.getArgs().get(2);
        } else {
            System.out.println("Ой... не правильные логин или пароль!");
        }

    }

    private void mainMenu() throws IOException {

        while (true) {
            System.out.println("Меню [" + clientName + "]");
            System.out.println("1 - Добавить задачу.");
            System.out.println("2 - Просмотреть назначеные мне задачи.");
            System.out.println("3 - Просмотреть все задачу.");
            System.out.println("4 - Изменить статус задачи.");
            System.out.println("0 - Выход.");

            int choice = Integer.parseInt(br.readLine());
            pack.setCommand("");
            pack.getArgs().clear();

            switch (choice) {
                case 1: {
                    addTask();
                    break;
                }
                case 2: {
               //     showMeExecTask();
                    break;
                }

                case 3: {
                //    showAllTask();
                    break;
                }

                case 4: {

                    break;
                }

                case 0: {
                    System.exit(0);
                }
            }
        }

    }

    private void addTask() throws IOException {
        System.out.println("Введите описание задачи");
        String   desc = br.readLine();
        TaskState state = TaskState.New;
        TaskPriority prority = getTaskPriority();
        System.out.println("Выбирите исполнителя(введите id ):");
        // здеся остновился !!!!!!!!!!!!!!!!!!
        showAllUsers();
        int id = Integer.parseInt(br.readLine());
        // User exec = userService.read(id);
        //System.out.println("Исполнитель: " + exec);
        System.out.println("Укажите запланированое время");
        //int pH = scanner.nextInt();

        //taskService.addNew(desc, state, prority, client, exec, new Date(), null, pH, 0);
    }

    private void showAllUsers() {

    }


    private TaskPriority getTaskPriority() throws IOException {
        System.out.println("Выберите приоритет задачи:");
        System.out.println("1 - Критический");
        System.out.println("2 - Высокий");
        System.out.println("3 - Средний");
        System.out.println("4 - Низкий");
        int choice = Integer.parseInt(br.readLine());
        TaskPriority prority = null;
        switch (choice) {
            case 1: {
                prority = TaskPriority.Critical;
                break;
            }
            case 2: {
                prority = TaskPriority.High;
                break;
            }
            case 3: {
                prority = TaskPriority.Medium;
                break;
            }
            case 4: {
                prority = TaskPriority.Low;
                break;
            }
            default:{
                getTaskPriority();
            }
        }
        return prority;
    }
}
