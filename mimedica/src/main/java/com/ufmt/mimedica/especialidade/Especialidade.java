package com.ufmt.mimedica.especialidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "especialidade")
@SequenceGenerator(name = "seqEspecialidade", sequenceName = "seq_especialidade_id", allocationSize = 1)
@lombok.Getter
@lombok.Setter
public class Especialidade {
    @Id
    @GeneratedValue(generator = "seqEspecialidade", strategy = GenerationType.SEQUENCE)
    private int id;
    @Column
    private String tipo;
}
