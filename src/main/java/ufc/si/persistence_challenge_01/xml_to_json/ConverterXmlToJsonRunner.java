package ufc.si.persistence_challenge_01.xml_to_json;

import java.io.File;
import java.io.IOException;

import javax.xml.bind.JAXB;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ConverterXmlToJsonRunner {

    public void runner() {

        String fileJsonPath = "src/main/resources/output_json.json";
        String fileXmlPath = "src/main/resources/output_xml.xml";

        try {
            Razao razao = JAXB.unmarshal(new File(fileXmlPath), Razao.class);
            ObjectMapper mapper = new ObjectMapper();

            mapper.writeValue(new File(fileJsonPath), razao);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}