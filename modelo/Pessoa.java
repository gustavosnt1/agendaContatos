package modelo;


public class Pessoa {
    private String nome;
    private String endereco;
    private int grauAmizade;
    private String dtNascimento;

    public Pessoa(String nome, String endereco, int grauAmizade, String dtNascimento) {
        this.nome = nome;
        this.endereco = endereco;
        this.grauAmizade = grauAmizade;
        this.dtNascimento = dtNascimento;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getGrauAmizade() {
        return grauAmizade;
    }

    public void setGrauAmizade(int grauAmizade) {
        this.grauAmizade = grauAmizade;
    }

    public String getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(String dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    @Override
    public String toString() {
        return "Pessoa: " + nome + "\n" +
                "" + endereco + "\n" +
                "Grau de Amizade: " + grauAmizade + "\n" +
                "Data de Nascimento: " + dtNascimento;
    }
}