package yaroslav.test;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

/**
 * Created by Администратор on 07.12.2014.
 */
public class TestSaxParser {

    public static final String PATHNAME = "/temp/artcode.xml";

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();
        saxParser.parse(new File(PATHNAME), new MySaxHandler());

    }
}

class MySaxHandler extends DefaultHandler {


    @Override
    public void startElement(String uri,  String localName, String qName, Attributes attributes) throws SAXException {
        System.out.printf("Start elemenet - Uri: %s, local name : %s, gName: %s", uri, localName, qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.printf("End Element - Uri: %s, local name : %s, gName: %s", uri, localName, qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
//        System.out.println("char " + new String(ch));
    }
}
