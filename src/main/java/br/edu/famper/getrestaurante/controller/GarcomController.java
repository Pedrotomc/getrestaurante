package br.edu.famper.getrestaurante.controller;

import br.edu.famper.getrestaurante.model.Garcom;
import br.edu.famper.getrestaurante.service.GarcomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/garcom")
public class GarcomController {
    @Autowired
        private GarcomService garcomService;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Garcom>> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(garcomService.findById(id));
    }

    @PostMapping
        public ResponseEntity<Garcom> create(@RequestBody Garcom garcom){
        return ResponseEntity.status(HttpStatus.CREATED).body(garcomService.salvar(garcom));
    }

    @PutMapping
    public ResponseEntity<Garcom> update(@RequestBody Garcom garcom){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(garcomService.salvar(garcom));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        garcomService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
