package ua.artcode.view;

import ua.artcode.dao.TaskDaoEntity;
import ua.artcode.dao.UserDaoEntity;
import ua.artcode.model.Task;
import ua.artcode.model.TaskPriority;
import ua.artcode.model.TaskState;
import ua.artcode.model.User;
import ua.artcode.service.ITaskService;
import ua.artcode.service.IUserService;
import ua.artcode.service.TaskServiceImpl;
import ua.artcode.service.UserServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Yaroslav on 23.12.2014.
 */
public class Main {
    private Scanner scanner = new Scanner(System.in);
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private User client = null;
    IUserService userService = new UserServiceImpl(new UserDaoEntity());
    ITaskService taskService = new TaskServiceImpl(new TaskDaoEntity());

    public Main(User client) {
        this.client = client;
    }

    public User MainMenu(){
        System.out.println("1 - Добавить задачу.");
        System.out.println("2 - Просмотреть назначеные мне задачи.");
        System.out.println("3 - Просмотреть все задачу.");
        System.out.println("4 - Изменить статус задачи.");
        System.out.println("0 - Выход.");


        int choice = scanner.nextInt();

        switch (choice) {
            case 1: {
                addTask();
                break;
            }
            case 2: {
                showMeExecTask();
                break;
            }

            case 3: {
                showAllTask();
                break;
            }

            case 4: {

                break;
            }

            case 0: {
                System.exit(0);
            }
        }
        return client;
    }

    private void showAllTask() {
        taskService.showAllTasks();
    }

    private void addTask() {


        System.out.println("Введите описание задачи");

        String desc = null;
        try {
            desc = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        TaskState state = TaskState.New;

        TaskPriority prority = getTaskPriority();

        System.out.println("Выбирите исполнителя(введите id ):");
        userService.showAllUsers();
        int id = scanner.nextInt();
        User exec = userService.read(id);
        System.out.println("Исполнитель: " + exec);
        System.out.println("Укажите запланированое время");
        int pH = scanner.nextInt();

        taskService.addNew(desc, state, prority, client, exec, new Date(), null, pH, 0);
        }

    

    private void showMeExecTask () {
        client = userService.read(client.getId());
        List<Task> myTasks = client.getMyTasks();
        for (Task t : myTasks) {
            System.out.println(t);
        }
    }

    private TaskPriority getTaskPriority() {
        System.out.println("Выберите приоритет задачи:");
        System.out.println("1 - Критический");
        System.out.println("2 - Высокий");
        System.out.println("3 - Средний");
        System.out.println("4 - Низкий");
        int choice = scanner.nextInt();
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

    private TaskState getTaskState() {
        System.out.println("Выберите статус задачи:");
        System.out.println("1 - Критический");
        System.out.println("2 - Высокий");
        System.out.println("3 - Средний");
        System.out.println("4 - Низкий");
        int choice = scanner.nextInt();
        TaskState state = null;
        switch (choice) {
            case 1: {
                state = TaskState.New;
                break;
            }
            case 2: {
                state = TaskState.Pressed;
                break;
            }
            case 3: {
                state = TaskState.Close;
                break;
            }
            case 4: {
                state = TaskState.Reopening;
                break;
            }
            default:{
                getTaskState();
            }
        }
        return state;
    }
    
    
    
}
