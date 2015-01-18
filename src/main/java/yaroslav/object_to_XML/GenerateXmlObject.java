package yaroslav.object_to_XML;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.lang.reflect.Field;
import java.util.Objects;

/**
 * Created by admin on 07.12.2014.
 */
public class GenerateXmlObject {

    private Object object;
    private Class thisClass;
    private String path;
    private static Document document;
    private Element root;

    public GenerateXmlObject(Object object, String path) throws ParserConfigurationException, TransformerException, IllegalAccessException {
        this.object = object;
        thisClass = object.getClass();
        this.path = path;
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        document = builder.newDocument();
        root = document.createElement(thisClass.getName());
        document.appendChild(root);
        toXml(object,root);
    }

    public void toXml(Object obj, Element root) throws ParserConfigurationException, TransformerException, IllegalAccessException {
        Class c = obj.getClass();
        Field[] fields = c.getDeclaredFields();
        for (Field f : fields) {
            f.setAccessible(true);
            Element element = document.createElement(f.getName());
            if (f.getType().equals(String.class) || f.getType().isPrimitive()) {
                element.appendChild(document.createTextNode(String.valueOf(f.get(obj))));
            } else {
                toXml(f.get(obj), element);
            }
            root.appendChild(element);
        }


        //transform model to stream and save into file
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.transform(new DOMSource(document), new StreamResult(new File(path)));
    }


}

