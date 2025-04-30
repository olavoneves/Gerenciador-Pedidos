package br.com.gerenciadordepedidos.main;

import br.com.gerenciadordepedidos.model.Categoria;
import br.com.gerenciadordepedidos.model.Pedido;
import br.com.gerenciadordepedidos.model.Produto;
import br.com.gerenciadordepedidos.repository.CategoriaRepository;
import br.com.gerenciadordepedidos.repository.PedidosRepository;
import br.com.gerenciadordepedidos.repository.ProdutoRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class ConsoleMainApplication {
    private Scanner scanner;
    private Categoria categoria = new Categoria();
    private List<Categoria> listaCategoria = new ArrayList<>();
    private Produto produto = new Produto();
    private List<Produto> listaProduto = new ArrayList<>();
    private Pedido pedido;
    private List<Pedido> listaPedidos = new ArrayList<>();

    private final ProdutoRepository produtoRepository;
    private final CategoriaRepository categoriaRepository;
    private final PedidosRepository pedidosRepository;

    public ConsoleMainApplication(ProdutoRepository produtoRepository, CategoriaRepository categoriaRepository, PedidosRepository pedidosRepository) {
        this.produtoRepository = produtoRepository;
        this.categoriaRepository = categoriaRepository;
        this.pedidosRepository = pedidosRepository;
    }

    public void exibeMenu() {
        try {
            scanner = new Scanner(System.in);
            int opcao = -1;
            while (opcao != 19) {
                var menu = """
                        *****************************************************
                        *                      OPÇÕES                       *
                        *****************************************************
                          > 1. Inserir Produto
                          > 2. Inserir Categoria
                          > 3. Ver Produtos
                          > 4. Produtos e Categoria
                          > 5. Produtos mais caros
                          > 6. Produtos mais baratos
                          > 7. Produtos específicos
                          > 8. Pedidos sem data de entrega
                          > 9. Pedidos com data de entrega
                          > 10.Produtos por categoria crescente
                          > 11.Produtos por categoria decrescente
                          > 12.Quantidade de produtos por categoria
                          > 13.Quantidade de produtos mais caros
                          > 14.Pedidos depois da data
                          > 15.Pedidos antes da data
                          > 16.Pedidos em um período de data
                          > 17.Top 03 pedidos mais caros
                          > 18.Top 05 pedidos mais baratos por categoria
                          > 19. Finalizar Pedido
                        
                          > 0. Sair
                        *****************************************************
                        """;

                System.out.print(menu + "\n > ");
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
                        visualizarProdutos();
                        break;
                    case 4:
                        visualizarProdutosComCategoria();
                        break;
                    case 5:
                        produtosMaisCaros();
                        break;
                    case 6:
                        produtosMaisBaratos();
                        break;
                    case 7:
                        produtosEspecificos();
                        break;
                    case 8:
                        pedidosSemDataEntrega();
                        break;
                    case 9:
                        pedidosComDataEntrega();
                        break;
                    case 10:
                        produtosPorCategoriaCres();
                        break;
                    case 11:
                        produtosPorCategoriaDesc();
                        break;
                    case 12:
                        quantidadeProdutosPorCategoria();
                        break;
                    case 13:
                        quantidadeProdutosMaisCaros();
                        break;
                    case 14:
                        pedidosDepoisDaData();
                        break;
                    case 15:
                        pedidosAntesDaData();
                        break;
                    case 16:
                        pedidosPorPeriodoDeData();
                        break;
                    case 17:
                        topTresPedidosMaisCaros();
                        break;
                    case 18:
                        topCincoPedidosMaisBaratosComCategoria();
                        break;
                    case 19:
                        finalizarPedidos();
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
        scanner.nextLine();

        listaProduto.add(produto);
        produtoRepository.save(produto);

        System.out.println("Produto Inserido!");
    }

    public void inserirCategoria() {
        System.out.print("Digite a categoria que deseja inserir: ");
        categoria.setNome(scanner.nextLine());

        listaCategoria.add(categoria);
        categoriaRepository.save(categoria);

        System.out.println("Categoria Inserida!");
    }

    public void visualizarProdutos() {
        listaProduto.forEach(System.out::println);
    }

    private void visualizarProdutosComCategoria() {
        listaProduto = produtoRepository.findByCategoriaContainingIgnoreCase(categoria);
        listaProduto.forEach(System.out::println);
    }

    public void produtosMaisCaros() {
        listaProduto = produtoRepository.findTop10ByOrderByPrecoDesc(listaProduto);
        listaProduto.forEach(System.out::println);
    }

    public void produtosMaisBaratos() {
        listaProduto = produtoRepository.findTop10ByOrderByPreco(listaProduto);
        listaProduto.forEach(System.out::println);
    }

    public void produtosEspecificos() {
        System.out.print("Digite o produto: ");
        produto.setNome(scanner.nextLine());

        listaProduto = produtoRepository.findByNomeContainingIgnoreCase(produto.getNome());
        listaProduto.forEach(System.out::println);
    }

    public void pedidosSemDataEntrega() {

    }

    public void pedidosComDataEntrega() {

    }

    public void produtosPorCategoriaCres() {
        listaProduto = produtoRepository.findByCategoriaOrderByPrecoAsc(categoria);
        listaProduto.forEach(System.out::println);
    }

    public void produtosPorCategoriaDesc() {
        listaProduto = produtoRepository.findByCategoriaOrderByPrecoDesc(categoria);
        listaProduto.forEach(System.out::println);
    }

    public void quantidadeProdutosPorCategoria() {

    }

    public void quantidadeProdutosMaisCaros() {

    }

    public void pedidosDepoisDaData() {

    }

    public void pedidosAntesDaData() {

    }

    public void pedidosPorPeriodoDeData() {

    }

    public void topTresPedidosMaisCaros() {

    }

    public void topCincoPedidosMaisBaratosComCategoria() {

    }

    public void finalizarPedidos() {

    }
}
