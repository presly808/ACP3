package ua.artcode.db;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 */
public class ConnectionFactory {

    public static final String DB_PROP_PATH = "db.properties";

    private static ConnectionFactory INSTANCE = new ConnectionFactory();

    private final String URL;
    private final String USER;
    private final String PASS;

    private ConnectionFactory(){
        Properties properties = new Properties();
        try {
            File file = new File(getClass().getClassLoader().getResource(DB_PROP_PATH).getFile());
            properties.load(new FileInputStream(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        URL = properties.getProperty("db.url");
        USER = properties.getProperty("db.user");
        PASS = properties.getProperty("db.pass");
    }

    public static ConnectionFactory getINSTANCE() {
        return INSTANCE;
    }

    public Connection newConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }



}
