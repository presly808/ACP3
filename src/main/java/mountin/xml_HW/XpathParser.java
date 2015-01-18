package mountin.xml_HW;

/**
 * Created by mountin on 12/12/2014.
 */
import java.io.IOException;
        import java.util.ArrayList;
        import java.util.Arrays;
        import java.util.List;

        import javax.xml.parsers.DocumentBuilder;
        import javax.xml.parsers.DocumentBuilderFactory;
        import javax.xml.parsers.ParserConfigurationException;
        import javax.xml.xpath.XPath;
        import javax.xml.xpath.XPathConstants;
        import javax.xml.xpath.XPathExpression;
        import javax.xml.xpath.XPathExpressionException;
        import javax.xml.xpath.XPathFactory;

        import org.w3c.dom.Document;
        import org.w3c.dom.Element;
        import org.w3c.dom.NodeList;
        import org.xml.sax.SAXException;

public class XpathParser {

    public static final String ARTCODE_XML = "D:\\Stuff\\Java\\CodeACP3\\acp3\\src\\mountin\\xml_HW\\artcode.xml";
    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        DocumentBuilder builder;
        Document doc = null;
        try {
            builder = factory.newDocumentBuilder();
            
            doc = builder.parse(ARTCODE_XML);

            XPathFactory xpathFactory = XPathFactory.newInstance();

            XPath xpath = xpathFactory.newXPath();

            //show(ARTCODE_XML);
            String name = getEmployeeNameById(doc, xpath, 3);
            System.out.println("student Name with ID 3: " + name);

            List<String> femaleEmps = getMaleEmployeesName(doc, xpath);
            System.out.println("Male LIST of  Students names are:" +
                    Arrays.toString(femaleEmps.toArray()));

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

    }


    public static void show(String path) throws ParserConfigurationException, IOException, SAXException, XPathExpressionException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
        Document document =  documentBuilder.parse(path);
        Element root = document.getDocumentElement();//root tag group

        System.out.println(root.getTagName() + " tst:" + root.getAttribute("name"));
        //parseTags(root,"");
        XPath xPath = XPathFactory.newInstance().newXPath();
        String fullname = xPath
                .compile("/list/group/student[@id='3']/lastname")
                .evaluate(document);

        System.out.println(fullname);
        System.out.println("--------------------");

    }
    private static List<String> getMaleEmployeesName(Document doc, XPath xpath) {
        List<String> list = new ArrayList<>();
        try {
            XPathExpression expr =
                    xpath.compile("/list/group/student[@gender='Male']/firstname/text()");
            NodeList nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
            for (int i = 0; i < nodes.getLength(); i++)
                list.add(nodes.item(i).getNodeValue());
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        return list;
    }


    private static String getEmployeeNameById(Document doc, XPath xpath, int id) {
        String name = null;
        try {
            XPathExpression expr =
                    xpath.compile("/list/group/student[@id='" + id + "']/firstname/text()");
            name = (String) expr.evaluate(doc, XPathConstants.STRING);
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }

        return name;
    }

}