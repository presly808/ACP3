package itsiporenko.chat_swing_observe_new;

/**
 * Created by User on 03.12.2014.
 */

import javax.swing.*;

//Class to precise who is connected : Client or Server
public class ClientServer {


    public static void main(String [] args){

        Object[] selectionValues = { "Server","Client"};
        String initialSection = "Server";

        Object selection = JOptionPane.showInputDialog(null, "Login as : ", "MyChatApp", JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSection);
        if(selection.equals("Server")){
            String[] arguments = new String[] {};
            new MultiThreadChatServerSync().main(arguments);
        }else if(selection.equals("Client")){
            String IPServer = JOptionPane.showInputDialog("Enter the Server ip adress");
            String[] arguments = new String[] {IPServer};
            new ChatClient().main(arguments);
        }

    }

}