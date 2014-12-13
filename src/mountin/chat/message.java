package mountin.chat;

import java.io.Serializable;
import java.util.Date;

public class message implements Serializable{

    private String msg;
    public Date date;
    public String from;


    public message(String msg, Date date, String from) {
        this.msg = msg;
        this.date = date;
        this.from = from;
    }
    public synchronized String  getMessage(){

        return this.msg;
    }
    public synchronized String  setMessage(String msg){

        return this.msg = msg;
    }

    @Override
    public String toString() {
        return date + "   " + from + " пишет: " + msg;
    }
}