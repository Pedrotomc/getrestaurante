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
    private Long ID;

    @Column(name = "RES_NOM", length = 75)
    private String NOME;

    @Column(name = "RES_END", length = 150)
    private String ENDERECO;

    @Column(name = "RES_TEL", length = 150)
    private String  TELEFONE;

    @Column(name = "RES_HOR", length = 150)
    private String  HORARIO;

    @Column(name = "RES_EMA", length = 150)
    private String EMAIL;

    @Column(name = "RES_CNP", length = 150)
    private String CNPJ;

}