package br.edu.famper.getrestaurante.Repository;

import br.edu.famper.getrestaurante.model.Mesa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MesaRepository extends JpaRepository<Mesa, Long> {
}
