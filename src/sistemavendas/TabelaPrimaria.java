package sistemavendas;

//A classe TabelaPrimaria contem a tabela que registra todas as comparações entre todos os fornecedores que ja foram feitas anteriormente
public class TabelaPrimaria {
    
    //0 - Vazio
    //1 - Maior
    //2 - Menor
    //3 - Igual
    
    private Integer tabela[][];

    public TabelaPrimaria(int numFornecedores) {
        this.tabela = new Integer[numFornecedores][numFornecedores];
        for (int i = 0; i < numFornecedores; i++) {
            for (int a = 0; a < numFornecedores; a++) {
                tabela[i][a] = 0;
            }
        }
    }

    public Integer[][] getTabela() {
        return tabela;
    }

    public void setTabela(Integer[][] tabela) {
        this.tabela = tabela;
    }
}
