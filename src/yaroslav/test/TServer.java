package yaroslav.test;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TServer{
    public static void main(String[] args)throws IOException {
        System.out.println("Welcome to Server side");

        ServerSocket servers = null;
        Socket fromclient = null;

        servers = new ServerSocket(3128);

        System.out.print("Waiting for a client...");
        fromclient= servers.accept();
        System.out.println("\nClient connected!");

        BufferedInputStream bis = new BufferedInputStream(fromclient.getInputStream());
        ObjectInputStream ois = new ObjectInputStream(bis);
        try{

            A obj2 = (A) ois.readObject();
            System.out.println("value: "+obj2.value);
        }catch(Exception e){}

        bis.close();
        ois.close();
        servers.close();
        fromclient.close();

    }
}
