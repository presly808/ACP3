package yaroslav.superChat;

import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Created by Администратор on 03.12.2014.
 */
public class User {
    private Socket socket;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;
    public User(Socket socket, ObjectOutputStream oos, ObjectInputStream ois) {
        this.socket = socket;
        this.oos = oos;
        this.ois = ois;
    }

    public Socket getSocket() {
        return socket;
    }


    public ObjectOutput getThisObjectOutputStream() {
        return oos;
    }
}
