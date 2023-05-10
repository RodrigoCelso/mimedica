package com.ufmt.mimedica.atendimentoPaciente;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "atendimentoPaciente")
@SequenceGenerator(name = "seqAtendimentoPaciente", sequenceName = "seq_atendimentoPaciente_id", allocationSize = 1)
@lombok.Getter
@lombok.Setter
public class AtendimentoPaciente {
    @Id
    @GeneratedValue(generator = "seqAtendimentoPaciente", strategy = GenerationType.SEQUENCE)
    private int id;
}
