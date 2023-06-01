package com.ufmt.mimedica.medico;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.ufmt.mimedica.atendimento.Atendimento;
import com.ufmt.mimedica.especialidadeMedico.EspecialidadeMedico;
import com.ufmt.mimedica.hospitalMedico.HospitalMedico;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "medico")
@SequenceGenerator(name = "seqMedico", sequenceName = "seq_medico_id", allocationSize = 1)
@Getter
@Setter
public class Medico {
    @Id
    @GeneratedValue(generator = "seqMedico", strategy = GenerationType.SEQUENCE)
    private int id;
    
    @Column
    private String nome;
    
    @Column
    private int crm;
    
    @OneToMany(mappedBy = "medicoId")
    private List<HospitalMedico> hospitaiMedicos;
    
    @OneToMany(mappedBy = "medicoId")
    private List<EspecialidadeMedico> especialidadeMedicos;
    
    @OneToMany(mappedBy = "medicoId")
    private List<Atendimento> atendimentos;
}
