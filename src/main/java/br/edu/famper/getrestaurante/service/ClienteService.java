package br.edu.famper.getrestaurante.service;


import br.edu.famper.getrestaurante.Repository.ClienteRepository;
import br.edu.famper.getrestaurante.model.Cliente;
import br.edu.famper.getrestaurante.model.Restaurante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private br.edu.famper.getrestaurante.Repository.RestauranteRepository restauranteRepository;
    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public Cliente salvar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public List<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> findById(Long id) {
        return clienteRepository.findById(id);
    }

    public void deleteById(Long id) {
        clienteRepository.deleteById(id);
    }
}
