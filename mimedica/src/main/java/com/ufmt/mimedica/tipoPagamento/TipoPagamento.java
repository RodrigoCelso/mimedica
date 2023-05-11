package com.ufmt.mimedica.tipoPagamento;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tipoPagamento")
@SequenceGenerator(name = "seqTipoPagamento", sequenceName = "", allocationSize = 1)
@lombok.Getter
@lombok.Setter
public class TipoPagamento {
    @Id
    @GeneratedValue(generator = "seqTipoPagamento", strategy = GenerationType.SEQUENCE)
    private int id;
    @Column
    private String tipo;
}
