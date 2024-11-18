package br.edu.famper.getrestaurante.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PedidoDto {
    @Schema(description = "ID DO PEDIDO",
            example = "999999",
            title = "ID")
    private Long id;

    @Schema(description = "HORA DO PEDIDO ",
            example = "00:00",
            title = "HORA",
            maxLength = 150)
    private String hora;


    @Schema(description = "OBSERVACAO DO PEDIDO",
            example = "TEXTO DE EXEMPLO",
            title = "OBSERVACAO",
            maxLength = 15)
    private String observacao;

    @Schema(description = "PRATOS DO PEDIDO",
            example = "PRATO DE FRIOS",
            title = "PRATOS",
            maxLength = 100)
    private String pratos;

    @Schema(description = "CLIENTE DO PEDIDO",
            example = "NOME DO CLIENTE",
            title = "CLIENTE",
            maxLength = 100)
    private String cliente;

    @Schema(description = "MESA DO PEDIDO",
            example = "NUMERO DA MESA",
            title = "MESA",
            maxLength = 100)
    private String mesa;
}
