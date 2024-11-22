package br.edu.famper.getrestaurante.controller;

import br.edu.famper.getrestaurante.dto.MesaDto;
import br.edu.famper.getrestaurante.exeption.ResourceNotFoundException;
import br.edu.famper.getrestaurante.model.Mesa;
import br.edu.famper.getrestaurante.service.MesaService;
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
@RequestMapping("api/mesa")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Mesa",
        description = "Operation for table")
public class MesaController {
    private final MesaService mesaService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get all table from DB",
            description = "Fetches all table from DB and return " +
                    "in JSON Array"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful"),
            @ApiResponse(responseCode = "404", description = "not found")
    })
    public List<MesaDto> getAllMesa() {
        log.info("Buscando Mesa");
        return mesaService.getAllMesa();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get one table from DB",
            description = "Fetches one table from DB and return " +
                    "in JSON Object"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful"),
            @ApiResponse(responseCode = "404", description = "not fund")
    })
    public ResponseEntity<MesaDto> getMesaById(@PathVariable(name = "id") Long id) throws ResourceNotFoundException {
        log.info("Buscando mesa por id: {}", id);
        return (ResponseEntity<MesaDto>) mesaService.getAllMesa();
    }
    @PostMapping
    @Operation(summary = "Save table",
            description = "Save a table in database"
    )
    public Mesa createMesa(@RequestBody MesaDto mesaDto) throws ResourceNotFoundException {
        log.info("Cadastro mesa: {}", mesaDto);
        return mesaService.saveMesa(mesaDto);
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Update table",
            description = "Update a table in database"
    )
    public ResponseEntity<MesaDto> updateMesa(@PathVariable(name = "id") Long id, @RequestBody MesaDto mesaDto) throws ResourceNotFoundException {
        log.info("Atualizando mesa: {}", mesaDto);
        return ResponseEntity.ok(mesaService.editMesa(id, mesaDto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remove table",
            description = "Remove a table in database"
    )
    public Map<String, Boolean> deleteMesa(@PathVariable(name = "id") Long id) throws Exception {
        log.info("Deletando mesa: {}", id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", mesaService.deleteMesa(id));
        return response;
    }
}
