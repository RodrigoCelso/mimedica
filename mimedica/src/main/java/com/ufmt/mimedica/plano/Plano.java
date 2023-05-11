package com.ufmt.mimedica.plano;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "plano")
@SequenceGenerator(name = "seqPlano", sequenceName = "seq_plano_id", allocationSize = 1)
@lombok.Getter
@lombok.Setter
public class Plano {
    @Id
    @GeneratedValue(generator = "seqPlano", strategy = GenerationType.SEQUENCE)
    private int id;
    // Funciona??
    @Column
    private List<String> tratamentos;
}
