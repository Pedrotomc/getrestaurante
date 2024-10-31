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
    private Long ID;

    @Column(name = "GAR_NOM", length = 75)
    private String NOME;

    @Column(name = "CLI_TEL", length = 150)
    private String  TELEFONE;

    @Column(name = "CLI_CPF", length = 150)
    private Float  CPF;

    @Column(name = "GAR_IDA", length = 150)
    private String IDADE;

    @Column(name = "GAR_CAR", length = 150)
    private String CARTEIRA;

    @Column(name = "GAR_END", length = 150)
    private String ENDERECO;

    @Column(name = "GAR_SAL", length = 150)
    private Float SALARIO;

}
