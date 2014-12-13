package mountin.xml_HW;

/** DOM
 * Created by mountin on 12/12/2014.
 */

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;

public class Parser {
    public static final String ARTCODE_XML = "D:\\Stuff\\Java\\CodeACP3\\acp3\\src\\mountin\\xml_HW\\artcode.xml";

    public static void main(String[] args) {
        try {

            File fXmlFile = new File(ARTCODE_XML);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document docEle = dBuilder.parse(fXmlFile);

            docEle.getDocumentElement().normalize();


            NodeList nList = docEle.getElementsByTagName("student");


            System.out.println("----------------------------" + nList.getLength());
            for (int temp = 0; temp < nList.getLength(); temp++)
            {

                Node nNode = nList.item(temp);

                System.out.println("\nCurrent Element :" + nNode.getNodeName());

                Element eElement = (Element) nNode;

                System.out.println("Staff id : " + eElement.getAttribute("id"));
                System.out.println("First Name : " + eElement.getElementsByTagName("firstname").item(0).getTextContent());
                System.out.println("Last Name : " + eElement.getElementsByTagName("lastname").item(0).getTextContent());
                Element eElement2;
                eElement2 = (Element) eElement.getParentNode();
                System.out.println("Group : " + eElement2.getAttribute("name"));


            }



        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }

    }
}
