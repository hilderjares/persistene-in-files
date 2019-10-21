package ufc.si.persistence_challenge_01;

import ufc.si.persistence_challenge_01.csv_to_xml.ConverterCsvToXmlRunner;
import ufc.si.persistence_challenge_01.xml_to_json.ConverterXmlToJsonRunner;

public class App {
    public static void main(String[] args) {

        System.err.println("Starting...");

        ConverterXmlToJsonRunner converterXmlToJsonRunner = new ConverterXmlToJsonRunner();
        converterXmlToJsonRunner.runner();

        ConverterCsvToXmlRunner converterCsvToXmlRunner = new ConverterCsvToXmlRunner();
        converterCsvToXmlRunner.runner();

        System.err.println("Ending...");
    }
}
