package br.edu.famper.getrestaurante.service;


import br.edu.famper.getrestaurante.model.Garcom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class GarcomService {
    @Autowired
    private br.edu.famper.getrestaurante.Repository.GarcomRepository garcomRepository;

    @GetMapping
    public Garcom salvar(Garcom garcom) {
        return garcomRepository.save(garcom);
    }

        public List<Garcom> buscarTodos() {
        return garcomRepository.findAll();
    }

    public Optional<Garcom> findById(Long id) {
        return garcomRepository.findById(id);
    }

    public void deleteById(Long id) {
        garcomRepository.deleteById(id);
    }
}
