package sistemavendas;

//A classe Item representa os itens, sem relação com fornecedor ou preco
public class Item {
    private String nome;

    public Item(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
