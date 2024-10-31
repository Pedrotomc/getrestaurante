package br.edu.famper.getrestaurante.Repository;

import br.edu.famper.getrestaurante.model.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {

}
