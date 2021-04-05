package sistemavendas;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    /*Scanner scan = new Scanner(System.in);
    
    ArrayList<TabelaPrecos> mercado = new ArrayList();
    ArrayList<String> carrinho = new ArrayList();

    ArrayList<ItensRelevantes> selecao = new ArrayList();
    ArrayList<TabelaPrecos> melhor_avaliados = new ArrayList();

    
    String set_1 = "---";

    public Menu() {
        int set_0 = 0;
        while (set_0 != 5) {
            //Interação com usuario
            System.out.print("|Sistema de Vendas|\n\nDigite |1| para cadastrar novo Fornecedor/Item/Preco;\nDigite |2| para avaliar um fornecedor;\nDigite |3| para criar um carrinho de compras. \nDigite |4| para receber sugestão de fornecedores melhor avaliados.\nDigite |5| para encerrar o sistema;\n\n Sua escolha: ");
            set_0 = scan.nextInt();

            switch (set_0) {
                case 1: {
                    System.out.println("Informe o nome do fornecedor: ");
                    Fornecedor fornecedor = new Fornecedor();
                    fornecedor.nome = scan.next();
                    System.out.println("Informe o nome do item: ");
                    String item = scan.next();
                    System.out.println("Informe o preco do item: ");
                    float preco = scan.nextFloat();
                    mercado.add(new TabelaPrecos(fornecedor, item, preco));
                }
                break;

                case 2: {
                    for (int x = 0; x < mercado.size(); x++) {
                        System.out.println("Fornecedor: " + mercado.get(x).fornecedor.nome + "  ID: " + x);
                    }
                    System.out.print("Digite o id do fornecedor que deseja avaliar: ");
                    int id = scan.nextInt();
                    System.out.print("\nDigite uma avaliacao (1, 2, 3, 4, 5) para este fornecedor: ");
                    mercado.get(id).fornecedor.avaliacoes.add(scan.nextInt());
                }
                break;

                case 3: {
                    while (!set_1.equals("@")) {
                        System.out.print("\nDigite o nome do produto que deseja para que seja adicionado ao carrinho (para finalizar a lista de compras digite \"@\"): ");
                        set_1 = scan.next();
                        if (!set_1.equals("@")) {
                            carrinho.add(set_1);
                        }
                    }
                }
                break;

                case 4: {
                    for (int x = 0; x < carrinho.size(); x++) {
                        selecao.clear();
                        for (int y = 0; y < mercado.size(); y++) {
                            if (carrinho.get(x).contains(mercado.get(y).item)) {
                                selecao.add(new ItensRelevantes(mercado.get(y)));
                            }
                        }
                        //
                        aux_0 = aux_1 = 0;
                        melhor_avaliados.add(melhor_item(selecao));
                    }
                }
                break;

                case 5: {

                }
                break;

                default:
                    System.out.println("O sistema nao reconhece este valor!");
                    break;
            }
        }

        scan.close();
    }

    int aux_0 = 0, aux_1 = 1;

    public TabelaPrecos melhor_item(ArrayList parametro) {
        ArrayList<ItensRelevantes> selecao = (ArrayList) parametro;
        if (selecao.size() > 1) {
            if (selecao.get(aux_0).avaliacao_media > selecao.get(aux_1).avaliacao_media) {
                if (selecao.get(aux_1 + 1) != null) {
                    aux_1++;
                    melhor_item(selecao);
                } else {
                    return selecao.get(aux_0).dados;
                }
            } else {
                if (selecao.get(aux_1 + 1) != null) {
                    aux_0 = aux_1;
                    aux_1++;
                    melhor_item(selecao);
                } else {
                    return selecao.get(aux_1).dados;
                }
            }
        } else {
            return (selecao.get(aux_0).dados);
        }
        return null;
    }*/
}
