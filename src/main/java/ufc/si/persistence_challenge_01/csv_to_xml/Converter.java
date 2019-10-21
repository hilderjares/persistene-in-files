package ufc.si.persistence_challenge_01.csv_to_xml;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

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

    public void makeDocument() throws ParserConfigurationException, IOException {

        Document documentCensus = this.documentFile.createDocumentFactory();
        Element root = this.documentFile.createElementRoot(documentCensus, "razao");
        BufferedReader csvReader = new BufferedReader(new FileReader(this.pathFileCsv));

        String row;
        int index = 0;
        boolean createdLabels = false;

        while ((row = csvReader.readLine()) != null) {
            String[] data = row.split(",");

            /*
            / this condition is because the first loop read the labels,
            / and the program not want store the labels in csv output
            */
            if (createdLabels) {

                Element element = documentCensus.createElement("censo");
                root.appendChild(element);

                this.documentFile.createAttribute("index", index, documentCensus, element);

                this.documentFile.createElement("id", data[0], documentCensus, element);
                this.documentFile.createElement("grid", data[1], documentCensus, element);
                this.documentFile.createElement("uf", data[2], documentCensus, element);
                this.documentFile.createElement("nome", data[3], documentCensus, element);
                this.documentFile.createElement("ano_censo", data[4], documentCensus, element);

                index = index + 1;
            }
            createdLabels = true;
        }
        csvReader.close();

        this.document = documentCensus;
    }

    public void converter() throws TransformerException {

        TransformerFactory factory = TransformerFactory.newInstance();
        factory.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "");
        factory.setAttribute(XMLConstants.ACCESS_EXTERNAL_STYLESHEET, "");

        Transformer transformer = factory.newTransformer();
        DOMSource domSource = new DOMSource(this.document);
        StreamResult streamResult = new StreamResult(new File(this.pathFileXml));

        transformer.transform(domSource, streamResult);
    }
}