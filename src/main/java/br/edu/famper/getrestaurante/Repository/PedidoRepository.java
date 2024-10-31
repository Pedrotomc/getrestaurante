package br.edu.famper.getrestaurante.Repository;

import br.edu.famper.getrestaurante.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
