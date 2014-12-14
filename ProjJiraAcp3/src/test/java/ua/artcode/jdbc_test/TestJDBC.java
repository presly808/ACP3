package ua.artcode.jdbc_test;


import java.sql.*;
import java.util.Enumeration;

/**
 * Created by Yaroslav on 14.12.2014
 */
public class TestJDBC {

    public static final String URL = "jdbc:mysql://localhost:3306/simple_jira";
    public static final String USER = "root";
    public static final String PASSWORD = "1111";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        showDriver();
        Class.forName("com.mysql.jdbc.Driver");
        read();
        write();
        read();

    }

    private static void read() throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT id,name FROM users");
        while (resultSet.next()) {
            int userID = resultSet.getInt("id");
            String userName = resultSet.getString("name");
            System.out.println("id:" + userID + " name:" + userName);
        }
        connection.close();
    }

    private static void write() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO users (name) VALUE ('JAVA1')");
            statement.executeUpdate("INSERT INTO users (name) VALUE ('JAVA2')");
            connection.commit();
        } catch (SQLException e) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        } finally {
            try {
                if(connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }

    private static  void showDriver(){
    Enumeration<Driver> en = DriverManager.getDrivers();
    while (en.hasMoreElements()) {
        System.out.println(en.nextElement().toString());
    }
}
}
