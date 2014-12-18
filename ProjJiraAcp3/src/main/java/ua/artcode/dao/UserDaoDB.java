package ua.artcode.dao;

import ua.artcode.db.ConnectionFactory;
import ua.artcode.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by admin on 14.12.2014.
 */
public class UserDaoDB implements IUserDao {

    @Override
    public User find(String login, String pass) {
        Connection connection = null;
        try {
            connection = ConnectionFactory.getINSTANCE().newConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT id, name, login, pass, email FROM users WHERE login=? AND  pass=?");

            ps.setString(1, login);
            ps.setString(2, pass);

            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                return new User(rs.getInt("id"), rs.getString("name"), rs.getString("login"), rs.getString("pass"),rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public User find(int id) {
        Connection connection = null;
        try {
            connection = ConnectionFactory.getINSTANCE().newConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT id, name, login, pass, email FROM users WHERE id=?");

            ps.setString(1, String.valueOf(id));


            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                return new User(rs.getInt("id"), rs.getString("name"), rs.getString("login"), rs.getString("pass"),rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    @Override
    public void create(User user) {
        Connection connection = null;
        try {
            connection = ConnectionFactory.getINSTANCE().newConnection();
            PreparedStatement ps = connection.prepareStatement("INSERT INTO users (name,login,pass,email) VALUES (?,?,?,?)");
            ps.setString(1, user.getName());
            ps.setString(2, user.getLogin());
            ps.setString(3, user.getPass());
            ps.setString(4, user.getEmail());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
