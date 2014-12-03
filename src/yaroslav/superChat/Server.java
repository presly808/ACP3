package yaroslav.superChat;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by babiy on 02.12.14.
 */
public class Server {

    private static UsersList list = new UsersList();
    private static ChatHistory chatHistory = new ChatHistory();
    public static final Logger logger = Logger.getLogger("Server.java");


    public  void start () {
        try {
            logger.log(Level.INFO, "Server started..");

            ServerSocket socketListener = new ServerSocket(Config.PORT);

            while (true) {
                Socket client = socketListener.accept();
                new ClientThread(client);

            }
        } catch (SocketException e) {
            logger.log(Level.SEVERE, "Socket exception on start server", e);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "IOException on start server", e);
        }
    }


    public synchronized static UsersList getUserList() {
        return list;
    }

    public synchronized static ChatHistory getChatHistory() {
        return chatHistory;
    }

    class ClientThread extends Thread {


        private Socket socket;
        private Message message;
        private String login;
        private int inPacks = 0;
        private int outPacks = 0;
        private boolean flag = false;


        public ClientThread(Socket socket) {
            this.socket = socket;
            this.start();
        }

        public void run() {
            try {
                final ObjectInputStream inputStream   = new ObjectInputStream(socket.getInputStream());
                final ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());

                message = (Message) inputStream.readObject();
                login = message.getLogin();
                logger.log(Level.INFO, "Started ClientThread for " + login);


                if (! message.getMessage().equals(Config.HELLO_MESSAGE)) {
 //                   System.out.println("[" + message.getLogin() + "]: " + message.getMessage());
                    getChatHistory().addMessage(message);
                } else {
                    outputStream.writeObject(getChatHistory());
                    broadcast(getUserList().getClientsList(), new Message("Server-Bot", "The user " + login + " has been connect"));
                }
                getUserList().addUser(login, socket, outputStream, inputStream);

                message.setOnlineUsers(getUserList().getUsers());
                broadcast(getUserList().getClientsList(), message);

                outputStream.writeObject(new Ping()); // Надо сделать проверку что клиент еще жив! Отправл = Принятым
                outPacks++;
                System.out.println(outPacks + " out");

                while (true) {
                    if(flag) {
                        flag = false;
                        break;
                    }
                    message = (Message) inputStream.readObject();

                    if (message instanceof Ping) {
                        inPacks++; // Надо сделать проверку что клиент еще жив! Отправл = Принятым
                        System.out.println(inPacks + " in");

                    } else if (! message.getMessage().equals(Config.HELLO_MESSAGE)) {
                        logger.log(Level.INFO, "[" + login + "]: " + message.getMessage());
                        getChatHistory().addMessage(message);

                    } else {
                        outputStream.writeObject(getChatHistory());
                        broadcast(getUserList().getClientsList(), new Message("Server-Bot", "The user " + login + " has been connect"));
                    }

                    message.setOnlineUsers(getUserList().getUsers());

                    if (! (message instanceof Ping) && ! message.getMessage().equals("User join to the chat(Auto-message)")) {
                        logger.log(Level.INFO, "[" + login + "]: " + message.getMessage());
                        broadcast(getUserList().getClientsList(), message);
                    }
                }

            } catch (SocketException e) {
                logger.log(Level.INFO, login + " disconnected!");
                getUserList().deleteUser(login);
                broadcast(getUserList().getClientsList(), new Message("Server-Bot", "The user " + login + " has been disconnect", getUserList().getUsers()));

            } catch (IOException e) {
                logger.log(Level.SEVERE, "IOException then run ClientThread", e);
            } catch (ClassNotFoundException e) {
                logger.log(Level.SEVERE, "ClassNotFoundException then run ClientThread", e);
            }
        }


        private void broadcast(ArrayList<User> clientsArrayList, Message message) {
            try {
                for (User user : clientsArrayList) {
                    user.getThisObjectOutputStream().writeObject(message);
                }
            } catch (SocketException e) {
                logger.log(Level.SEVERE, "in broadcast: " + login + " disconnected!", e);
                getUserList().deleteUser(login);
                broadcast(getUserList().getClientsList(), new Message("Server-Bot", "The user " + login + " has been disconnected", getUserList().getUsers()));


            } catch (IOException e) {
                logger.log(Level.SEVERE, "IOException broadcast", e);
            }
        }



    }

}


