package ufc.si.persistence_challenge_01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * FileXml
 */
public class FileXml {

    private String filePath;

    public FileXml(String filePath) {
        this.filePath = filePath;
    }

    public void saveXml() {

        DocumentBuilderFactory documentBuilderFactory;
        DocumentBuilder documentBuilder;
        Document document;
        Element root;
        Transformer transformer;
        TransformerFactory transformerFactory;
        DOMSource domSource;
        StreamResult streamResult;
        BufferedReader csvReader;
        String row;
        int count = 0;
        String[] data;
        boolean created = false;
        Element element = null;

        try {

            documentBuilderFactory = DocumentBuilderFactory.newInstance();
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
            document = documentBuilder.newDocument();

            root = document.createElement("razao_medicos_habitantes");
            document.appendChild(root);

            csvReader = new BufferedReader(new FileReader("src/files/vw_razao_medicos_1000_hab.csv"));

            while ((row = csvReader.readLine()) != null) {
                data = row.split(",");

                if (created) {

                    element = document.createElement("razao");
                    root.appendChild(element);

                    Attr attr = document.createAttribute("index");
                    attr.setValue(Integer.toString(count));
                    element.setAttributeNode(attr);

                    Element id = document.createElement("id");
                    id.appendChild(document.createTextNode(data[0]));
                    element.appendChild(id);

                    Element grid = document.createElement("grid");
                    grid.appendChild(document.createTextNode(data[1]));
                    element.appendChild(grid);

                    Element uf = document.createElement("uf");
                    uf.appendChild(document.createTextNode(data[2]));
                    element.appendChild(uf);

                    Element nome = document.createElement("nome");
                    nome.appendChild(document.createTextNode(data[3]));
                    element.appendChild(nome);

                    Element censo = document.createElement("censo");
                    censo.appendChild(document.createTextNode(data[4]));
                    element.appendChild(censo);

                    count += 1;
                }

                created = true;
            }

            csvReader.close();

            transformerFactory = TransformerFactory.newInstance();
            transformer = transformerFactory.newTransformer();
            domSource = new DOMSource(document);
            streamResult = new StreamResult(new File(this.filePath));

            transformer.transform(domSource, streamResult);

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}