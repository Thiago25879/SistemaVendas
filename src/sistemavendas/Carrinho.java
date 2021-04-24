package sistemavendas;

import java.util.ArrayList;

public class Carrinho {
    private ArrayList<Item> carrinho = new ArrayList<Item>();

    public Carrinho() {
    }
    
    public void addItem(Item item){
        carrinho.add(item);
    }

    public ArrayList<Item> getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(ArrayList carrinho) {
        this.carrinho = carrinho;
    }
}
