package ua.artcode.week4.parser;

import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import ua.artcode.week4.day1.DomParser;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

/**
 *
 */
public class TestSaxParser {

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();
        saxParser.parse(new File(DomParser.TEMP_ARTCODE_XML),new MySaxHandler());
    }

}

class MySaxHandler extends DefaultHandler {

    private boolean inFirstName = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
            throws SAXException {
        if("firstname".equals(qName)){
            inFirstName = true;
        }
        System.out.printf("Start element Uri : %s, localName : %s, qName : %s\n", uri, localName, qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if("firstname".equals(qName)){
            inFirstName = false;
        }
        System.out.printf("End element Uri : %s, localName : %s, qName : %s\n", uri, localName, qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if(inFirstName){
            System.out.println(new String(ch,start,length));
        }
    }
}
