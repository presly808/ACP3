package yaroslav.superChat.server;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by babiy on 02.12.14.
 */
public class ChatHistory implements Serializable {
    private List<Message> history;

    public ChatHistory() {
        this.history = new ArrayList<Message>(50);
    }

    public void addMessage(Message message){
        if (this.history.size() > 50){
            this.history.remove(0);
        }

        this.history.add(message);
    }

    public List<Message> getHistory(){
        return this.history;
    }

}

