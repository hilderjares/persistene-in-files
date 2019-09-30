package ufc.si.persistence_challenge_01;

public class App {
    public static void main(String[] args) {
        String fileCsvPath = "src/files/vw_razao_medicos_1000_hab.csv";
        String fileXmlPath = "src/files/output_xml.xml";
        String fileJsonPath = "src/files/output_json.json";

        FileCsv fileCsv = new FileCsv(fileCsvPath, "", ",");

        FileXml fileXml = new FileXml(fileXmlPath);

        FileJson fileJson = new FileJson(fileXmlPath, fileJsonPath);

        fileXml.saveXml();

        fileJson.createFileJson();
    }
}
