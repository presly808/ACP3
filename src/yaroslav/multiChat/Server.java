package yaroslav.multiChat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Администратор on 30.11.2014.
 */
public class Server {
    private ServerSocket serverSocket;
    private int serverPort;
    private LinkedList<ClientProcessor> clientProcessors = new LinkedList<ClientProcessor>();
    private final Logger logger = Logger.getLogger("yaroslav.multiChat.Server");


    public Server(int port) {
        serverPort = port;
        logger.log(Level.INFO, "Server started ...");
    }

    public static void main(String[] args) throws IOException {
        new Server(45000).run();
    }

    public void run() {


        while (true) {

            try {
                serverSocket = new ServerSocket(serverPort);
                logger.log(Level.INFO, "Waiting for connected ");
                Socket fromClient = serverSocket.accept();

                logger.log(Level.INFO, "Connected ");
                ClientProcessor clientProcessor = new ClientProcessor(fromClient);

                clientProcessors.add(clientProcessor);
                Thread thread = new Thread(clientProcessor);
                thread.setDaemon(true);
                thread.start();
            } catch (IOException e) {
                e.getStackTrace();
            }


        }
    }

    public void stop() {
        for (ClientProcessor w : clientProcessors) {
            w.close();
        }
        if (!serverSocket.isClosed()) {
            try {
                serverSocket.close();
            } catch (IOException e) {
                System.out.println("Opss...");
            }
        }
    }


    private class ClientProcessor implements Runnable {
        private Socket procesorSocket;
        private ObjectInputStream in;
        private ObjectOutputStream out;
        private Message msg;


        public ClientProcessor(Socket socket) {
            logger.log(Level.INFO, "Init ClientProcessor");
            procesorSocket = socket;
            try {
                BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
                out = new ObjectOutputStream(bos);
                logger.log(Level.INFO, "out getted");
                BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
                logger.log(Level.INFO, "bis getted");
                in = new ObjectInputStream(bis);
                logger.log(Level.INFO, "in getted");

            } catch (IOException e) {
                e.printStackTrace();
            }


        }

        @Override
        public void run() {
            System.out.println("Запустился воркер");

            while (!procesorSocket.isClosed()) {

                try {
                    msg = (Message) in.readObject();
                } catch (IOException e) {
                    close();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                System.out.println("recive: " + msg);
                for (ClientProcessor w : clientProcessors) {
                    w.send(msg);
                }
            }

        }

        private synchronized void send(Message message) {
            try {
                out.writeObject(message);
                out.flush();
                System.out.println("send");

            } catch (IOException e) {
                close();
            }

        }

        private void close() {
            clientProcessors.remove(this);
            if (!procesorSocket.isClosed()) {
                try {
                    procesorSocket.close();
                } catch (IOException ignored) {
                }
            }
        }
    }
}
