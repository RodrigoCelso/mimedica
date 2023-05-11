package com.ufmt.mimedica.atendimentoPaciente;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.ufmt.mimedica.atendimento.Atendimento;
import com.ufmt.mimedica.paciente.Paciente;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "atendimentoPaciente")
@SequenceGenerator(name = "seqAtendimentoPaciente", sequenceName = "seq_atendimentoPaciente_id", allocationSize = 1)
@Getter
@Setter
public class AtendimentoPaciente {
    @Id
    @GeneratedValue(generator = "seqAtendimentoPaciente", strategy = GenerationType.SEQUENCE)
    private int id;
    
    @ManyToOne
    @JoinColumn(name = "atendimento_id")
    private Atendimento atendimentoId;
    
    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente pacienteId;
}
