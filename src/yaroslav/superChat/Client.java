package yaroslav.superChat;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;
import java.util.List;

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
    private ClienForm cf = new ClienForm();





    public Client(String login, Socket socket) {

        this.socket = socket;
        this.login = login;

        cf.send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                send(cf.textField.getText());

                cf.textField.setText("");
            }
        });
    }

    public Client(Socket socket, ObjectOutputStream oos, ObjectInputStream ois) {
        this.socket = socket;
        this.oos = oos;
        this.ois = ois;
    }



    public Socket getSocket() {
        return this.socket;
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

//        System.out.println("Введите сообщение:");
//        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
//        while (true) {

//            String line = null;
//            line = sendMessageForm();
//            send(line);
//
//
//        }

    }

    public void send(String s) {
        msgOut = new Message(login, s);
        try {
            oos.writeObject(msgOut);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    class Reciver extends Thread {
        private ObjectInputStream in;

        public Reciver(ObjectInputStream in) {
            this.in = in;
        }

        @Override
        public void run() {
            while (true) {

                try {
                    Object obj = in.readObject();
                    show(obj);

                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }


            }
        }

        private void show(Object obj) {
            if (obj.getClass().equals(Message.class)) {
                msgIn = (Message) obj;
                cf.showMessage(msgIn.toString());
            } else {
                if (obj.getClass().equals(ChatHistory.class)) {
                    if (history != null) {
                        history = (ChatHistory) obj;
                        for (Message h : history.getHistory()) {
                            cf.showMessage(h.toString());
                        }
                    }
                } else if (obj.getClass().equals(Ping.class)) {
                    try {
                        oos.writeObject(new Ping());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}


