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
        private Long id;

        @Column(name = "CLI_NOM", length = 75)
        private String nome;

        @Column(name = "CLI_TEL", length = 150)
        private String  telefone;

        @Column(name = "CLI_EMA", length = 150)
        private String email;

        @Column(name = "CLI_PED", length = 150)
        private Integer pedido;
}
