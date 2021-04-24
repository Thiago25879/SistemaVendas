package sistemavendas;

import java.util.ArrayList;

//A classe FornecedoresRelevantes registra quais fornecedores ofertam pelo menos um dos itens que o usuário deseja
public class FornecedoresRelevantes {
    
    private ArrayList entrada = new ArrayList<Fornecedor>();

    public FornecedoresRelevantes() {
    }

    public ArrayList<Fornecedor> getEntrada() {
        return entrada;
    }

    public void setEntrada(ArrayList entrada) {
        this.entrada = entrada;
    }
    
}
