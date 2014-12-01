package yaroslav.test;

import java.io.BufferedOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;

/**
 * Created by Администратор on 01.12.2014.
 */

public class TClient {
    public static void main(String[] args){

        try{
            Socket fromserver = new Socket("localhost", 3128);
            BufferedOutputStream bos = new BufferedOutputStream(fromserver.getOutputStream());
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            A obj = new A();
            oos.writeObject(obj);
            oos.flush();
            oos.close();
            fromserver.close();

        }catch(Exception e){}
    }
}