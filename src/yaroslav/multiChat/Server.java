package yaroslav.multiChat;

import javafx.concurrent.Worker;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

/**
 * Created by Администратор on 30.11.2014.
 */
public class Server {
    private ServerSocket ss; 
    int serverPort;
    LinkedList<ServerWorker> workers = new LinkedList<ServerWorker>();
    Thread serverThread;


    public Server(int port) {
        try {
            ss = new ServerSocket(port);
            serverPort = port;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        new Server(45000).run();
    }

    public  void run () {
        serverThread = Thread.currentThread();
        System.out.println("Server started ...");
        while (true) {

            try {
                Socket s = ss.accept();
                System.out.println("Connected" + s.getInetAddress());
                ServerWorker serverWorker = new ServerWorker(s);
                workers.add(serverWorker);
                Thread thread = new Thread(serverWorker);
                thread.setDaemon(true);
                thread.start();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }

    private class ServerWorker implements Runnable {
        private Socket s;
        // ObjectInputStream in;
        // ObjectOutputStream out;
        BufferedReader in;
        BufferedWriter out;
        String message;


        public ServerWorker(Socket s) throws IOException {
            this.s = s;
            // in = new ObjectInputStream(s.getInputStream());
            in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            // out = new ObjectOutputStream(s.getOutputStream());
            out = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        }

        @Override
        public void run() {
            System.out.println("Запустился воркер");

            while (true) {

                try {
                    message = in.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("prinyato " + message);
                for (ServerWorker w : workers) {
                    w.send(message);
                }
            }

        }

        public synchronized void send(String message) {
            try {
                out.write(message + "\n");
                out.flush();
                System.out.println("send");

            } catch (IOException e) {
                close();
            }

        }

        private void close() {
            workers.remove(this);
            if (!s.isClosed()) {
                try {
                    s.close();
                } catch (IOException ignored) {}
            }
        }
    }
}
