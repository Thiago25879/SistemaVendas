package sistemavendas;

import java.util.ArrayList;

//A classe ItensRelevantes vai registrar todas as ofertas de todos os itens no carrinho do usuário
public class ItensRelevantes{

    private ArrayList entrada = new ArrayList<TabelaPrecos>();

    public ItensRelevantes() {
    }

    public ArrayList<TabelaPrecos> getEntrada() {
        return entrada;
    }

    public void setEntrada(ArrayList entrada) {
        this.entrada = entrada;
    }

}
