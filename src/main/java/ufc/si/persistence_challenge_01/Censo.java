package ufc.si.persistence_challenge_01;

public class Censo {

    private String id;
    private String grid;
    private String uf;
    private String nome;
    private String censo;

    public Censo(String id, String grid, String uf, String nome, String censo) {
        this.setId(id);
        this.setGrid(grid);
        this.setUf(uf);
        this.setNome(nome);
        this.setCenso(censo);
    }

    public String getCenso() {
        return censo;
    }

    public void setCenso(String censo) {
        this.censo = censo;
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