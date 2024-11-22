package br.edu.famper.getrestaurante.controller;

import br.edu.famper.getrestaurante.dto.GarcomDto;
import br.edu.famper.getrestaurante.exeption.ResourceNotFoundException;
import br.edu.famper.getrestaurante.model.Garcom;
import br.edu.famper.getrestaurante.service.GarcomService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/garcom")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Garcom",
        description = "Operation for Garcom")
public class GarcomController {
    private final GarcomService garcomService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get all cities from DB",
            description = "Fetches all cities from DB and return " +
                    "in JSON Array"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful"),
            @ApiResponse(responseCode = "404", description = "not found")
    })
    public List<GarcomDto> getAllGarcom() {
        log.info("Buscando clientes");
        return garcomService.getAllGarcom();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get one city from DB",
            description = "Fetches one city from DB and return " +
                    "in JSON Object"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful"),
            @ApiResponse(responseCode = "404", description = "not fund")
    })
    public ResponseEntity<GarcomDto> getGarcomById(@PathVariable(name = "id") Long id) throws ResourceNotFoundException {
        log.info("Buscando cidade por id: {}", id);
        return (ResponseEntity<GarcomDto>) garcomService.getAllGarcom();
    }
    @PostMapping
    @Operation(summary = "Save city",
            description = "Save a city in database"
    )
    public Garcom createGarcom(@RequestBody GarcomDto garcomDto) throws ResourceNotFoundException {
        log.info("Cadastro cidade: {}", garcomDto);
        return garcomService.saveGarcom(garcomDto);
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Update city",
            description = "Update a city in database"
    )
    public ResponseEntity<GarcomDto> updateGarcom(@PathVariable(name = "id") Long id, @RequestBody GarcomDto garcomDto) throws ResourceNotFoundException {
        log.info("Atualizando cidade: {}", garcomDto);
        return ResponseEntity.ok(garcomService.editGarcom(id, garcomDto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remove city",
            description = "Remove a city in database"
    )
    public Map<String, Boolean> deleteGarcom(@PathVariable(name = "id") Long id) throws Exception {
        log.info("Deletando cidade: {}", id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", garcomService.deleteGarcom(id));
        return response;
    }
}
