package br.com.gerenciadordepedidos.main;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GerenciadorDePedidosApplication implements CommandLineRunner {

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
			throw new RuntimeException("Erro de comunicação!");
		}
	}
}
