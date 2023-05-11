package com.ufmt.mimedica.atendimento;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.ufmt.mimedica.atendente.Atendente;
import com.ufmt.mimedica.atendimentoPaciente.AtendimentoPaciente;
import com.ufmt.mimedica.medico.Medico;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "atendimento")
@SequenceGenerator(name = "seqAtendimento", sequenceName = "seq_atendimento_id", allocationSize = 1)
@Getter
@Setter
public class Atendimento {
    @Id
    @GeneratedValue(generator = "seqAtendimento", strategy = GenerationType.SEQUENCE)
    private int id;
    
    @ManyToOne
    @JoinColumn(name = "medico_id")
    private Medico medicoId;
    
    @ManyToOne
    @JoinColumn(name = "atendente_id")
    private Atendente atendenteId;
    
    @OneToMany(mappedBy = "atendimentoId")
    private List<AtendimentoPaciente> atendimentoPacientes;
}
