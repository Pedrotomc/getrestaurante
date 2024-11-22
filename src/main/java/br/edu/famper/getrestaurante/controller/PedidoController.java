package br.edu.famper.getrestaurante.controller;

import br.edu.famper.getrestaurante.dto.PedidoDto;
import br.edu.famper.getrestaurante.exeption.ResourceNotFoundException;
import br.edu.famper.getrestaurante.model.Pedido;
import br.edu.famper.getrestaurante.service.PedidoService;
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
@RequestMapping("api/pedido")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Pedido",
        description = "Operation for pedido")
public class PedidoController {
    private final PedidoService pedidoService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get all order from DB",
            description = "Fetches all order from DB and return " +
                    "in JSON Array"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful"),
            @ApiResponse(responseCode = "404", description = "not found")
    })
    public List<PedidoDto> getAllPedido() {
        log.info("Buscando Pedidos");
        return pedidoService.getAllPedido();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get one order from DB",
            description = "Fetches one order from DB and return " +
                    "in JSON Object"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful"),
            @ApiResponse(responseCode = "404", description = "not fund")
    })
    public ResponseEntity<PedidoDto> getPedidoById(@PathVariable(name = "id") Long id) throws ResourceNotFoundException {
        log.info("Buscando pedido por id: {}", id);
        return (ResponseEntity<PedidoDto>) pedidoService.getAllPedido();
    }
    @PostMapping
    @Operation(summary = "Save order",
            description = "Save a order in database"
    )
    public Pedido createPedido(@RequestBody PedidoDto pedidoDto) throws ResourceNotFoundException {
        log.info("Cadastro cliente: {}", pedidoDto);
        return pedidoService.savePedido(pedidoDto);
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Update order",
            description = "Update a order in database"
    )
    public ResponseEntity<PedidoDto> updatePedido(@PathVariable(name = "id") Long id, @RequestBody PedidoDto pedidoDto) throws ResourceNotFoundException {
        log.info("Atualizando pedido: {}", pedidoDto);
        return ResponseEntity.ok(pedidoService.editPedido(id, pedidoDto));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remove order",
            description = "Remove a order in database"
    )
    public Map<String, Boolean> deletePedido(@PathVariable(name = "id") Long id) throws Exception {
        log.info("Deletando pedido: {}", id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", pedidoService.deletePedido(id));
        return response;
    }
}
