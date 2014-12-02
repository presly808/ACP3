package yaroslav.superChat.server;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by babiy on 02.12.14.
 */
public class TestClient {
    public static void main(String[] args) {

        try {
            Client c = new Client("aa", new Socket("127.0.0.1", 5001));
            c.run();
        } catch (IOException e) {
            e.printStackTrace();
        }





    }
}
