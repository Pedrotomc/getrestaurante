package br.edu.famper.getrestaurante.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GarcomDto {
    @Schema(description = "ID DO GARCOM",
            example = "1",
            title = "ID")
    private Long id;

    @Schema(description = "NOME DO GARCOM",
            example = "Ampere",
            title = "NOME",
            maxLength = 150)
    private String nome;


    @Schema(description = "TELEFONE DO GARCOM",
            example = "+55 45 99999-8888",
            title = "TELEFONE",
            maxLength = 15)
    private String telefone;

    @Schema(description = "CPF DO GARCOM",
            example = "999.999.999-99",
            title = "CPF",
            maxLength = 100)
    private String cpf;

    @Schema(description = "IDADE DO GARCOM",
            example = "000",
            title = "IDADE",
            maxLength = 100)
    private String idade;

    @Schema(description = "CARTEIRA DO GARCOM",
            example = "9999999999999",
            title = "CARTEIRA",
            maxLength = 100)
    private String carteira;

    @Schema(description = "ENDERECO DO GARCOM",
            example = "CENTRO 9999",
            title = "ENDERECO",
            maxLength = 100)
    private String endereco;

    @Schema(description = "SALARIO DO GARCOM",
            example = "R$ 999.999,99",
            title = "SALARIO",
            maxLength = 100)
    private String salario;
}
