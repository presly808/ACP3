package yaroslav.superChat.server;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by babiy on 02.12.14.
 */
public class ChatHistory implements Serializable {
    private List<Message> history;
    private static final Logger logger = Logger.getLogger("ChatHistory");


    public ChatHistory() {
        this.history = new ArrayList<Message>(Config.HISTORY_LENGTH);
    }

    public void addMessage(Message message){
        if (this.history.size() > Config.HISTORY_LENGTH){
            this.history.remove(0);
            logger.log(Level.INFO, "Delete message from history");
        }

        this.history.add(message);
        logger.log(Level.INFO, "Add message to history");
    }

    public List<Message> getHistory(){
        return this.history;
    }

    public void showAll () {
        if (history.size()>0)
        for (Message m : history) {
            System.out.println(m);
        }
        logger.log(Level.INFO, "No messages at history");
    }

}

