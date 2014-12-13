package ua.artcode.week4.day1;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.IOException;

/**
 * Created by admin on 06.12.2014.
 */
public class DomParser {


    public static final String TEMP_ARTCODE_XML = "temp/artcode.xml";

    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException, XPathExpressionException {
        show(TEMP_ARTCODE_XML);
    }

    public static void show(String path) throws ParserConfigurationException, IOException, SAXException, XPathExpressionException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
        Document document =  documentBuilder.parse(path);
        Element root = document.getDocumentElement();//root tag group

        System.out.println(root.getTagName() + " " + root.getAttribute("name"));
        //parseTags(root,"");
        XPath xPath = XPathFactory.newInstance().newXPath();
        String fullname = xPath
                .compile("/group/student[@id='1']/lastname")
                .evaluate(document);
        System.out.println(fullname);


    }

    public static void parseTags(Node root, String spaces){// "   "
        NodeList list = root.getChildNodes();
        for(int i = 0; i < list.getLength(); i++){
            Node node = list.item(i);
            short nodeType = node.getNodeType();
            if(nodeType == Node.ELEMENT_NODE){
                Element element = (Element) node;
                System.out.println(spaces + "<"+element.getTagName()+">");
                if(node.hasChildNodes()){
                    parseTags(node, spaces + "\t");
                }
                System.out.println(spaces + "</"+element.getTagName()+">");
            } else if(nodeType == Node.TEXT_NODE){
                Text text = (Text) node;
                System.out.println(spaces + (!text.getWholeText().contains("\n") ?
                        node.getNodeValue() : ""));
            }
        }
    }


}
