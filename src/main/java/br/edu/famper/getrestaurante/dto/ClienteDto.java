package br.edu.famper.getrestaurante.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClienteDto {

    @Schema(description = "ID DO CLIENTE",
            example = "1",
            title = "ID")
    private Long id;

    @Schema(description = "NOME DO CLIENTE",
            example = "Ampere",
            title = "NOME",
            maxLength = 150)
    private String nome;


    @Schema(description = "TELEFONE DO CLIENTE",
            example = "+55 45 99999-8888",
            title = "TELEFONE",
            maxLength = 15)
    private String telefone;


    @Schema(description = "PEDIDO DO CLIENTE",
            example = "Pedido #12345",
            title = "PEDIDO",
            maxLength = 100)
    private String pedido;
}
