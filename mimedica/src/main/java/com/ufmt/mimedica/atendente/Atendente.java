package com.ufmt.mimedica.atendente;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "atendente")
@SequenceGenerator(name = "seqAtendente", sequenceName = "seq_atendente_id", allocationSize = 1)
@lombok.Getter
@lombok.Setter
public class Atendente {
    @Id
    @GeneratedValue(generator = "seqAtendente", strategy = GenerationType.SEQUENCE)
    private int id;
    @Column
    private String nome;
    @Column
    private int cpf;
}
