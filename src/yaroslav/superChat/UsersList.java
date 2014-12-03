package yaroslav.superChat;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Администратор on 02.12.2014.
 */
public class UsersList {

    private Map<String, User> onlineUsers = new HashMap<String, User>();
    private static final Logger logger = Logger.getLogger("UsersList");

    public void addUser(String login, Socket socket, ObjectOutputStream oos, ObjectInputStream ois) {
        logger.log(Level.INFO,login +" connected" );

        if (!this.onlineUsers.containsKey(login)) {
            this.onlineUsers.put(login , new User(socket, oos, ois));
        } else {
            int i = 1;
            while(this.onlineUsers.containsKey(login)) {
                login = login + i;
                i++;
            }
            this.onlineUsers.put(login , new User(socket, oos, ois));
        }
    }

    public void deleteUser(String login) {
        this.onlineUsers.remove(login);
        logger.log(Level.INFO,login +" deleted" );
    }

    public String[] getUsers() {
        return this.onlineUsers.keySet().toArray(new String[0]);
    }

    public ArrayList<User> getClientsList() {
        ArrayList<User> clientsList = new ArrayList<User>(this.onlineUsers.entrySet().size());

        String s = "";
        for(Map.Entry<String, User> m : this.onlineUsers.entrySet()){
            clientsList.add(m.getValue());
            System.out.println(m.getKey());
            s = s + m.getKey();
        }

        return clientsList;
    }

}


