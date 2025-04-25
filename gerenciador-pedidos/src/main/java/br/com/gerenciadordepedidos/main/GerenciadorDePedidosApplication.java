package br.com.gerenciadordepedidos.main;

import br.com.gerenciadordepedidos.repository.CategoriaRepository;
import br.com.gerenciadordepedidos.repository.PedidosRepository;
import br.com.gerenciadordepedidos.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GerenciadorDePedidosApplication implements CommandLineRunner {
    @Autowired
    private PedidosRepository pedidosRepository;
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;

	public static void main(String[] args) {
		SpringApplication.run(GerenciadorDePedidosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ConsoleMainApplication console;
		try {
			console = new ConsoleMainApplication();
			console.exibeMenu();
		} catch (Exception e) {
			throw new RuntimeException("Erro do método que exibi o menu!");
		}
	}
}
