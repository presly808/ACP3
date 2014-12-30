package ua.artcode.model;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by admin on 07.12.2014.
 */

@Entity
@Table(name = "TASKS")
public class Task {
    @Id
    @GeneratedValue
    private int id;

    private String description;

    @Enumerated(EnumType.ORDINAL)
    private TaskState state;

    @Enumerated(EnumType.ORDINAL)
    private TaskPriority priority;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private User author;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "executor_id", referencedColumnName = "id")
    private User executor;

   // @ManyToOne(cascade = CascadeType.ALL)
   // @JoinColumn(name = "project_id")
   // private Project project;

    @ManyToMany(mappedBy="visitTasks")
    List<User> visitors = new ArrayList<User>();

    private Date createDate = new Date();

    private Date endDate = null;

    private int planingHours;

    private int executingHours;


    public Task() {
    }

    public Task(String description, TaskState state, TaskPriority priority, User author, User executor,
                Date createDate, Date endDate, int planingHours, int executingHours) {
        this.description = description;
        this.state = state;
        this.priority = priority;
        this.author = author;
        this.executor = executor;
        this.createDate = createDate;
        this.endDate = endDate;
        this.planingHours = planingHours;
        this.executingHours = executingHours;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskState getState() {
        return state;
    }

    public void setState(TaskState state) {
        this.state = state;
    }

    public TaskPriority getPriority() {
        return priority;
    }

    public void setPriority(TaskPriority priority) {
        this.priority = priority;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public User getExecutor() {
        return executor;
    }

    public void setExecutor(User executor) {
        this.executor = executor;
    }

/*    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }*/

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getPlaningHours() {
        return planingHours;
    }

    public void setPlaningHours(int planingHours) {
        this.planingHours = planingHours;
    }

    public int getExecutingHours() {
        return executingHours;
    }

    public void setExecutingHours(int executingHours) {
        this.executingHours = executingHours;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", state=" + state +
                ", priority=" + priority +
                ", author=" + author +
                ", executor=" + executor +
                ", visitors=" + visitors +
                ", createDate=" + createDate +
                ", endDate=" + endDate +
                ", planingHours=" + planingHours +
                ", executingHours=" + executingHours +
                '}';
    }
}
