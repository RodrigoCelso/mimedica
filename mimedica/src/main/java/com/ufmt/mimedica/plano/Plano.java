package com.ufmt.mimedica.plano;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.ufmt.mimedica.paciente.Paciente;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "plano")
@SequenceGenerator(name = "seqPlano", sequenceName = "seq_plano_id", allocationSize = 1)
@Getter
@Setter
public class Plano {
    @Id
    @GeneratedValue(generator = "seqPlano", strategy = GenerationType.SEQUENCE)
    private int id;
    
    // Funciona??
    @Column
    private List<String> tratamentos;

    @OneToMany(mappedBy = "planoId")
    private List<Paciente> pacientes;
}
