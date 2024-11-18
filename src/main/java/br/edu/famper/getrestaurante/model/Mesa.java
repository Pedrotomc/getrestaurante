package br.edu.famper.getrestaurante.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tbl_mesa")
@Data
public class Mesa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "MES_NUM")
    private Long id;
}
