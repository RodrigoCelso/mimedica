package com.ufmt.mimedica.hospital;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.ufmt.mimedica.hospitalMedico.HospitalMedico;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "hospital")
@SequenceGenerator(name = "seqHospital", sequenceName = "seq_hosptital_id", allocationSize = 1)
@Getter
@Setter
public class Hospital {
    @Id
    @GeneratedValue(generator = "seqHospital", strategy = GenerationType.SEQUENCE)
    private int id;
    
    @Column
    private String nome;
    
    @Column
    private String cnpj;

    @OneToMany(mappedBy = "hospitalId")
    private List<HospitalMedico> hospitalMedicos;
}
