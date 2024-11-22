package br.edu.famper.getrestaurante.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tbl_garcom")
@Data
public class Garcom {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "GAR_COD")
    private Long id;

    @Column(name = "GAR_NOM", length = 75)
    private String nome;

    @Column(name = "GAR_IDA", length = 150)
    private Float idade;

    @Column(name = "CLI_TEL", length = 150)
    private Float  telefone;

    @Column(name = "CLI_CPF", length = 150)
    private Float  cpf;

    @Column(name = "GAR_CAR", length = 150)
    private String carteira;

    @Column(name = "GAR_END", length = 150)
    private String endereco;

    @Column(name = "GAR_SAL", length = 150)
    private Float salario;

    @Column(name = "GAE_RES")
    private Long restarutante;

}
