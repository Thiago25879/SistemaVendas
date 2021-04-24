package sistemavendas;

import java.util.Scanner;

public class SistemaVendas {

    public static void main(String[] args) {
        //Variáveis de funcionamento
        Scanner scan = new Scanner(System.in);
        
        Principal menu = new Principal ();
        
        menu.listaItems.add(new Item("Headset"));
        menu.listaItems.add(new Item("Mouse"));
        menu.listaItems.add(new Item("Monitor"));
        menu.listaItems.add(new Item("Smartphone"));
        menu.listaItems.add(new Item("Desktop"));
        menu.listaFornecedores.add(new Fornecedor("Dell", Float.valueOf("23.00")));
        menu.listaFornecedores.add(new Fornecedor("Samsung", Float.valueOf("44.00")));
        menu.listaFornecedores.add(new Fornecedor("Positivo", Float.valueOf("177.00")));
        menu.listaFornecedores.add(new Fornecedor("AMD", Float.valueOf("100.00")));
        menu.listaFornecedores.add(new Fornecedor("LG", Float.valueOf("12.00")));
        menu.tabelaPrecos.add(new TabelaPrecos(menu.listaFornecedores.get(0), menu.listaItems.get(4), Float.valueOf("43.00")));
        menu.tabelaPrecos.add(new TabelaPrecos(menu.listaFornecedores.get(0), menu.listaItems.get(2), Float.valueOf("27.00")));
        menu.tabelaPrecos.add(new TabelaPrecos(menu.listaFornecedores.get(1), menu.listaItems.get(0), Float.valueOf("110.00")));
        menu.tabelaPrecos.add(new TabelaPrecos(menu.listaFornecedores.get(1), menu.listaItems.get(1), Float.valueOf("47.00")));
        menu.tabelaPrecos.add(new TabelaPrecos(menu.listaFornecedores.get(2), menu.listaItems.get(2), Float.valueOf("12.00")));
        menu.tabelaPrecos.add(new TabelaPrecos(menu.listaFornecedores.get(3), menu.listaItems.get(1), Float.valueOf("34.00")));
        menu.tabelaPrecos.add(new TabelaPrecos(menu.listaFornecedores.get(3), menu.listaItems.get(4), Float.valueOf("77.00")));
        menu.tabelaPrecos.add(new TabelaPrecos(menu.listaFornecedores.get(4), menu.listaItems.get(0), Float.valueOf("22.00")));
        menu.avaliacoes.add(new TabelaAvaliacoes(menu.listaFornecedores.get(0), 2));
        menu.avaliacoes.add(new TabelaAvaliacoes(menu.listaFornecedores.get(0), 1));
        menu.avaliacoes.add(new TabelaAvaliacoes(menu.listaFornecedores.get(0), 2));
        menu.avaliacoes.add(new TabelaAvaliacoes(menu.listaFornecedores.get(1), 5));
        menu.avaliacoes.add(new TabelaAvaliacoes(menu.listaFornecedores.get(1), 5));
        menu.avaliacoes.add(new TabelaAvaliacoes(menu.listaFornecedores.get(1), 5));
        menu.avaliacoes.add(new TabelaAvaliacoes(menu.listaFornecedores.get(2), 4));
        menu.avaliacoes.add(new TabelaAvaliacoes(menu.listaFornecedores.get(2), 4));
        menu.avaliacoes.add(new TabelaAvaliacoes(menu.listaFornecedores.get(2), 5));
        menu.avaliacoes.add(new TabelaAvaliacoes(menu.listaFornecedores.get(3), 3));
        menu.avaliacoes.add(new TabelaAvaliacoes(menu.listaFornecedores.get(3), 3));
        menu.avaliacoes.add(new TabelaAvaliacoes(menu.listaFornecedores.get(3), 5));
        menu.avaliacoes.add(new TabelaAvaliacoes(menu.listaFornecedores.get(4), 5));
        menu.avaliacoes.add(new TabelaAvaliacoes(menu.listaFornecedores.get(4), 5));
        menu.avaliacoes.add(new TabelaAvaliacoes(menu.listaFornecedores.get(4), 5));
        menu.carrinho.addItem(menu.listaItems.get(0));
        menu.carrinho.addItem(menu.listaItems.get(0));
        menu.carrinho.addItem(menu.listaItems.get(1));
        menu.carrinho.addItem(menu.listaItems.get(1));
        menu.carrinho.addItem(menu.listaItems.get(3));
        menu.carrinho.addItem(menu.listaItems.get(3));
        menu.carrinho.addItem(menu.listaItems.get(2));
        
        menu.processar(menu.carrinho);
    }
    
    
}
