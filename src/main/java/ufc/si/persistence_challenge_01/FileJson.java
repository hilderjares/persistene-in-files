package ufc.si.persistence_challenge_01;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import com.fasterxml.jackson.core.JsonGenerationException;

import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * FileJson
 */
public class FileJson extends DefaultHandler {
    private boolean id = false;
    private boolean grid = false;
    private boolean nome = false;
    private boolean uf = false;
    private boolean censo = false;

    private ArrayList listCenso;
    private String filePathXml;
    private String filePathJson;
    private ObjectMapper mapper;

    String idValue = "";
    String gridValue = "";
    String ufValue = "";
    String nomeValue = "";
    String censoValue = "";

    public FileJson(String filePathXml, String filePathJson) {
        super();

        this.filePathXml = filePathXml;
        this.filePathJson = filePathJson;

        listCenso = new ArrayList<Censo>();
        mapper = new ObjectMapper();
    }

    public void createFileJson() {
        SAXParserFactory factory;
        SAXParser parser;

        try {
            factory = SAXParserFactory.newInstance();
            parser = factory.newSAXParser();

            parser.parse(this.filePathXml, this);

            mapper.writeValue(new File(this.filePathJson), listCenso);

            String jsonInString = mapper.writeValueAsString(listCenso);
            //System.out.println(jsonInString);

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        if (qName.equalsIgnoreCase("razao")) {
            String no = attributes.getValue("index");
            System.out.println("No Value Index:" + no);
        }

        if (qName.equalsIgnoreCase("id")) {
            this.id = true;
        }

        if (qName.equalsIgnoreCase("grid")) {
            this.grid = true;
        }

        if (qName.equalsIgnoreCase("uf")) {
            this.uf = true;
        }

        if (qName.equalsIgnoreCase("nome")) {
            this.nome = true;
        }

        if (qName.equalsIgnoreCase("censo")) {
            this.censo = true;
        }
    }

    @Override
    public void endDocument() {
      
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        Censo censoObj = new Censo(this.idValue, this.censoValue, this.ufValue, this.nomeValue, this.censoValue);
        this.listCenso.add(censoObj);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {

        String text = new String(ch, start, length);

        if (this.id) {
            System.out.println("ID: " + new String(ch, start, length));
            this.idValue = text;
            this.id = false;
        }

        if (this.grid) {
            System.out.println("GRID: " + new String(ch, start, length));
            this.gridValue = new String(ch, start, length);
            this.grid = false;
        }

        if (this.uf) {
            System.out.println("UF: " + new String(ch, start, length));
            this.ufValue = text;
            this.uf = false;
        }

        if (this.nome) {
            System.out.println("NOME: " + new String(ch, start, length));
            this.nomeValue = text;
            this.nome = false;
        }

        if (this.censo) {
            System.out.println("CENSO: " + new String(ch, start, length));
            this.censoValue = text;
            this.censo = false;
        }
    }
}