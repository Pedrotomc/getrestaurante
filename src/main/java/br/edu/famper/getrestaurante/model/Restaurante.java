package br.edu.famper.getrestaurante.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tbl_restaurante")
@Data
public class Restaurante {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "RES_COD")
    private Long id;

    @Column(name = "RES_NOM", length = 75)
    private String nome;

    @Column(name = "RES_END", length = 150)
    private String endereco;

    @Column(name = "RES_TEL", length = 150)
    private String  telefone;

    @Column(name = "RES_HOR", length = 150)
    private String  horario;

    @Column(name = "RES_EMA", length = 150)
    private String email;

    @Column(name = "RES_CNP", length = 150)
    private String cnpj;

}