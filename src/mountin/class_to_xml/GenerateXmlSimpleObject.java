package mountin.class_to_xml;

import com.sun.org.apache.xerces.internal.jaxp.DocumentBuilderFactoryImpl;
import org.w3c.dom.Element;
import sun.plugin.dom.core.Document;

import javax.xml.crypto.dsig.Transform;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

/**
 * Created by mountin on 7/12/2014.
 */
public class GenerateXmlSimpleObject {

    public String type;
    public void main(String[] args) throws TransformerException, ParserConfigurationException {
        Flat flat = new Flat(500, "studio");
        toXml(flat, "d:/flat.xml");
    }

    public void toXml(Flat flat, String path) throws ParserConfigurationException, TransformerException {

        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document = (Document) builder.newDocument();
        Element root = document.createElement("flat");
        document.appendChild(root);

        Element type1 = document.createElement("type");
        type1.appendChild(document.createTextNode(flat.type));
        root.appendChild(type1);

        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.transform( new DOMSource(document), new StreamResult((new File(path))));

    }
}
