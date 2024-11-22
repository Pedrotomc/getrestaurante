package br.edu.famper.getrestaurante.controller;

import br.edu.famper.getrestaurante.dto.RestauranteDto;
import br.edu.famper.getrestaurante.exeption.ResourceNotFoundException;
import br.edu.famper.getrestaurante.model.Restaurante;
import br.edu.famper.getrestaurante.service.RestauranteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.HTMLEditorKit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api/restaurante")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Restaurante",
        description = "Operation for Restaurant")
public class RestauranteController {
    private final RestauranteService restauranteService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get all restaurant from DB",
            description = "Fetches all restaurant from DB and return " +
                    "in JSON Array"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful"),
            @ApiResponse(responseCode = "404", description = "not found")
    })
    public List<RestauranteDto> getAllRestaurante() {
        log.info("Buscando restaurante");
        return restauranteService.getAllRestaurante();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get one restaurant from DB",
            description = "Fetches one restaurant from DB and return " +
                    "in JSON Object"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful"),
            @ApiResponse(responseCode = "404", description = "not fund")
    })
    public ResponseEntity<RestauranteDto> getRestauranteById(@PathVariable(name = "id") Long id) throws ResourceNotFoundException {
        log.info("Buscando restaurante por id: {}", id);
        return (ResponseEntity<RestauranteDto>) restauranteService.getAllRestaurante();
    }
    @PostMapping
    @Operation(summary = "Save restaurant",
            description = "Save a restaurant in database"
    )
    public Restaurante createRestaurante(@RequestBody RestauranteDto restauranteDto) throws ResourceNotFoundException {
        log.info("Cadastro cliente: {}", restauranteDto);
        return restauranteService.saveRestaurante(restauranteDto);
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Update restaurant",
            description = "Update a restaurant in database"
    )
    public ResponseEntity<RestauranteDto> updateRestaurante(@PathVariable(name = "id") Long id, @RequestBody RestauranteDto restauranteDto) throws ResourceNotFoundException {
        log.info("Atualizando cliene: {}", restauranteDto);
        return ResponseEntity.ok(restauranteService.editRestaurante(id, restauranteDto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remove restaurant",
            description = "Remove a restaurant in database"
    )
    public Map<String, Boolean> deleteRestaurante(@PathVariable(name = "id") Long id) throws Exception {
        log.info("Deletando Restaurante: {}", id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", restauranteService.deleteRestaurante(id));
        return response;
    }
}
