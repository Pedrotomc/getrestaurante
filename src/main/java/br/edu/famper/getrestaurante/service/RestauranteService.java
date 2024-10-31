package br.edu.famper.getrestaurante.service;


import br.edu.famper.getrestaurante.Repository.RestauranteRepository;
import br.edu.famper.getrestaurante.model.Restaurante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class RestauranteService {
  @Autowired
  private br.edu.famper.getrestaurante.Repository.RestauranteRepository restauranteRepository;

  @GetMapping
  public Restaurante salvar(Restaurante restaurante) {
      return restauranteRepository.save(restaurante);
  }

  public List<Restaurante> buscarTodos() {
      return restauranteRepository.findAll();
  }

  public Optional<Restaurante> findById(Long id) {
      return restauranteRepository.findById(id);
  }

  public void deleteById(Long id) {
      restauranteRepository.deleteById(id);
  }
}
