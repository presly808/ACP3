package ua.artcode.week2.day2.sockets;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by admin on 23.11.2014.
 */
public class ClientStart {


    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("192.168.1.34" ,9898);
        Scanner sc = new Scanner(socket.getInputStream());

        while (sc.hasNextLine()){
            System.out.println(sc.nextLine());
        }

    }
}
