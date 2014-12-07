package ua.artcode.week4.day1;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

/**
 * Created by admin on 07.12.2014.
 */
public class GenerateXmlSimpleObject {

    public static void main(String[] args) throws TransformerException, ParserConfigurationException {
        Flat flat = new Flat(500, "studio");
        toXml(flat, "f:/flat.xml");
    }

    public static void toXml(Flat flat, String path) throws ParserConfigurationException, TransformerException {
        DocumentBuilder builder = DocumentBuilderFactory.newInstance()
                .newDocumentBuilder();
        Document document = builder.newDocument();
        Element root = document.createElement("flat");
        document.appendChild(root);

        Element sqrtEl = document.createElement("sqrt");
        sqrtEl.appendChild(document.createTextNode(String.valueOf(flat.sqrt)));
        root.appendChild(sqrtEl);

        Element typeEl = document.createElement("type");
        typeEl.appendChild(document.createTextNode(flat.type));
        root.appendChild(typeEl);

        //transform model to stream and save into file
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.transform(new DOMSource(document), new StreamResult(new File(path)));
    }


}

class Flat {

    public double sqrt;
    public String type;

    Flat(double sqrt, String type) {
        this.sqrt = sqrt;
        this.type = type;
    }
}
