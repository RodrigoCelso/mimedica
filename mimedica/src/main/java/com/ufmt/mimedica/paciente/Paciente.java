package com.ufmt.mimedica.paciente;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "paciente")
@SequenceGenerator(name = "seqPaciente", sequenceName = "seq_paciente_id", allocationSize = 1)
@lombok.Getter
@lombok.Setter
public class Paciente {
    @Id
    @GeneratedValue(generator = "seqPaciente", strategy = GenerationType.SEQUENCE)
    private int id;
    @Column
    private String nome;
    @Column
    private int cpf;
    @Column
    private int cep;
    @Column
    private String complemento;
}
