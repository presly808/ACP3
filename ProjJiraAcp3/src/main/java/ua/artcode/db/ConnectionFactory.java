package ua.artcode.db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by User on 14.12.2014.
 */
public class ConnectionFactory {
    private static ConnectionFactory INSTANCE = new ConnectionFactory();

    private final String URL;
    private final String USER;
    private final String PASS;

    public ConnectionFactory() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("classpath:db.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        URL = properties.getProperty("db.url");
        URL = properties.getProperty("db.user");
        URL = properties.getProperty("db.pass");
    }

    public static ConnectionFactory getINSTANCE() {
        return INSTANCE;
    }

    public Connection newConnetion() throws SQLException {
        return DriverManager.getConnection(URL,USER,PASS);
    }

}
