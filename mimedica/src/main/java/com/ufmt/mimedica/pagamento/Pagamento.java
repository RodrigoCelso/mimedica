package com.ufmt.mimedica.pagamento;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "pagamento")
@SequenceGenerator(name = "seqPagamento", sequenceName = "seq_pagamento_id", allocationSize = 1)
public class Pagamento {
    @Id
    @GeneratedValue(generator = "seqPagamento", strategy = GenerationType.SEQUENCE)
    private int id;
    @Column
    private float valor;
}
