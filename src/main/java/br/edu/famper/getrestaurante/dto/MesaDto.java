package br.edu.famper.getrestaurante.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MesaDto {
    @Schema(description = "NUMERO DA MESA",
            example = "99",
            title = "ID")
    private Long id;

}
