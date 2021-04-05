package sistemavendas;

import java.util.ArrayList;

public class TabelaSecundaria {
    
    private Fornecedor tabelaFornecedores[];
    private float tabelaAvaliacaoMedia[];

    public TabelaSecundaria(int numFornecedores, FornecedoresRelevantes fornecedores) {
        this.tabelaFornecedores = new Fornecedor[numFornecedores];
        this.tabelaAvaliacaoMedia = new float[numFornecedores];
        
        int x = 0;
        for(Fornecedor fornecedor: tabelaFornecedores){
            tabelaFornecedores[x] = fornecedores.getEntrada().get(x);
            x++;
        }
    }

    public Fornecedor[] getTabelaFornecedores() {
        return tabelaFornecedores;
    }

    public void setTabelaFornecedores(Fornecedor[] tabelaFornecedores) {
        this.tabelaFornecedores = tabelaFornecedores;
    }

    public float[] getTabelaAvaliacaoMedia() {
        return tabelaAvaliacaoMedia;
    }

    public void setTabelaAvaliacaoMedia(float[] tabelaAvaliacaoMedia) {
        this.tabelaAvaliacaoMedia = tabelaAvaliacaoMedia;
    }
    
    public void addTabelaAvaliacaoMedia(Integer posicao, float valor) {
        this.tabelaAvaliacaoMedia[posicao] = valor;
    }
    

    
}
