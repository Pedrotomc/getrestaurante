package br.edu.famper.getrestaurante.service;

import br.edu.famper.getrestaurante.model.Pedido;
import br.edu.famper.getrestaurante.model.Restaurante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {
    @Autowired
    private br.edu.famper.getrestaurante.Repository.PedidoRepository pedidoRepository;

    @GetMapping
    public Pedido salvar(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    public List<Pedido> buscarTodos() {
        return pedidoRepository.findAll();
    }

    public Optional<Pedido> findById(Long id) {
        return pedidoRepository.findById(id);
    }

    public void deleteById(Long id) {
        pedidoRepository.deleteById(id);
    }
}
