package itsiporenko.chat_swing_observe;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by User on 03.12.2014.
 */
public class Conf {
    private static final String PATH = "D:\\JAVA_PROG_GIT\\ACP3\\src\\itsiporenko\\chat_swing_observe\\config.prop";
    public static int PORT;
    public static int MAX_CLIENT_COUNT;

    static {
        FileInputStream fis;
        Properties property = new Properties();
        try {
            fis = new FileInputStream(PATH);
            property.load(fis);

            PORT               = Integer.parseInt(property.getProperty("PORT"));
            MAX_CLIENT_COUNT   = Integer.parseInt(property.getProperty("MAX_CLIENT_COUNT"));

        } catch (IOException e) {
            System.err.println("ОШИБКА: Файл свойств отсуствует!");
        }

    }

}
