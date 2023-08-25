package modelo;
public class Bairro {
    private String nomeBairro;
    public Bairro(String nomeBairro){
        this.nomeBairro = nomeBairro;
    }

    public String getNome() {
        return nomeBairro;
    }

    public void setNome(String nomeBairro) {
        this.nomeBairro = nomeBairro;
    }
    @Override
    public String toString() {
        return "Bairro: " + nomeBairro;
    }
}
