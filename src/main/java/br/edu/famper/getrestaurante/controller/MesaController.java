package br.edu.famper.getrestaurante.controller;

import br.edu.famper.getrestaurante.model.Mesa;
import br.edu.famper.getrestaurante.service.MesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/mesa")
public class MesaController {
    @Autowired
    private MesaService mesaService;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Mesa>> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(mesaService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Mesa> create(@RequestBody Mesa mesa){
        return ResponseEntity.status(HttpStatus.CREATED).body(mesaService.salvar(mesa));
    }

    @PutMapping
    public ResponseEntity<Mesa> update(@RequestBody Mesa mesa){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(mesaService.salvar(mesa));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        mesaService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
