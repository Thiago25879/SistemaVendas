package sistemavendas;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ArquivoEntrada {

    //Função que carrega o arquivo, formata e insere no programa
    public Principal CarregarArquivo(Principal menu) {
        String entrada = null;
        String[] linhas;
        try {
            entrada = (readFile("Input.csv", StandardCharsets.UTF_8));
        } catch (IOException ex) {
            System.out.println("Arquivo inválido");
        }
        //Quebramos o csv por linha e guardamos na variavel linhas
        linhas = entrada.split("\n");
        //Iteramos por linha a linha do csv
        for (int x = 0; x < 9; x++) {
            //Limpamos um pouco de lixo das linhas
            linhas[x] = linhas[x].replace(";;", "");
            linhas[x] = linhas[x].replace("\r", "");
            //Removemos a primeira coluna
            linhas[x] = linhas[x].substring(linhas[x].indexOf(";")+1);
            //Para cada linha ou conjunto de linhas damos tratamentos diferentes
            switch (x) {
                case 0:
                    for (String item : linhas[0].split(";")) {
                        menu.listaItems.add(new Item(item));
                    }
                    break;
                case 2:
                    for (int i = 0; i < linhas[2].split(";").length; i++) {
                        menu.listaFornecedores.add(new Fornecedor(linhas[1].split(";")[i], Float.valueOf(linhas[2].split(";")[i])));
                    }
                    break;
                case 4:
                    for (int i = 0; i < linhas[4].split(";").length; i++) {
                        menu.avaliacoes.add(new TabelaAvaliacoes(menu.listaFornecedores.get(Integer.parseInt(linhas[3].split(";")[i])), Integer.parseInt(linhas[4].split(";")[i])));
                    }
                    break;
                case 7:
                    for (int i = 0; i < linhas[7].split(";").length; i++) {
                        menu.tabelaPrecos.add(new TabelaPrecos(menu.listaFornecedores.get(Integer.parseInt(linhas[5].split(";")[i])), menu.listaItems.get(Integer.parseInt(linhas[6].split(";")[i])), Float.valueOf(linhas[7].split(";")[i])));
                    }
                    break;
                case 8:
                    for (int i = 0; i < linhas[8].split(";").length; i++) {
                        menu.carrinho.addItem(menu.listaItems.get(Integer.parseInt(linhas[8].split(";")[i])));
                    }
                    break;
            }
        }
        return menu;
    }

    //Função para ler o arquivo
    String readFile(String path, Charset encoding)
            throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }
}
