package sistemavendas;

import java.util.ArrayList;

public class Carrinho {
    private ArrayList carrinho = new ArrayList<Item>();

    public Carrinho() {
    }

    public ArrayList<Item> getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(ArrayList carrinho) {
        this.carrinho = carrinho;
    }
}
