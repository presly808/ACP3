package ua.artcode.network;

import ua.artcode.model.User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yaroslav on 24.12.2014.
 */
public class MyPackage implements Serializable {
    private String command = "";
    private List<String> args = new ArrayList<String>();
    private int user = 0;

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public List<String> getArgs() {
        return args;
    }

    public void setArgs(List<String> args) {
        this.args = args;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }
}
