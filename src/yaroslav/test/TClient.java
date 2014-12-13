package yaroslav.test;

import java.io.*;
import java.net.Socket;

/**
 * Created by Администратор on 01.12.2014.
 */

public class TClient {
    public static void main(String[] args){

        try{
            Socket fromserver = new Socket("localhost", 3128);
            System.out.println("0");



        //   BufferedOutputStream bos = new BufferedOutputStream(fromserver.getOutputStream());
           ObjectOutputStream oos = new ObjectOutputStream(fromserver.getOutputStream());
           System.out.println("2");

        //    BufferedInputStream bis = new BufferedInputStream(fromserver.getInputStream());
            ObjectInputStream ois = new ObjectInputStream(fromserver.getInputStream());
            System.out.println("1");
         //  A obj = new A();
         //  oos.writeObject(obj);
         //  oos.flush();
         //  oos.close();
         //  fromserver.close();

        }catch(Exception e) {
            e.getStackTrace();
        }
    }
}