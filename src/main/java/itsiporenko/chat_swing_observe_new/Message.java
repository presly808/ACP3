package itsiporenko.chat_swing_observe_new;

import java.io.Serializable;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by User on 05.12.2014.
 */
public class Message implements Serializable {

    private String curr_user;
    private String message;
    private String[] users;
    private Date time;

   //client
    public Message(String curr_user, String message){
        this.curr_user = curr_user;
        this.message = message;
        this.time = java.util.Calendar.getInstance().getTime();
    }


  //server
   public Message(String curr_user, String message, String[] users){
        this.curr_user= curr_user;
        this.message = message;
        this.time = java.util.Calendar.getInstance().getTime();
        this.users = users;
    }

    public void setOnlineUsers(String[] users) {

        this.users = users;
    }

    public String getCurr_User() {
        return this.curr_user;
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
        return ft.format(time) + " от " + curr_user + ": \t" + message;

    }
}
