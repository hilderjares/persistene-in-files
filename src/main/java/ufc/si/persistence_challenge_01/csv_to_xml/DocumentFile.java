package ufc.si.persistence_challenge_01.csv_to_xml;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class DocumentFile {

    public Document createDocumentFactory() throws ParserConfigurationException {

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

        return documentBuilder.newDocument();
    }

    public Element createElementRoot(Document document, String name) {

        Element root = document.createElement(name);
        document.appendChild(root);

        return root;
    }

    public void createElement(String name, String value, Document document, Element element) {

        Element elementChild = document.createElement(name);
        elementChild.appendChild(document.createTextNode(value));
        element.appendChild(elementChild);
    }

    public Attr createAttribute(String name, int value, Document document, Element element) {

        Attr attribute = document.createAttribute(name);
        attribute.setValue(Integer.toString(value));
        element.setAttributeNode(attribute);

        return attribute;
    }
}