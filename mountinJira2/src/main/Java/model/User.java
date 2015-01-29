package model;

/**
 * Created by admin on 07.12.2014.
 */
public class User {
    public  String name;
    public  String password;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public User() {
        this.name = "mountin";
        this.password = "12345";
    }
}
