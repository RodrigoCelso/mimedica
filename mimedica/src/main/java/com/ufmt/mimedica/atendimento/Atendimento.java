package com.ufmt.mimedica.atendimento;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.ufmt.mimedica.medico.Medico;

@Entity
@Table(name = "atendimento")
@SequenceGenerator(name = "seqAtendimento", sequenceName = "seq_atendimento_id", allocationSize = 1)
@lombok.Getter
@lombok.Setter
public class Atendimento {
    @Id
    @GeneratedValue(generator = "seqAtendimento", strategy = GenerationType.SEQUENCE)
    private int id;
    @ManyToOne
    @JoinColumn(name = "medico_id")
    private Medico medicoId;
}
