package sistemavendas;

import java.util.ArrayList;
import java.util.Scanner;

public class SistemaVendas {

    public static void main(String[] args) {
        //Variáveis de funcionamento
        Scanner scan = new Scanner(System.in);
        
        Principal menu = new Principal ();
        
        ArquivoEntrada arquivo = new ArquivoEntrada();
        
        menu = arquivo.CarregarArquivo(menu);
        
        ArrayList<TabelaPrecos> selecaoFinal =  menu.processar(menu.carrinho);
        menu.mostrarResultado(selecaoFinal);
    }
    
    
}
