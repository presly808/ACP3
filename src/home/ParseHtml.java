package home;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import ua.artcode.week4.day1.DomParser;

import javax.xml.parsers.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;

/**
 * Created by admin on 09.12.2014.
 */
public class ParseHtml {


    public static void main(String[] args) throws ParserConfigurationException, SAXException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input url");
        parse(sc.nextLine().trim());


    }

    public static void parse(String strUri){
        try {
            URI uri = new URI(strUri);
            InputStream is = uri.toURL().openStream();
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = builder.newDocument();
            document = builder.parse(is);
            /*BufferedReader br = new BufferedReader(new InputStreamReader(is));

            String line = null;
            while ((line = br.readLine()) != null){
                System.out.println(line);
            }*/

        } catch (URISyntaxException | IOException | ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
    }

}
