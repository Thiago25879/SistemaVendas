package sistemavendas;

//A classe fornecedor contem todos os fornecedores registrados
public class Fornecedor {
    private String nome;
    private Float frete;

    public Fornecedor(String nome, Float frete) {
        this.nome = nome;
        this.frete = frete;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Float getFrete() {
        return frete;
    }

    public void setFrete(Float frete) {
        this.frete = frete;
    }
    
    
}
