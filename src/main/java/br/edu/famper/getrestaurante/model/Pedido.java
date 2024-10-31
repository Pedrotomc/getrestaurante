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
    private Long ID;

    @Column(name = "PED_HOR", length = 6)
    private Date HORA;

    @Column(name = "PED_DET", length = 75)
    private String DETALHE;

    @Column(name = "PED_OBS", length = 150)
    private String OBSERVACAO;

    @Column(name = "PED_PRA", length = 150)
    private String  PRATOS;

    @Column(name = "PED_CLI", length = 150)
    private String CLIENTE;

    @Column(name = "PED_MESA", length = 150)
    private Integer MESA;

}
