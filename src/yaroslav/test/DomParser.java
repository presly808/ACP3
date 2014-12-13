package yaroslav.test;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.IOException;
import java.security.cert.X509Certificate;

/**
 * Created by Администратор on 06.12.2014.
 */
public class DomParser {

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException, XPathExpressionException {
        show();
    }

    public static void show() throws ParserConfigurationException, IOException, SAXException, XPathExpressionException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse("D:\\Java\\newACP3\\ACP3\\temp\\test.xml");
        Element element = doc.getDocumentElement(); //root
        NodeList nodeList = element.getChildNodes();
        XPath xPath = XPathFactory.newInstance().newXPath();
   //             parseTags(element, "");


    }

    public static void parseTags(Node root, String spaces) {
        NodeList nodeList = root.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++ ) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                System.out.println(node.getNodeName());
                parseTags(node, spaces + "\t");
            } else if (node.getNodeType() == Node.TEXT_NODE) {
                System.out.println(!node.getNodeValue().contains("\n") ? node.getNodeValue() : "");
            }
        }
    }
}
