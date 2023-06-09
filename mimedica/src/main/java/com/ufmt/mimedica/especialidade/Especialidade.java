package com.ufmt.mimedica.especialidade;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.ufmt.mimedica.especialidadeMedico.EspecialidadeMedico;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "especialidade")
@SequenceGenerator(name = "seqEspecialidade", sequenceName = "seq_especialidade_id", allocationSize = 1)
@Getter
@Setter
public class Especialidade {
    @Id
    @GeneratedValue(generator = "seqEspecialidade", strategy = GenerationType.SEQUENCE)
    private int id;

    @Column
    private String tipo;
    
    @OneToMany(mappedBy = "especialidadeId")
    private List<EspecialidadeMedico> especialidadeMedicos;
}
