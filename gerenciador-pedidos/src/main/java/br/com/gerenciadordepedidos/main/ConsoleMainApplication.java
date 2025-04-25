package br.com.gerenciadordepedidos.main;

import br.com.gerenciadordepedidos.model.Categoria;
import br.com.gerenciadordepedidos.model.Pedido;
import br.com.gerenciadordepedidos.model.Produto;

import java.util.Scanner;

public class ConsoleMainApplication {
    private Scanner scanner;
    private Categoria categoria;
    private Produto produto;
    private Pedido pedido;

    public void exibeMenu() {
        try {
            scanner = new Scanner(System.in);
            int opcao = -1;
            while (opcao != 0) {
                var menu = """
                        ***************************
                        *         OPÇÕES          *
                        ***************************
                          > 1. Inserir Produto
                          > 2. Inserir Categoria
                          > 3. Finalizar Pedido
                        
                          > 0. Sair
                        ***************************
                        
                          > 
                        """;

                System.out.println(menu);
                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        inserirProduto();
                        break;
                    case 2:
                        inserirCategoria();
                        break;
                    case 3:
                        visualizarPedidos();
                        break;
                    case 0:
                        System.out.println("Obrigado por nos escolher! Volte sempre.");
                        break;
                    default:
                        break;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro na comunicação com o usuário!");
        }
    }

    public void inserirProduto() {

    }

    public void inserirCategoria() {

    }

    public void visualizarPedidos() {

    }
}
