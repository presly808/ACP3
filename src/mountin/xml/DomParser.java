//package mountin.xml;
//
//import org.w3c.dom.Document;
//import org.xml.sax.SAXException;
//
//import javax.lang.model.element.Element;
//import javax.xml.parsers.DocumentBuilder;
//import javax.xml.parsers.DocumentBuilderFactory;
//import javax.xml.parsers.ParserConfigurationException;
//import java.io.IOException;
//import javax.lang.model.element.Element;
//
//
///**
// * Created by mountin on 6/12/2014.
// */
//public class DomParser {
//
//    public static final String ARTCODE_XML = "artcode.xml";
//
//    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException{
//
//
//    }
//    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//    DocumentBuilder DocumentBuilder;
//
//    {
//        try {
//            DocumentBuilder = factory.newDocumentBuilder();
//        } catch (ParserConfigurationException e) {
//            e.printStackTrace();
//        }
//    }
//
//    Document document;
//
//    {
//        try {
//            document = DocumentBuilder.parse(ARTCODE_XML);
//        } catch (SAXException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    Element element = (Element) document.getDocumentElement();
//
//    system.out.println(element.getTagName());
//
//
//
//
//
//
//
//
//
//
//
//
//
//}
