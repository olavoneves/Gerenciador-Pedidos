package br.com.gerenciadordepedidos.repository;

import br.com.gerenciadordepedidos.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidosRepository extends JpaRepository<Pedido, Long> {

}
