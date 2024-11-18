package br.edu.famper.getrestaurante.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "tbl_pedido")
@Data
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    @Column(name = "PED_COD")
    private Long id;

    @Column(name = "PED_HOR", length = 6)
    private Date hora;

    @Column(name = "PED_DET", length = 75)
    private String detalhe;

    @Column(name = "PED_OBS", length = 150)
    private String observacao;

    @Column(name = "PED_PRA", length = 150)
    private String  pratos;

    @Column(name = "PED_CLI", length = 150)
    private String cliente;

    @Column(name = "PED_MESA", length = 150)
    private Integer mesa;

}
