package br.com.gerenciadordepedidos.main;

import br.com.gerenciadordepedidos.model.Categoria;
import br.com.gerenciadordepedidos.model.Pedido;
import br.com.gerenciadordepedidos.model.Produto;
import br.com.gerenciadordepedidos.repository.CategoriaRepository;
import br.com.gerenciadordepedidos.repository.PedidosRepository;
import br.com.gerenciadordepedidos.repository.ProdutoRepository;

import java.util.List;
import java.util.Scanner;

public class ConsoleMainApplication {
    private Scanner scanner;
    private Categoria categoria;
    private Produto produto;
    private Pedido pedido;

    private ProdutoRepository produtoRepository;
    private CategoriaRepository categoriaRepository;
    private PedidosRepository pedidosRepository;

    public ConsoleMainApplication(ProdutoRepository produtoRepository, CategoriaRepository categoriaRepository, PedidosRepository pedidosRepository) {
        this.produtoRepository = produtoRepository;
        this.categoriaRepository = categoriaRepository;
        this.pedidosRepository = pedidosRepository;
    }

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
        System.out.print("Digite o produto que deseja inserir: ");
        produto.setNome(scanner.nextLine());
        System.out.print("Digite o preço do produto: ");
        produto.setPreco(scanner.nextDouble());
        var mostrarProduto = "Produto: " + produto.getNome() + "\nPreço: " + produto.getPreco();
        System.out.println(mostrarProduto);

        produto = new Produto(produto.getId(),produto.getNome(), produto.getPreco());
        produtoRepository.save(produto);
    }

    public void inserirCategoria() {
        System.out.print("Digite a categoria que deseja inserir: ");
        categoria.setNome(scanner.nextLine());
        var mostrarCategoria = "Categoria: " + categoria.getNome();
        System.out.println(mostrarCategoria);

        categoria = new Categoria(categoria.getId(), categoria.getNome());
        categoriaRepository.save(categoria);
    }

    public void visualizarPedidos() {
        pedidosRepository.save()
    }
}
