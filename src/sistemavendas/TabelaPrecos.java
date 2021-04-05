package sistemavendas;

public class TabelaPrecos {
    private Fornecedor fornecedor;
    private Item item;
    private float preco;

    public TabelaPrecos(Fornecedor fornecedor, Item item, float preco) {
        this.fornecedor = fornecedor;
        this.item = item;
        this.preco = preco;
    }

    public TabelaPrecos(TabelaPrecos entrada) {
        this.fornecedor = entrada.fornecedor;
        this.item = entrada.item;
        this.preco = entrada.preco;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
    
    
    
    
}
