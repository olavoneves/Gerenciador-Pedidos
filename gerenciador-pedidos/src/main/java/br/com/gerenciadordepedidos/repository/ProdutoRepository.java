package br.com.gerenciadordepedidos.repository;

import br.com.gerenciadordepedidos.model.Categoria;
import br.com.gerenciadordepedidos.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    List<Produto> findByCategoriaContainingIgnoreCase(Categoria categoria);

    List<Produto> findTop10ByOrderByPrecoDesc(List<Produto> listaProduto);

    List<Produto> findTop10ByOrderByPreco(List<Produto> listaProduto);

    List<Produto> findByNomeContainingIgnoreCase(String nomeProduto);

    List<Produto> findByCategoriaContainingIgnoreCaseAndByOrderByPreco(Categoria categoria);

    List<Produto> findByCategoriaContainingIgnoreCaseAndByOrderByPrecoDesc(Categoria categoria);
}
