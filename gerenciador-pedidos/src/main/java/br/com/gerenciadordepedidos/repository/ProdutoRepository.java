package br.com.gerenciadordepedidos.repository;

import br.com.gerenciadordepedidos.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
