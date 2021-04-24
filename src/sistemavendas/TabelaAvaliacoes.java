package sistemavendas;

//A classe TabelaAvaliacoes contem todas as avaliações individuais de fornecedores registradas no sistema
public class TabelaAvaliacoes {
    private Fornecedor fornecedor;
    private Integer avaliacao;

    public TabelaAvaliacoes(Fornecedor fornecedor, Integer avaliacao) {
        this.fornecedor = fornecedor;
        this.avaliacao = avaliacao;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Integer getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Integer avaliacao) {
        this.avaliacao = avaliacao;
    }
    
    
}
