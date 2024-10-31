package br.edu.famper.getrestaurante.Repository;

import br.edu.famper.getrestaurante.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
