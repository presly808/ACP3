package yaroslav.ex_ua_parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;

/**
 * Created by Администратор on 09.12.2014.
 */
public class MyParserJSOUP {
    private Document document = null;
    private LinkedList<String> list = new LinkedList<>();




    public void parse(String urlPage) throws IOException {
        document = Jsoup.connect(urlPage).get();
        Elements links = document.select("a");
        for (int i = 0; i < links.size(); i++) {

            String s = links.get(i).toString();
            if (s.contains("/load/") && s.contains("загрузить")) {
                list.add("http://www.ex.ua" + links.get(i).attr("href"));
            }

        }

        downlad();
    }

    private void downlad() throws MalformedURLException {
        int readBytes = 0;
        URL url = null;
        int i = 0;
        for (String link : list) {
            url = new URL(link);
            try {
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.connect();
                BufferedInputStream bis = new BufferedInputStream(conn.getInputStream());
                System.out.println("Download file" + i + ".jpg");
                File f1 = new File("d:/exUA/file" + i  + ".jpg" );
                FileOutputStream fw = new FileOutputStream(f1);

                byte[] btBuffer = new byte[1048576];
                int intRead = 0;
                while ((intRead = bis.read(btBuffer)) != -1) {
                    fw.write(btBuffer, 0, intRead);
                    readBytes = readBytes + intRead;
                }
                fw.close();
                System.out.println("Download file" + i++ + ".jpg complete.");

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }
}
