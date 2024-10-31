package br.edu.famper.getrestaurante.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tbl_Cliente")
@Data
public class Cliente {
        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE)

        @Column(name = "CLI_COD")
        private Long ID;

        @Column(name = "CLI_NOM", length = 75)
        private String NOME;

        @Column(name = "CLI_TEL", length = 150)
        private String  TELEFONE;

        @Column(name = "CLI_EMA", length = 150)
        private String EMAIL;

        @Column(name = "CLI_PED", length = 150)
        private Integer PEDIDO;
}
