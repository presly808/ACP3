//package mountin.chat;
//
//
//import sun.rmi.runtime.Log;
//
//import java.net.*;
//import java.io.*;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
//public class Server {
//    private final Logger logger = Logger.getLogger("Server");
//    public static void main(String[] ar) {
//        int port = 6666;
//        try {
//            ServerSocket ss = new ServerSocket(port);
//            System.out.println("Waiting for a client...");
//
//            Socket socket = ss.accept();
//            System.out.println("Got a client :) ... Finally, someone saw me through all the cover!");
//            System.out.println();
//
//
//            InputStream sin = socket.getInputStream();
//            OutputStream sout = socket.getOutputStream();
//
//
//            DataInputStream in = new DataInputStream(sin);
//            DataOutputStream out = new DataOutputStream(sout);
//
//            String line = null;
//            while (true) {
//
//                line = in.readUTF();
//                System.out.println("The dumb client just sent me this line : " + line);
//                System.out.println("I'm sending it back...");
//                out.writeUTF(line);
//                out.flush();
//
//                ClientData cd = new ClientData(in) ;
//
//
//                Thread thread = new Thread(cd);
//                thread.setDaemon(true);
//                thread.start();
//
//                System.out.println("Waiting for the next line...");
//                System.out.println();
//            }
//        } catch (Exception x) {
//            x.printStackTrace();
//        }
//    }
//
//    public  class ClientData implements Runnable {
//
//        private ObjectInputStream in;
//        private message msg;
//
//        public ClientData(DataInputStream inS) throws IOException {
//            logger.log(Level.INFO, "Init ClientData");
//            BufferedInputStream bis = new BufferedInputStream(inS.getInputStream());
//            logger.log(Level.INFO, "bis getted");
//
//        }
//        @Override
//        public void run() {
//            System.out.println("Запустился ClientData на сервере");
//            while (true) {
//
//                try {
//                    msg = (message)in.readObject();
//                } catch (IOException e) {
//                    //close();
//                } catch (ClassNotFoundException e) {
//                    e.printStackTrace();
//                }
//                System.out.println("recive: " + msg.getMessage());
////                for (ClientData w : ClientData) {
////                    w.send(msg);
////                }
//            }
//
//        }
//    }
//}