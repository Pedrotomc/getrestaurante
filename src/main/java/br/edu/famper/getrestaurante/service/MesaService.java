package br.edu.famper.getrestaurante.service;

import br.edu.famper.getrestaurante.model.Mesa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class MesaService {
    @Autowired
    private br.edu.famper.getrestaurante.Repository.MesaRepository mesaRepository;

    @GetMapping
    public Mesa salvar(Mesa mesa) {
        return mesaRepository.save(mesa);
    }

    public List<Mesa> buscarTodos() {
        return mesaRepository.findAll();
    }

    public Optional<Mesa> findById(Long id) {
        return mesaRepository.findById(id);
    }

    public void deleteById(Long id) {
        mesaRepository.deleteById(id);
    }
}
