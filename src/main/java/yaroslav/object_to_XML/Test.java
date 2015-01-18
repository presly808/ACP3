package yaroslav.object_to_XML;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

/**
 * Created by Администратор on 07.12.2014.
 */
public class Test {
    public static void main(String[] args) throws ParserConfigurationException, TransformerException, IllegalAccessException {
        Adress adress = new Adress("Kiev", 14);
        Human human = new Human("Yaroslav", 33, 51.4, adress);
        GenerateXmlObject generateXmlObject = new GenerateXmlObject(human, "D:/human.xml");
    }
}
