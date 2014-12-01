package yaroslav.multiChat;

import com.sun.xml.internal.txw2.output.IndentingXMLStreamWriter;

import java.io.*;
import java.net.Socket;
import java.util.Date;

/**
 * Created by Администратор on 30.11.2014.
 */
public class Client {
    String name = "";
    final Socket s;
    final ObjectInputStream inputStream;
    final ObjectOutputStream outputStream;
    final BufferedReader userInput; // буферизированный читатель пользовательского ввода с консоли

    public Client(String name, String host, int port) throws IOException {
        s = new Socket(host, port);
        BufferedOutputStream bos = new BufferedOutputStream(s.getOutputStream());
        outputStream = new ObjectOutputStream(bos);
        BufferedInputStream bis = new BufferedInputStream(s.getInputStream());
        inputStream = new ObjectInputStream(bis);
        userInput = new BufferedReader(new InputStreamReader(System.in));
        this.name = name;
        System.out.println("OK");
        new Thread(new Reciver()).start();
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        System.out.println("Введите имя:");
        try {
            String n = new BufferedReader(new InputStreamReader(System.in)).readLine();
            new Client(n, "127.0.0.1", 45000).run();
        } catch (IOException e) {
            e.getStackTrace();
        }
    }


    public void run() {
        System.out.println("Connected");


        while (!s.isClosed()) {
            String line = null;
            try {
                System.out.println("Введите сообщение:");
                line = userInput.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Message msg = new Message();
            msg.setDate(new Date());
            msg.setFrom(name);
            msg.setMsg(line);


            try {
                outputStream.writeObject(msg);
                outputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }

    private  class Reciver implements Runnable {
        @Override
        public void run() {
            while (!s.isClosed()){
                try {
                    Message msg = (Message) inputStream.readObject();
                    System.out.println(msg);
                } catch (IOException e) {

                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
