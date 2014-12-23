package ua.artcode.model;

import com.sun.javafx.beans.IDProperty;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 07.12.2014.
 */
@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue

    private int id;

    private String name;

    private String email;

    @OneToMany(mappedBy="executor")
    private List<Task> myTasks = new ArrayList<>();

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="TASK_VISITORS",
            joinColumns={@JoinColumn(name="TASK_ID")},
            inverseJoinColumns={@JoinColumn(name="USER_ID")})
    private List<Task> visitTasks = new ArrayList<>( );

    @OneToMany(mappedBy="author")
    private List<Task> createdTasks = new ArrayList<>();


    public User() {
    }

    public User(String name, String email) {
        this.name = name;
        this.email = email;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Task> getMyTasks() {
        return myTasks;
    }

    public void setMyTasks(List<Task> myTasks) {
        this.myTasks = myTasks;
    }

    public List<Task> getVisitTasks() {
        return visitTasks;
    }

    public void setVisitTasks(List<Task> visitTasks) {
        this.visitTasks = visitTasks;
    }

    public List<Task> getCreatedTasks() {
        return createdTasks;
    }

    public void setCreatedTasks(List<Task> createdTasks) {
        this.createdTasks = createdTasks;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}