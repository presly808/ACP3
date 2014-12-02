package yaroslav.superChat.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;

/**
 * Created by babiy on 02.12.14.
 */
public class Server {

    private static UsersList list = new UsersList();
    private static ChatHistory chatHistory = new ChatHistory();

    public  void start () {
        try {
            System.out.println("Создаем слушатель");//Создаем слушатель
            ServerSocket socketListener = new ServerSocket(Config.PORT);

            while (true) {
                Socket client = socketListener.accept();
                System.out.println("Создаем новый поток, которому передаем сокет");
                new ClientThread(client); //Создаем новый поток, которому передаем сокет

            }
        } catch (SocketException e) {
            System.err.println("Socket exception");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("I/O exception");
            e.printStackTrace();
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
        private Message c;
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
                final ObjectInputStream inputStream   = new ObjectInputStream(this.socket.getInputStream());
                final ObjectOutputStream outputStream = new ObjectOutputStream(this.socket.getOutputStream());

                this.c = (Message) inputStream.readObject();
                this.login = this.c.getLogin();


                if (! this.c.getMessage().equals(Config.HELLO_MESSAGE)) {
                    System.out.println("[" + this.c.getLogin() + "]: " + this.c.getMessage());
                    getChatHistory().addMessage(this.c);
                } else {
                    outputStream.writeObject(getChatHistory());
                    this.broadcast(getUserList().getClientsList(), new Message("Server-Bot", "The user " + login + " has been connect"));
                }
                getUserList().addUser(login, socket, outputStream, inputStream);

                this.c.setOnlineUsers(getUserList().getUsers());
                this.broadcast(getUserList().getClientsList(), this.c);




                outputStream.writeObject(new Ping());
                this.outPacks++;
                System.out.println(outPacks + " out");

                while (true) {
                    if(this.flag) {
                        this.flag = false;
                        break;
                    }
                    this.c = (Message) inputStream.readObject();

                    if (this.c instanceof Ping) {
                        this.inPacks++;
                        System.out.println(this.inPacks + " in");

                    } else if (! c.getMessage().equals(Config.HELLO_MESSAGE)) {
                        System.out.println("[" + login + "]: " + c.getMessage());
                        getChatHistory().addMessage(this.c);

                    } else {
                        outputStream.writeObject(getChatHistory());
                        this.broadcast(getUserList().getClientsList(), new Message("Server-Bot", "The user " + login + " has been connect"));
                    }

                    this.c.setOnlineUsers(getUserList().getUsers());

                    if (! (c instanceof Ping) && ! c.getMessage().equals("User join to the chat(Auto-message)")) {
                        System.out.println("Send broadcast Message: " + c.getMessage() + " ");
                        this.broadcast(getUserList().getClientsList(), this.c);
                    }
                }

            } catch (SocketException e) {
                System.out.println(login + " disconnected!");
                getUserList().deleteUser(login);
                broadcast(getUserList().getClientsList(), new Message("Server-Bot", "The user " + login + " has been disconnect", getUserList().getUsers()));

            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }


        private void broadcast(ArrayList<Client> clientsArrayList, Message message) {
            try {
                for (Client client : clientsArrayList) {
                    client.getThisObjectOutputStream().writeObject(message);
                }
            } catch (SocketException e) {
                System.out.println("in broadcast: " + login + " disconnected!");
                getUserList().deleteUser(login);
                this.broadcast(getUserList().getClientsList(), new Message("Server-Bot", "The user " + login + " has been disconnected", getUserList().getUsers()));


            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    }

}


