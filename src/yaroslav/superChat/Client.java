package yaroslav.superChat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    private ClienForm clienForm = new ClienForm();
    private static final Logger logger = Logger.getLogger("Client.java");

    public Client(String login, Socket socket) {

        this.socket = socket;
        this.login = login;

        clienForm.send.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                send(clienForm.textField.getText());
                clienForm.textField.setText("");
            }
        });
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
            logger.log(Level.SEVERE, "Error on get Stream", e);
        }
        logger.log(Level.INFO, "Client Started");

        msgOut = new Message(login, "User join to the chat(Auto-message)");
        try {
            oos.writeObject(msgOut);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Error on loggin", e);
        }
        logger.log(Level.INFO, "Loggin in!");

        Thread r = new Thread(new Reciver(ois));
        r.setDaemon(true);
        r.start();
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
                    logger.log(Level.SEVERE, "IOException on read message", e);
                } catch (ClassNotFoundException e) {
                    logger.log(Level.SEVERE, "ClassException on read message", e);
                }


            }
        }

        private void show(Object obj) {
            if (obj.getClass().equals(Message.class)) {
                msgIn = (Message) obj;
                clienForm.showMessage(msgIn.toString());
            } else {
                if (obj.getClass().equals(ChatHistory.class)) {
                    /*if (history != null) */{
                        history = (ChatHistory) obj;
                        System.out.println("Hisstory" + history.getHistory().size());


                        for (Message h : history.getHistory()) {
                            clienForm.showMessage(h.toString());
                        }
                    }
                } else if (obj.getClass().equals(Ping.class)) {
                    try {
                        oos.writeObject(new Ping());
                    } catch (IOException e) {
                        logger.log(Level.SEVERE, "ClassException on sending ping", e);
                    }
                }
            }
        }
    }
}


