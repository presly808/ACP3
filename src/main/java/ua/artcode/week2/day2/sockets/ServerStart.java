package ua.artcode.week2.day2.sockets;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class ServerStart {


    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(9999);
        while(true){
            Socket socket = ss.accept();
            Date date = new Date();
            System.out.println("Client " + socket.toString() + " " + date);
            String message = String.format("Hi, im server! My ip %s, connection date %tc",
                    socket.getLocalAddress().getHostAddress(), date);
            PrintWriter pw = new PrintWriter(socket.getOutputStream());
            pw.println(message);
            pw.flush();
            pw.close();
        }
    }

}
