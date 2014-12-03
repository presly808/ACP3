package yaroslav.superChat.server;

import java.io.Serializable;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by babiy on 02.12.14.
 */

public class Message implements Serializable {

    private String login;
    private String message;
    private String[] users;
    private Date time;

    //Конструктор, которым будет пользоваться клиент
    public Message(String login, String message){
        this.login = login;
        this.message = message;
        this.time = java.util.Calendar.getInstance().getTime();
    }

    //Конструктор, которым будет пользоваться сервер
    public Message(String login, String message, String[] users){
        this.login = login;
        this.message = message;
        this.time = java.util.Calendar.getInstance().getTime();
        this.users = users;
    }

    public void setOnlineUsers(String[] users) {
        this.users = users;
    }

    public String getLogin() {
        return this.login;
    }

    public String getMessage() {
        return this.message;
    }

    public String[] getUsers() {
        return this.users;
    }

    public String getDate(){
        Time tm = new Time(this.time.getTime());
        return tm.toString();
    }

    @Override
    public String toString() {
        SimpleDateFormat ft = new SimpleDateFormat ("hh:mm:ss");
        return login + ":" +
                message + " at "
                + ft.format(time);
    }
}


