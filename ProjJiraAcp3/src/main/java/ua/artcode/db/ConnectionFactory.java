package ua.artcode.db;


import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by Yaroslav on 14.12.2014.
 */
public class ConnectionFactory {
    public static final String CLASSPATH_DB_PROPERTIES = "D:\\ArtCodeProj\\ACP3\\ProjJiraAcp3\\src\\main\\resources\\db.properties";
    private static ConnectionFactory INSTANSE = new ConnectionFactory();
    private  final String URL;
    private  final String USER;
    private  final String PASS;

    public ConnectionFactory() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(CLASSPATH_DB_PROPERTIES));
        } catch (IOException e) {
            e.printStackTrace();
        }

        URL = properties.getProperty("db.url");
        USER = properties.getProperty("db.user");
        PASS = properties.getProperty("db.pass");
    }

    public static ConnectionFactory getINSTANCE(){
        return INSTANSE;
    }

    public  Connection newConnection() throws SQLException {

        return DriverManager.getConnection(URL, USER, PASS);
    }
}
