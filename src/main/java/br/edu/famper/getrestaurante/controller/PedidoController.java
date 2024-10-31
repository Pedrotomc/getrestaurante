package br.edu.famper.getrestaurante.controller;

import br.edu.famper.getrestaurante.model.Pedido;
import br.edu.famper.getrestaurante.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/pedido")
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Pedido>> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(pedidoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Pedido> create(@RequestBody Pedido pedido){
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoService.salvar(pedido));
    }

    @PutMapping
    public ResponseEntity<Pedido> update(@RequestBody Pedido pedido){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(pedidoService.salvar(pedido));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        pedidoService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
