package br.com.gerenciadordepedidos.repository;

import br.com.gerenciadordepedidos.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
