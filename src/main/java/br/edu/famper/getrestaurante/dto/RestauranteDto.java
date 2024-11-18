package br.edu.famper.getrestaurante.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RestauranteDto {
    @Schema(description = "ID DO RESTAURANTE",
            example = "999999",
            title = "ID")
    private Long id;

    @Schema(description = "NOME DO RESTAURANTE",
            example = "NOME DE EXEMPLO",
            title = "NOME",
            maxLength = 15)
    private String nome;

    @Schema(description = "ENDERECO DO RESTAURANTE",
            example = "ENDERECO DO RESTAURANTE",
            title = "ENDERECO",
            maxLength = 100)
    private String endereco;

    @Schema(description = "TELEFONE DO RESTAURANTE",
            example = "TELEFONE DO RESTAURANTE",
            title = "TELEFONE",
            maxLength = 100)
    private String telefone;

    @Schema(description = "HORARIO DO RESTAURANTE",
            example = "HORARIO DO RESTAURANTE",
            title = "HORARIO",
            maxLength = 100)
    private String horario;

    @Schema(description = "EMAIL DO RESTAURANTE",
            example = "EMAIL DO RESTAURANTE",
            title = "EMAIL",
            maxLength = 100)
    private String email;

    @Schema(description = "CNPJ DO RESTAURANTE",
            example = "CNPJ DO RESTAURANTE",
            title = "CNPJ",
            maxLength = 100)
    private String cnpj;
}
