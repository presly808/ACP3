package ua.artcode.week8;

/**
 * Created by Yaroslav on 18.01.2015.
 */
public class Dao {
    private String url;
    private int port;

    public Dao() {
    }

    public Dao(String url, int port) {
        this.url = url;
        this.port = port;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public String toString() {
        return "Dao{" +
                "url='" + url + '\'' +
                ", port=" + port +
                '}';
    }
}
