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
    public User find(int id) {
        Connection connection = null;
        try {
            connection = ConnectionFactory.getINSTANCE().newConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT id,name FROM users WHERE id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                return new User(rs.getInt("id"), rs.getString("name"));
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
            PreparedStatement ps = connection.prepareStatement("INSERT INTO users (id,name) VALUES (?,?)");
            ps.setInt(1,user.getId());
            ps.setString(2, user.getName());
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
