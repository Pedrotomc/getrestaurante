package br.edu.famper.getrestaurante.controller;

import br.edu.famper.getrestaurante.dto.ClienteDto;
import br.edu.famper.getrestaurante.exeption.ResourceNotFountException;
import br.edu.famper.getrestaurante.model.Cliente;
import br.edu.famper.getrestaurante.service.ClienteService;
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
import java.util.Optional;

@RestController
@RequestMapping("api/cliente")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Cliente",
        description = "Operation for clientes")
public class ClienteController {

    private final ClienteService clientService;

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
public List<ClienteDto> getAllCliente() {
    log.info("Buscando clientes");
    return clientService.getAllCliente();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get one customer from DB",
            description = "Fetches one customer from DB and return " +
                    "in JSON Object"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful"),
            @ApiResponse(responseCode = "404", description = "not fund")
    })
    public ResponseEntity<ClienteDto> getClienteById(@PathVariable(name = "id") Long id) throws ResourceNotFountException {
        log.info("Buscando cliente por id: {}", id);
        return (ResponseEntity<ClienteDto>) clientService.getAllCliente();
    }
    @PostMapping
    @Operation(summary = "Save customer",
            description = "Save a customer in database"
    )
    public Cliente createCliente(@RequestBody ClienteDto clienteDto) throws ResourceNotFountException {
        log.info("Cadastro cliente: {}", clienteDto);
        return clientService.saveCliente(clienteDto);
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Update customer",
            description = "Update a customer in database"
    )
    public ResponseEntity<ClienteDto> updateCliente(@PathVariable(name = "id") Long id, @RequestBody ClienteDto clienteDto) throws ResourceNotFountException {
        log.info("Atualizando cliene: {}", clienteDto);
        return ResponseEntity.ok(clientService.editCliente(id, clienteDto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remove customer",
            description = "Remove a customer in database"
    )
    public Map<String, Boolean> deleteCliente(@PathVariable(name = "id") Long id) throws Exception {
        log.info("Deletando cliente: {}", id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", clientService.deleteCliente(id));
        return response;
    }
}
