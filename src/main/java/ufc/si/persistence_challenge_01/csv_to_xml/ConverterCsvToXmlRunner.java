package ufc.si.persistence_challenge_01.csv_to_xml;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.w3c.dom.DOMException;

public class ConverterCsvToXmlRunner {

    public void runner() {

        try {

            String fileXmlPath = "src/main/resources/output_xml.xml";
            String fileCsvPath = "src/main/resources/vw_razao_medicos_1000_hab.csv";

            DocumentFile documentFile = new DocumentFile();
            Converter converterCsvToXml = new Converter(fileXmlPath, fileCsvPath, documentFile);

            converterCsvToXml.makeDocument();
            converterCsvToXml.converter();

        } catch (DOMException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}