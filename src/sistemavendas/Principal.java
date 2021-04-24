package sistemavendas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

    //Listas
    ArrayList<Item> listaItems = new ArrayList<Item>();
    ArrayList<Fornecedor> listaFornecedores = new ArrayList<Fornecedor>();

    //Variáveis de entrada
    ArrayList<TabelaPrecos> tabelaPrecos = new ArrayList<TabelaPrecos>();
    ArrayList<TabelaAvaliacoes> avaliacoes = new ArrayList<TabelaAvaliacoes>();
    Carrinho carrinho = new Carrinho();

    //Variáveis de processamento
    ItensRelevantes itens = new ItensRelevantes();
    FornecedoresRelevantes fornecedores = new FornecedoresRelevantes();

    public ArrayList processar(Carrinho carrinho) {
        //Preenchemos a tabela itens com todas as ofertas relativas a todos os itens do carrinho
        for (TabelaPrecos entrada : tabelaPrecos) {
            if (carrinho.getCarrinho().contains(entrada.getItem())) {
                itens.getEntrada().add(entrada);
            }
        }

        //Preenchemos a tabela fornecedores com todos os fornecedores que oferecem os itens desejados
        for (TabelaPrecos entrada : itens.getEntrada()) {
            if (!fornecedores.getEntrada().contains(entrada.getFornecedor())) {
                fornecedores.getEntrada().add(entrada.getFornecedor());
            }
        }

        //Preenchemos a tabela secundaria com todas as médias necessárias para a operação
        TabelaSecundaria secundaria = new TabelaSecundaria(fornecedores.getEntrada().size(), fornecedores);
        for (Fornecedor entrada : fornecedores.getEntrada()) {
            secundaria.addTabelaAvaliacaoMedia(fornecedores.getEntrada().indexOf(entrada), mediaAvaliacao(entrada));
        }

        //Faremos todas as operações de comparação e preenchimento da tabela principal aqui
        TabelaPrimaria primaria = new TabelaPrimaria(fornecedores.getEntrada().size());
        //Lista que retornará todas as entradas finais
        ArrayList<TabelaPrecos> selecaoFinal = new ArrayList<TabelaPrecos>();
        return processar(carrinho, primaria, secundaria, selecaoFinal);
    }

    public ArrayList processar(Carrinho carrinho, TabelaPrimaria primaria, TabelaSecundaria secundaria, ArrayList<TabelaPrecos> selecaoFinal) {
        //Esse for garantirá que teremos uma entrada de cada um dos itens do carrinho
        Item entradaCarrinho = carrinho.getCarrinho().remove(0);
        //A variavel abaixo será a entra da tabela de precos que está como a melhor escolha atualmente
        TabelaPrecos itemTabela = null;
        //Esse for esta iterando por toda a tabela de precos em busca da melhor opcao
        for (TabelaPrecos entradaTabela : itens.getEntrada()) {
            if (entradaTabela.getItem().equals(entradaCarrinho)) {
                if (itemTabela == null) {
                    itemTabela = entradaTabela;
                } else {
                    //Isolamos os fornecedores a serem comparados
                    Fornecedor fornecedor1 = itens.getEntrada().get(itens.getEntrada().indexOf(itemTabela)).getFornecedor();
                    Fornecedor fornecedor2 = itens.getEntrada().get(itens.getEntrada().indexOf(entradaTabela)).getFornecedor();
                    switch (primaria.getTabela()[fornecedores.getEntrada().indexOf(fornecedor1)][fornecedores.getEntrada().indexOf(fornecedor2)]) {
                        //Essa comparação ainda não foi feita
                        case 0:
                            if (secundaria.getTabelaAvaliacaoMedia()[fornecedores.getEntrada().indexOf(fornecedor1)] > secundaria.getTabelaAvaliacaoMedia()[fornecedores.getEntrada().indexOf(fornecedor2)]) {
                                //Atual é maior
                                primaria.getTabela()[fornecedores.getEntrada().indexOf(fornecedor1)][fornecedores.getEntrada().indexOf(fornecedor2)] = 1;
                                primaria.getTabela()[fornecedores.getEntrada().indexOf(fornecedor2)][fornecedores.getEntrada().indexOf(fornecedor1)] = 2;
                            } else {
                                if (secundaria.getTabelaAvaliacaoMedia()[fornecedores.getEntrada().indexOf(fornecedor1)] < secundaria.getTabelaAvaliacaoMedia()[fornecedores.getEntrada().indexOf(fornecedor2)]) {
                                    //Novo é maior
                                    primaria.getTabela()[fornecedores.getEntrada().indexOf(fornecedor1)][fornecedores.getEntrada().indexOf(fornecedor2)] = 2;
                                    primaria.getTabela()[fornecedores.getEntrada().indexOf(fornecedor2)][fornecedores.getEntrada().indexOf(fornecedor1)] = 1;
                                    itemTabela = entradaTabela;
                                } else {
                                    //Fornecedores tem a mesma avaliação média, desempate por preço necessário
                                    int quantidade1 = 0;
                                    int quantidade2 = 0;
                                    for (Item produtosCarrinhoTemp : carrinho.getCarrinho()) {
                                        if (produtosCarrinhoTemp.equals(itens.getEntrada().get(itens.getEntrada().indexOf(itemTabela)).getItem())) {
                                            quantidade1++;
                                        }
                                        if (produtosCarrinhoTemp.equals(itens.getEntrada().get(itens.getEntrada().indexOf(entradaTabela)).getItem())) {
                                            quantidade2++;
                                        }
                                    }
                                    Float preco1 = quantidade1 * itens.getEntrada().get(itens.getEntrada().indexOf(itemTabela)).getPreco() + fornecedor1.getFrete();
                                    Float preco2 = quantidade2 * itens.getEntrada().get(itens.getEntrada().indexOf(entradaTabela)).getPreco() + fornecedor2.getFrete();
                                    if (preco1 > preco2) {
                                        itemTabela = entradaTabela;
                                    }
                                }
                            }
                            break;
                        //Essa comparação ja foi feita e o atual é maior
                        case 1:
                            //O atual já é o maior, então nada precisa ser feito
                            break;
                        //Essa comparação ja foi feita e o novo é maior
                        case 2:
                            itemTabela = entradaTabela;
                            break;
                        //Essa comparação ja foi feita e eles são iguais
                        case 3:
                            //Fornecedores tem a mesma avaliação média, desempate por preço necessário
                            int quantidade1 = 0;
                            int quantidade2 = 0;
                            for (Item produtosCarrinhoTemp : carrinho.getCarrinho()) {
                                if (produtosCarrinhoTemp.equals(itens.getEntrada().get(itens.getEntrada().indexOf(itemTabela)).getItem())) {
                                    quantidade1++;
                                }
                                if (produtosCarrinhoTemp.equals(itens.getEntrada().get(itens.getEntrada().indexOf(entradaTabela)).getItem())) {
                                    quantidade2++;
                                }
                            }
                            Float preco1 = quantidade1 * itens.getEntrada().get(itens.getEntrada().indexOf(itemTabela)).getPreco() + fornecedor1.getFrete();
                            Float preco2 = quantidade2 * itens.getEntrada().get(itens.getEntrada().indexOf(entradaTabela)).getPreco() + fornecedor2.getFrete();
                            if (preco1 > preco2) {
                                itemTabela = entradaTabela;
                            }
                            break;
                    }
                }
            }
        }
        if (carrinho.getCarrinho().size() != 0) {
            processar(carrinho, primaria, secundaria, selecaoFinal);
        }
        selecaoFinal.add(itemTabela);
        return selecaoFinal;
    }

    public float mediaAvaliacao(Fornecedor fornecedor) {
        float acumulador = 0;
        float contador = 0;
        for (TabelaAvaliacoes avaliacao : avaliacoes) {
            if (avaliacao.getFornecedor().equals(fornecedor)) {
                acumulador += avaliacao.getAvaliacao();
                contador++;
            }
        }
        return acumulador / contador;
    }

    public void mostrarResultado(ArrayList<TabelaPrecos> listaCompras) {
        System.out.println("====== Lista De Compras ======");
        System.out.println("");
        for (TabelaPrecos item : listaCompras) {
            if (item == null) {
                System.out.println("Produto indisponível");
            } else {
                System.out.println("Item: " + item.getItem().getNome() + " || Fornecedor: " + item.getFornecedor().getNome() + " || Preço: " + item.getPreco() + " || Frete: " + item.getFornecedor().getFrete());
            }
        }
    }
}
