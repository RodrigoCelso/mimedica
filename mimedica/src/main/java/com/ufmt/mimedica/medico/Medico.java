package com.ufmt.mimedica.medico;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "medico")
@SequenceGenerator(name = "seqMedico", sequenceName = "seq_medico_id", allocationSize = 1)
@lombok.Getter
@lombok.Setter
public class Medico {
    
    @Id
    @GeneratedValue(generator = "seqMedico", strategy = GenerationType.SEQUENCE)
    private int id;
    @Column
    private String nome;
    @Column
    private int crm;
}
