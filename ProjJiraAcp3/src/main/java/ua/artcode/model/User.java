package ua.artcode.model;

import java.util.List;

/**
 * Created by admin on 07.12.2014.
 */
public class User {

    private int id;
    private String name;
    private String login;
    private String pass;
    private String email;
    private List<Task> myTasks;
    private List<Task> visitTasks;
    private List<Task> createdTasks;


    public User() {
    }

    public User(int id, String name, String login, String pass, String email) {
        this.name = name;
        this.login = login;
        this.pass = pass;
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
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
                ", login='" + login + '\'' +
                ", pass='" + pass + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}