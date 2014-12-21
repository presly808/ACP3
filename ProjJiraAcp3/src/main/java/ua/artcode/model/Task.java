package ua.artcode.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

/**
 * Created by admin on 07.12.2014.
 */

@Entity
@Table(name = "TASKS")
public class Task {
    @Id
    private int id;
    private String description;
    private int state_id;
    private int priority_id;
    private int author_id;
    private int executor_id;

    private int project_id;
    private Date createDate = new Date();
    private Date endDate = null;
    private Date planingHours;
    private Date executingHours;



    public Task() {
    }
    public Task(int id, String description, int state_id, int priority_id, int author_id, int executor_id,
                int project_id, Date createDate, Date endDate, Date planingHours, Date executingHours) {
        this.id = id;
        this.description = description;
        this.state_id = state_id;
        this.priority_id = priority_id;
        this.author_id = author_id;
        this.executor_id = executor_id;

        this.project_id = project_id;
        this.createDate = createDate;
        this.endDate = endDate;
        this.planingHours = planingHours;
        this.executingHours = executingHours;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getState_id() {
        return state_id;
    }

    public void setState_id(int state_id) {
        this.state_id = state_id;
    }

    public int getPriority_id() {
        return priority_id;
    }

    public void setPriority_id(int priority_id) {
        this.priority_id = priority_id;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public int getExecutor_id() {
        return executor_id;
    }

    public void setExecutor_id(int executor_id) {
        this.executor_id = executor_id;
    }



    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

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

    public Date getPlaningHours() {
        return planingHours;
    }

    public void setPlaningHours(Date planingHours) {
        this.planingHours = planingHours;
    }

    public Date getExecutingHours() {
        return executingHours;
    }

    public void setExecutingHours(Date executingHours) {
        this.executingHours = executingHours;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", createDate=" + createDate +
                ", endDate=" + endDate +
                ", planingHours=" + planingHours +
                ", executingHours=" + executingHours +
                '}';
    }
}
