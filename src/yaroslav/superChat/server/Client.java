package yaroslav.superChat.server;

import java.io.*;
import java.net.Socket;

/**
 * Created by babiy on 02.12.14.
 */
public class Client {
    private Socket socket;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;
    private Message msgOut;
    private Message msgIn;
    private ChatHistory history;
    private String login;


    public Client(String login, Socket socket ) {
        this.socket = socket;
        this.login = login;


    }

    public Client(Socket socket, ObjectOutputStream oos, ObjectInputStream ois) {
        this.socket = socket;
        this.oos = oos;
        this.ois = ois;
    }

    public Socket getSocket() {
        return this.socket;
    }

    public ObjectOutputStream getThisObjectOutputStream() {
        return this.oos;
    }

    public ObjectInputStream getThisObjectInputStream() {
        return this.ois;
    }

    public void setThisObjectOutputStream(ObjectOutputStream oos) {
        this.oos = oos;
    }

    public void setThisObjectInputStream(ObjectInputStream ois) {
        this.ois = ois;
    }

    public void run() {
        System.out.println("Do oos and ois");
        try {
            oos = new ObjectOutputStream(this.socket.getOutputStream());
            ois = new ObjectInputStream(this.socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Ready");

        msgOut = new Message(login, "User join to the chat(Auto-message)");
        try {
            oos.writeObject(msgOut);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("send msg");

        Thread r = new Thread(new Reciver(ois));
        r.setDaemon(true);
        r.start();

        System.out.println("Введите сообщение:");
        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String line = null;
            try {
                line = userInput.readLine();
                send(line);
            } catch (IOException e) {
                e.printStackTrace();
            }


        }

    }

    private void send(String s) {
        msgOut = new Message(login, s);
        try {
            oos.writeObject(msgOut);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    class Reciver extends  Thread{
        private ObjectInputStream in;
        public Reciver (ObjectInputStream in) {
            this.in = in;
        }

        @Override
        public void run() {
            while (true){

                try {
                    Object obj =  in.readObject();
                    show(obj);

                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }


            }
        }

        private void show (Object obj){
            if (obj.getClass().equals(Message.class)) {
                msgIn = (Message) obj;
                System.out.println(msgIn);
            }
        }
    }
}


