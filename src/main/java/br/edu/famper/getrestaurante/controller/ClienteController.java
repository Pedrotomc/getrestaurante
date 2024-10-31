package br.edu.famper.getrestaurante.controller;


import br.edu.famper.getrestaurante.model.Cliente;
import br.edu.famper.getrestaurante.model.Restaurante;
import br.edu.famper.getrestaurante.service.ClienteService;
import br.edu.famper.getrestaurante.service.RestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/cliente")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Cliente>> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Cliente> create(@RequestBody Cliente cliente){
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.salvar(cliente));
    }

    @PutMapping
    public ResponseEntity<Cliente> update(@RequestBody Cliente cliente){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(clienteService.salvar(cliente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        clienteService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
