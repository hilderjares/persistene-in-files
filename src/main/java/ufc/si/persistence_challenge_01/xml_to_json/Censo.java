package ufc.si.persistence_challenge_01.xml_to_json;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Censo {

    private String id;
    private String grid;
    private String uf;
    private String nome;
    @XmlElement(name = "ano_censo")
    private String anoCenso;

    public Censo() {
        // Do nothing because JAXB need the default constructor
    }

    public String getAnoCenso() {
        return anoCenso;
    }

    public void setAnoCenso(String anoCenso) {
        this.anoCenso = anoCenso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getGrid() {
        return grid;
    }

    public void setGrid(String grid) {
        this.grid = grid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}