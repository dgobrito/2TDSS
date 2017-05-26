package esensato.clickcall;

public class AlimentoBean {

    private String nome;

    private int calorias;

    public AlimentoBean(String nome, int calorias) {
        this.nome = nome;
        this.calorias = calorias;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCalorias() {
        return calorias;
    }

    public void setCalorias(int calorias) {
        this.calorias = calorias;
    }

    @Override
    public String toString() {
        return nome + " (" + calorias + ")";
    }
}
