package com.ufmt.mimedica.especialidadeMedico;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.ufmt.mimedica.especialidade.Especialidade;
import com.ufmt.mimedica.medico.Medico;

@Entity
@Table(name = "especialidadeMedico")
@SequenceGenerator(name = "seqEspecialidadeMedico", sequenceName = "seq_especialidadeMedico_id", allocationSize = 1)
@lombok.Getter
@lombok.Setter
public class EspecialidadeMedico {
    @Id
    @GeneratedValue(generator = "seqEspecialidadeMedico")
    private int id;
    @ManyToOne
    @JoinColumn(name = "especialidade_id")
    private Especialidade especialidadeId;
    @ManyToOne
    @JoinColumn(name = "medico_id")
    private Medico medicoId;
}
