package com.ufmt.mimedica.pagamento;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.ufmt.mimedica.atendente.Atendente;
import com.ufmt.mimedica.paciente.Paciente;
import com.ufmt.mimedica.tipoPagamento.TipoPagamento;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "pagamento")
@SequenceGenerator(name = "seqPagamento", sequenceName = "seq_pagamento_id", allocationSize = 1)
@Getter
@Setter
public class Pagamento {
    @Id
    @GeneratedValue(generator = "seqPagamento", strategy = GenerationType.SEQUENCE)
    private int id;
    
    @Column
    private float valor;

    @ManyToOne
    @JoinColumn(name = "atendente_id")
    private Atendente atendenteId;

    @ManyToOne
    @JoinColumn(name = "tipoPagamento_id")
    private TipoPagamento tipoPagamentoId;
    
    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente pacienteId;
}
