package ua.artcode.model;

import javax.persistence.*;

/**
 * Created by Yaroslav on 23.12.2014.
 */
@Entity
@Table(name = "PASSPORTS")
public class Passport {
    @Id
    @GeneratedValue
    int id;
    @Column(unique = true)
    private String login;
    private String pass;
    @OneToOne(cascade = CascadeType.PERSIST)
    User user;

    public Passport() {

    }

    public Passport(String login, String pass, User user) {
        this.login = login;
        this.pass = pass;
        this.user = user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
