package br.edu.famper.getrestaurante.controller;

import br.edu.famper.getrestaurante.model.Restaurante;
import br.edu.famper.getrestaurante.service.RestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.HTMLEditorKit;
import java.util.Optional;

@RestController
@RequestMapping("api/restaurante")
public class RestauranteController {
    @Autowired
    private RestauranteService restauranteService;

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Restaurante>> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(restauranteService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Restaurante> create(@RequestBody Restaurante restaurante){
        return ResponseEntity.status(HttpStatus.CREATED).body(restauranteService.salvar(restaurante));
    }

    @PutMapping
    public ResponseEntity<Restaurante> update(@RequestBody Restaurante restaurante){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(restauranteService.salvar(restaurante));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        restauranteService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
