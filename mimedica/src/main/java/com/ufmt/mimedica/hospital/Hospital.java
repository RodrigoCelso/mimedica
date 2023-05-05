package com.hospital;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "hospital")
@SequenceGenerator(name = "seqHospital", sequenceName = "seq_hosptital_id", allocationSize = 1)
@lombok.Getter
@lombok.Setter
public class Hospital {
    @Id
    @GeneratedValue(generator = "seqHospital", strategy = GenerationType.SEQUENCE)
    private int id;
    @Column
    private String nome;
    @Column
    private String cnpj;
}
