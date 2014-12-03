package yaroslav.superChat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by babiy on 02.12.14.
 */
public class TestClient {
    public static void main(String[] args) {
        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите логин:");
        try {
            Client client = new Client(userInput.readLine(), new Socket("127.0.0.1", 5001));
            client.run();
        } catch (IOException e) {
            e.printStackTrace();
        }







    }
}
