package ua.artcode.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Yaroslav on 14.12.2014.
 */
@Entity

public class Comment {
    @Id
    @GeneratedValue
    private int id;
    private String message;
    @OneToOne
    private User author;
    private Date createDate;
    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "task_id", referencedColumnName = "id")
    private Task task;

    public Comment() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    @Override
    public String toString() {
        return  author.getName()+": \t" + message + "\t ["+createDate+"].";

    }
}
