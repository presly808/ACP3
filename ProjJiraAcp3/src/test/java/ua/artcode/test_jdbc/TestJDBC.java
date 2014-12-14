package ua.artcode.test_jdbc;

import java.sql.*;
import java.util.Enumeration;

/**
 *
 */
public class TestJDBC {

    public static final String URL = "jdbc:mysql://localhost:3306/simple_jira";
    public static final String USER = "root";
    public static final String PASSWORD = "root";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        printAllDriver();

        writeUseTransaction();

        read();

    }

    private static void read() throws SQLException {
        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT id,name FROM users");
        while (resultSet.next()) {
            int userId = resultSet.getInt("id");
            String userName = resultSet.getString("name");
            System.out.printf("id: %d, name: %s\n", userId, userName);
        }
        connection.close();
    }

    public static void writeUseTransaction() {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            statement = connection.createStatement();

            connection.setAutoCommit(false);
            statement.execute("INSERT INTO users (name) VALUES ('Petro')");
            statement.execute("INSERT INTO users (name) VALUES ('Olia')");
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
            if (connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    static void printAllDriver() {
        Enumeration<Driver> driverEnumeration = DriverManager.getDrivers();
        while (driverEnumeration.hasMoreElements()) {
            System.out.println(driverEnumeration.nextElement());
        }
    }
}
