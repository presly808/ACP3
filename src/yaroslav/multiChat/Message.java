package yaroslav.multiChat;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Администратор on 30.11.2014.
 */
public class Message implements Serializable {
    private String msg;
    private Date date;
    private String from;

    public Message() {
    }

    public Message(String msg, Date date, String from) {
        this.msg = msg;
        this.date = date;
        this.from = from;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }



    @Override
    public String toString() {
        return date + "   " + from + " пишет: " + msg;
    }
}
