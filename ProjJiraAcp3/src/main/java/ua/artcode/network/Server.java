package ua.artcode.network;

import ua.artcode.dao.TaskDaoEntity;
import ua.artcode.dao.UserDaoEntity;
import ua.artcode.model.User;
import ua.artcode.service.*;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Yaroslav on 24.12.2014.
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket soc = new ServerSocket(5217);
        System.out.println("Server Started on Port Number 5217");
        while (true) {
            System.out.println("Waiting for Connection ...");
            Transfer t = new Transfer(soc.accept());
        }


    }
}
    class Transfer extends Thread {
        Socket clientSocket;
        ObjectInputStream ois;
        ObjectOutputStream oos;

        IUserService userService = new UserServiceImpl(new UserDaoEntity());
        ITaskService taskService = new TaskServiceImpl(new TaskDaoEntity());
        RegService regService = new RegService();

        public  Transfer(Socket socket){
            clientSocket = socket;
            try {
                oos = new ObjectOutputStream(socket.getOutputStream());
                ois = new ObjectInputStream(socket.getInputStream());
                System.out.println("Client Connected ...");
                start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void run()
        {
            while(true)
            {
                try
                {
                    System.out.println("Waiting for Command ...");
                    MyPackage pack = (MyPackage)ois.readObject();
                    if ("AUTHORISATION".equals(pack.getCommand())) {
                        authorisation(pack);
                    } else if ("REG".equals(pack.getCommand())){
                        reg(pack);
                    }
                }
                catch(Exception ex)
                {
                }
            }
        }

        private void reg(MyPackage pack) {
            User newUser = regService.registerNewUser(pack.getArgs().get(0), pack.getArgs().get(1), pack.getArgs().get(2), pack.getArgs().get(3));
            if (newUser != null) {
                pack.setUser(newUser.getId());
                pack.setCommand("REG-YES");
                pack.getArgs().add(newUser.getName());
            } else{
                pack.setCommand("REG-YES");
            }
            try {
                oos.writeObject(pack);
                oos.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        private void authorisation(MyPackage pack) {
            User newUser = regService.autofication(pack.getArgs().get(0), pack.getArgs().get(1));
            if (newUser!=null) {
                pack.setUser(newUser.getId());
                pack.setCommand("AUTHORISATION-YES");
                pack.getArgs().add(newUser.getName());
            } else {
                pack.setCommand("AUTHORISATION-NO");
            }
            try {
                oos.writeObject(pack);
                oos.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

