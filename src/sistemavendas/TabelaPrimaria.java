package sistemavendas;

public class TabelaPrimaria {
    
    //0 - Vazio
    //1 - Maior
    //2 - Menor
    
    private Integer tabela[][];

    public TabelaPrimaria(int numFornecedores) {
        this.tabela = new Integer[numFornecedores][numFornecedores];
    }

    public Integer[][] getTabela() {
        return tabela;
    }

    public void setTabela(Integer[][] tabela) {
        this.tabela = tabela;
    }
}
