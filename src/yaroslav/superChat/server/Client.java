package yaroslav.superChat.server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Created by babiy on 02.12.14.
 */
public class Client {
    private Socket socket;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;

    public Client(Socket socket){
        this.socket = socket;
        System.out.println("rere");

    }

    public Client(Socket socket , ObjectOutputStream oos , ObjectInputStream ois ){
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

    public void run(){
        System.out.println("Ready");
    }
}


