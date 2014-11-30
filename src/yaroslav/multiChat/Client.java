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
    final BufferedReader inputStream; // буферизированный читатель с сервера
    //final ObjectInputStream inputStream; // буферизированный читатель с сервера
    final BufferedWriter outputStream; // буферизированный писатель на сервер
    //final ObjectOutputStream outputStream; // буферизированный писатель на сервер
    final BufferedReader userInput; // буферизированный читатель пользовательского ввода с консоли

    public Client(String name, String host, int port) throws IOException {
        s = new Socket(host, port);
        // inputStream = new ObjectInputStream(s.getInputStream());
        inputStream = new BufferedReader(new InputStreamReader(s.getInputStream()));
        outputStream = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        //outputStream = new ObjectOutputStream(s.getOutputStream());
        userInput = new BufferedReader(new InputStreamReader(System.in));
        this.name = name;
        new Thread(new Reciver()).start();
    }

    public static void main(String[] args) {
        try {
            new Client("user3", "localhost", 45000).run();
        } catch (IOException e) {
            System.out.println("Облом");
        }
    }


    public void run() {
        System.out.println("Connected");
        while (!s.isClosed()) {
            String message = null;
            try {
                System.out.println("Введите сообщение:");
                message = userInput.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }


            try {
                outputStream.write(name +" "+  new Date()+ " " + message + "\n");
                outputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }

    private  class Reciver implements Runnable {
        @Override
        public void run() {
            System.out.println("Start Reciver");
            while (true)
                try {
                System.out.println(inputStream.readLine());
                    System.out.println("fuck");
            } catch (IOException e) {
                    System.out.println("fuck");
            }

        }
    }
}
