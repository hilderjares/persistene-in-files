package ufc.si.persistence_challenge_01;

import java.util.logging.Level;
import java.util.logging.Logger;

import ufc.si.persistence_challenge_01.csv_to_xml.ConverterCsvToXmlRunner;
import ufc.si.persistence_challenge_01.xml_to_json.ConverterXmlToJsonRunner;

public class App {

    private static final Logger LOGGER = Logger.getLogger( App.class.getName() );
    public static void main(String[] args) {

        LOGGER.log(Level.INFO, "Starting...");

        ConverterXmlToJsonRunner converterXmlToJsonRunner = new ConverterXmlToJsonRunner();
        converterXmlToJsonRunner.runner();

        ConverterCsvToXmlRunner converterCsvToXmlRunner = new ConverterCsvToXmlRunner();
        converterCsvToXmlRunner.runner();

        LOGGER.log(Level.INFO, "Ending...");
    }
}
