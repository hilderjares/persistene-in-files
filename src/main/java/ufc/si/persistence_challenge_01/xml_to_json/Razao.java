package ufc.si.persistence_challenge_01.xml_to_json;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Razao {

    public Razao() {
    }

    @XmlElement(name = "censo")
    private List<Censo> censos;

    public List<Censo> getCensos() {
        return censos;
    }

    public void setCensos(List<Censo> censos) {
        this.censos = censos;
    }
}