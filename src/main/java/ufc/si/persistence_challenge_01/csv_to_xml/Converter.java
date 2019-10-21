package ufc.si.persistence_challenge_01.csv_to_xml;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Converter {

    private String pathFileXml;
    private String pathFileCsv;
    private DocumentFile documentFile;
    private Document document;

    public Converter(String pathFileXml, String pathFileCsv, DocumentFile documentFile) {
        this.pathFileXml = pathFileXml;
        this.pathFileCsv = pathFileCsv;
        this.documentFile = documentFile;
    }

    public void makeDocument() throws ParserConfigurationException, DOMException, IOException {

        Document document = this.documentFile.createDocumentFactory();
        Element root = this.documentFile.createElementRoot(document, "razao");
        BufferedReader csvReader = new BufferedReader(new FileReader(this.pathFileCsv));

        String row;
        int index = 0;
        boolean created = false;

        while ((row = csvReader.readLine()) != null) {
            String[] data = row.split(",");

            if (created) {

                Element element = document.createElement("censo");
                root.appendChild(element);

                this.documentFile.createAttribute("index", index, document, element);

                this.documentFile.createElement("id", data[0], document, element);
                this.documentFile.createElement("grid", data[1], document, element);
                this.documentFile.createElement("uf", data[2], document, element);
                this.documentFile.createElement("nome", data[3], document, element);
                this.documentFile.createElement("ano_censo", data[4], document, element);

                index = index + 1;
            }
            created = true;
        }
        csvReader.close();

        this.document = document;
    }

    public void converter() throws TransformerException {

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource domSource = new DOMSource(this.document);
        StreamResult streamResult = new StreamResult(new File(this.pathFileXml));

        transformer.transform(domSource, streamResult);
    }
}